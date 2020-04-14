/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tg.dksoft.publication.exceptions.DocumentNotFoundException;
import tg.dksoft.publication.model.AuthorPublication;
import tg.dksoft.publication.model.Publication;
import tg.dksoft.publication.repository.AuthorPublicationRepository;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.PublicationRepository;
import tg.dksoft.publication.service.IAuthorPublicationService;

@Repository
public class AuthorPublicationServiceImpl extends ServiceImpl<Long, AuthorPublication> implements IAuthorPublicationService {
    
    AuthorPublicationRepository repository;
    PublicationRepository publicationRepository;
    
    @Autowired
    public AuthorPublicationServiceImpl(IGenericRepository<Long, AuthorPublication> genericRepository, AuthorPublicationRepository repository, PublicationRepository publicationRepository) {
        super(AuthorPublication.class, genericRepository);
        this.repository = repository;
        this.publicationRepository = publicationRepository;
    }

    /**
     * FInd auhor of the publication
     *
     * @param publicationId
     * @return
     */
    @Override
    public List<AuthorPublication> findByPublication(Long publicationId) {
        return this.repository.findByPublication_Id(publicationId);
    }
    
    @Override
    public void deleteByPublication(Long publicationId) {
        Publication publication = this.publicationRepository.findById(publicationId).orElseGet(() -> new DocumentNotFoundException());
        this.repository.deleteByPublication(publication);
    }
    
}
