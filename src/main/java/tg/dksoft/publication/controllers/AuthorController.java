/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.controllers;

import java.util.List;
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
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.service.IBlogPostService;
import tg.dksoft.publication.service.IBookService;
import tg.dksoft.publication.utils.ResponseEntityUtil;

/**
 *
 * @author Birkhoff
 */
@RestController
@RequestMapping(path = "/rest/author")
public class AuthorController {

    IAuthorService service;

    IBookService bookService;

    IBlogPostService blogPostService;

    @Autowired
    public AuthorController(IAuthorService service, IBookService bookService, IBlogPostService blogPostService) {
        this.service = service;
        this.bookService = bookService;
        this.blogPostService = blogPostService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDTO>> getAuthorList(@RequestHeader(name = "page", defaultValue = "0") int page, @RequestHeader(name = "size", defaultValue = "-1") int size) {
        List<AuthorDTO> authorDTOs;
        if (size <= 0) {
            authorDTOs = service.findAll().stream().map(author -> {
                return new AuthorDTO(author);
            }).collect(Collectors.toList());
            return ResponseEntityUtil.createGetResponseEntity(authorDTOs);
        } else {
            Page<Author> authorPage = service.findByPage(PageRequest.of(page, size));
            authorDTOs = authorPage.toList().stream().map(author -> {
                return new AuthorDTO(author);
            }).collect(Collectors.toList());
            return ResponseEntityUtil.createGetPageResponseEntity(authorDTOs, authorPage.getTotalPages(), authorPage.getTotalElements());
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {
        return ResponseEntityUtil.createGetResponseEntity(new AuthorDTO(service.find(id)));
    }

    @RequestMapping(path = "/{id}/books", method = RequestMethod.GET)
    public ResponseEntity<BookDTO> getAuthorBooks(@PathVariable(name = "id") Long authorId, @RequestHeader(name = "page", defaultValue = "0") int page, @RequestHeader(name = "size", defaultValue = "-1") int size) {
        if (size <= 0) {
            return ResponseEntityUtil.createGetResponseEntity(this.bookService.getBookByAuthor(authorId));
        } else {
            Page p = this.bookService.getBookByAuthor(authorId, PageRequest.of(page, size));
            return ResponseEntityUtil.createGetPageResponseEntity(p.toList(), p.getTotalPages(), p.getTotalElements());
        }
    }

    @RequestMapping(path = "/{id}/blogposts", method = RequestMethod.GET)
    public ResponseEntity<BlogPostDTO> getAuthorBlogPosts(@PathVariable(name = "id") Long authorId, @RequestHeader(defaultValue = "0") int page, @RequestHeader(defaultValue = "-1") int size) {
        if (size <= 0) {
            return ResponseEntityUtil.createGetResponseEntity(this.blogPostService.getBlogPostByAuthor(authorId));
        } else {
            Page p = this.blogPostService.getBlogPostByAuthor(authorId, PageRequest.of(page, size));
            return ResponseEntityUtil.createGetPageResponseEntity(p.toList(), p.getTotalPages(), p.getTotalElements());
        }
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<AuthorDTO> saveAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        return ResponseEntityUtil.createPostResponseEntity(new AuthorDTO(this.service.save(author)));
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        Author author = this.service.find(id);
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        return ResponseEntityUtil.createPutResponseEntity(new AuthorDTO(this.service.update(author)));
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        Author author = this.service.find(id);
        this.service.delete(author);
        return ResponseEntityUtil.createDeleteResponseEntity();
    }
}
