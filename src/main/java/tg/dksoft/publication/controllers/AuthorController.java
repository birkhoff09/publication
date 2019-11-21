/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.utils.ResponseEntityUtil;

/**
 *
 * @author Birkhoff
 */
@RestController
@RequestMapping(path = "/author", consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    IAuthorService service;

    @Autowired
    public AuthorController(IAuthorService service) {
        this.service = service;
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {
        return  ResponseEntityUtil.createGetResponseEntity(new AuthorDTO(service.find(id)));
    }
}
