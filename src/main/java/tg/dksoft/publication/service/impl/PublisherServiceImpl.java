/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.Publisher;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.PublisherRepository;
import tg.dksoft.publication.service.IPublisherService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class PublisherServiceImpl extends ServiceImpl<Long, Publisher> implements IPublisherService {

    PublisherRepository repository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository repository, IGenericRepository<Publisher> genericRepository) {
        super(Publisher.class, genericRepository);
        this.repository = repository;
    }

}
