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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.dto.PublicationDTO;
import tg.dksoft.publication.model.Publication;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.service.IBlogPostService;
import tg.dksoft.publication.service.IBookService;
import tg.dksoft.publication.service.IPublicationService;
import tg.dksoft.publication.utils.ResponseEntityUtil;

/**
 *
 * @author Birkhoff
 */
@RestController
@RequestMapping(path = "/rest/publication")
public class PublicationController {

    IPublicationService service;
    IBookService bookService;
    IBlogPostService blogPostService;
    IAuthorService authorService;

    @Autowired
    public PublicationController(IPublicationService service, IBookService bookService, IBlogPostService blogPostService, IAuthorService authorService) {
        this.service = service;
        this.bookService = bookService;
        this.blogPostService = blogPostService;
        this.authorService = authorService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PublicationDTO>> getPublicationList(@RequestHeader(name = "page", defaultValue = "0") int page, @RequestHeader(name = "size", defaultValue = "-1") int size) {
        List<PublicationDTO> publicationDTOs;
        if (size <= 0) {
            publicationDTOs = service.findAll().stream().map(publication -> {
                return new PublicationDTO(publication);
            }).collect(Collectors.toList());
            return ResponseEntityUtil.createGetResponseEntity(publicationDTOs);
        } else {
            Page<Publication> publicationPage = service.findByPage(PageRequest.of(page, size));
            publicationDTOs = publicationPage.toList().stream().map(publication -> {
                return new PublicationDTO(publication);
            }).collect(Collectors.toList());
            return ResponseEntityUtil.createGetPageResponseEntity(publicationDTOs, publicationPage.getTotalPages(), publicationPage.getTotalElements());
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
}
