/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.Publication;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.PublicationRepository;
import tg.dksoft.publication.service.IPublicationService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class PublicationServiceImpl extends ServiceImpl<Long, Publication> implements IPublicationService {

    PublicationRepository repository;

    @Autowired
    public PublicationServiceImpl(PublicationRepository repository, IGenericRepository<Publication> genericRepository) {
        super(Publication.class, genericRepository);
        this.repository = repository;
    }

}
