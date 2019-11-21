/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IBookService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class BookServiceImpl extends ServiceImpl<Long, Book> implements IBookService {

    @Autowired
    public BookServiceImpl(IGenericRepository<Book> genericRepository) {
        super(Book.class, genericRepository);
    }

}
