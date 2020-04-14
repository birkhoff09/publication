/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.Publication;
import tg.dksoft.publication.repository.AuthorRepository;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.PublicationRepository;
import tg.dksoft.publication.service.IAuthorService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class AuthorServiceImpl extends ServiceImpl<Long, Author> implements IAuthorService {

    AuthorRepository repository;
    PublicationRepository publicationRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository, PublicationRepository publicationRepository, IGenericRepository<Long, Author> genericRepository) {
        super(Author.class, genericRepository);
        this.repository = repository;
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Page<Author> findByPage(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<AuthorDTO> findAuthorsByPublication(Long publicationId) {

        Publication publication = this.publicationRepository.findById(publicationId).orElse(null);
        if (publication == null) {
            return Collections.EMPTY_LIST;
        } else {
            return this.repository.findAuthorsByPublication(publication);
        }
    }

}
