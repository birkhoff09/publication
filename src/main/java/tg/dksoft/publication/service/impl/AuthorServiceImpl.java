/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.repository.AuthorRepository;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class AuthorServiceImpl extends ServiceImpl<Long, Author> implements IAuthorService {

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository, IGenericRepository<Author> genericRepository) {
        super(Author.class, genericRepository);
    }

}
