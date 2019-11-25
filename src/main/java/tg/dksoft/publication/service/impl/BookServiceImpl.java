/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.repository.BookRepository;
import tg.dksoft.publication.repository.IBookRepository;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IBookService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class BookServiceImpl extends ServiceImpl<Long, Book> implements IBookService {

    BookRepository repository;
    IBookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository repository, IBookRepository bookRepository, IGenericRepository<Book> genericRepository) {
        super(Book.class, genericRepository);
        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getBookByAuthor(Long authorId, Pageable pageable) {
//        return this.bookRepository.findBookByAuthor(authorId, pageable);
        return this.repository.findBookByAuthor(authorId, pageable);
    }

}
