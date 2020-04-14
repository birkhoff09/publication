/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.dto.PublicationDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.AuthorPublication;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.service.IAuthorPublicationService;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.service.IBlogPostService;
import tg.dksoft.publication.service.IBookService;
import tg.dksoft.publication.utils.ResponseEntityUtil;

/**
 *
 * @author Birkhoff
 */
@RestController
@RequestMapping(path = "/rest/book")
public class BookController {

    IBookService service;
    IBlogPostService blogPostService;
    IAuthorService authorService;
    IAuthorPublicationService authorPublicationService;

    @Autowired
    public BookController(IBookService service, IBlogPostService blogPostService, IAuthorService authorService, IAuthorPublicationService authorPublicationService) {
        this.service = service;
        this.blogPostService = blogPostService;
        this.authorService = authorService;
        this.authorPublicationService = authorPublicationService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<BookDTO>> getBookList(@RequestHeader(name = "page", defaultValue = "0") int page, @RequestHeader(name = "size", defaultValue = "-1") int size) {
        List<BookDTO> bookDTOs;
        if (size <= 0) {
            bookDTOs = service.findAll().stream().map(book -> {
                return new BookDTO(book);
            }).collect(Collectors.toList());
            return ResponseEntityUtil.createGetResponseEntity(bookDTOs);
        } else {
            Page<Book> bookPage = service.findByPage(PageRequest.of(page, size));
            bookDTOs = bookPage.toList().stream().map(book -> {
                return new BookDTO(book);
            }).collect(Collectors.toList());
            return ResponseEntityUtil.createGetPageResponseEntity(bookDTOs, bookPage.getTotalPages(), bookPage.getTotalElements());
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PublicationDTO> getPublication(@PathVariable Long id) {
        return ResponseEntityUtil.createGetResponseEntity(new PublicationDTO(service.find(id)));
    }

    @RequestMapping(path = "/{id}/authors", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDTO>> getPublicationAuthors(@PathVariable Long publicationId) {
        return ResponseEntityUtil.createGetResponseEntity(this.authorService.findAuthorsByPublication(publicationId));
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book();
        book.setPages(bookDTO.getPages());
        book.setTitle(bookDTO.getTitle());
        book.setDatePublication(bookDTO.getDatePublication());
        Set<AuthorPublication> authorPublications = new HashSet<>();
        bookDTO.getAuthors().forEach(authorDto -> {
            AuthorPublication ap = new AuthorPublication();
            Author author = new Author();
            author.setId(authorDto.getAuthorId());
            ap.setAuthor(author);
            ap.setPublication(book);
            authorPublications.add(ap);
        });
        book.setAuthorPublications(authorPublications);
        return ResponseEntityUtil.createPostResponseEntity(new BookDTO(this.service.save(book)));
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book book = this.service.find(id);
        book.setPages(bookDTO.getPages());
        book.setTitle(bookDTO.getTitle());
        book.setDatePublication(bookDTO.getDatePublication());
        return ResponseEntityUtil.createPutResponseEntity(new BookDTO(this.service.update(book)));
    }

    @RequestMapping(path = "/update/{id}/authors", method = RequestMethod.PUT)
    public ResponseEntity<BookDTO> updateBookAuthors(@PathVariable Long id, @RequestBody List<AuthorDTO> authorDTOs) {
        Book book = this.service.find(id);
        this.authorPublicationService.deleteByPublication(book.getId());
        Set<AuthorPublication> authorPublications = new HashSet<>();
        authorDTOs.forEach(authorDto -> {
            AuthorPublication ap = new AuthorPublication();
            Author author = new Author();
            author.setId(authorDto.getAuthorId());
            ap.setAuthor(author);
            ap.setPublication(book);
            authorPublications.add(ap);
        });
        book.setAuthorPublications(authorPublications);
        return ResponseEntityUtil.createPutResponseEntity(new BookDTO(this.service.update(book)));
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = this.service.find(id);
        this.service.delete(book);
        return ResponseEntityUtil.createDeleteResponseEntity();
    }
}
