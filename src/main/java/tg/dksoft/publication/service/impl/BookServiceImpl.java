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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.repository.AuthorRepository;
import tg.dksoft.publication.repository.BookRepository;
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
    AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository, IGenericRepository<Long, Book> genericRepository) {
        super(Book.class, genericRepository);
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getBookByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            return Collections.EMPTY_LIST;
        }
        return this.repository.findBooksByAuthor(author);
    }

    @Override
    public Page<BookDTO> getBookByAuthor(Long authorId, Pageable pageable) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            return new PageImpl<>(Collections.EMPTY_LIST, pageable, 0);
        }
        return this.repository.findBooksByAuthor(author, pageable);
    }

    @Override
    public Page<Book> findByPage(PageRequest pageRequest) {
        return this.repository.findAll(pageRequest);
    }

}
