/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.service.IBlogPostService;
import tg.dksoft.publication.service.IBookService;
import tg.dksoft.publication.utils.ResponseEntityUtil;

/**
 *
 * @author Birkhoff
 */
@RestController
@RequestMapping(path = "/rest/author", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {
        return ResponseEntityUtil.createGetResponseEntity(new AuthorDTO(service.find(id)));
    }

    @RequestMapping(path = "/{id}/books", method = RequestMethod.GET)
    public ResponseEntity<BookDTO> getAuthorBooks(@PathVariable(name = "id") Long authorId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntityUtil.createGetResponseEntity(this.bookService.getBookByAuthor(authorId, PageRequest.of(page, size)));
    }

    @RequestMapping(path = "/{id}/blogposts", method = RequestMethod.GET)
    public ResponseEntity<BlogPostDTO> getAuthorBlogPosts(@PathVariable(name = "id") Long authorId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntityUtil.createGetResponseEntity(this.blogPostService.getBlogPostByAuthor(authorId, PageRequest.of(page, size)));
    }
}
