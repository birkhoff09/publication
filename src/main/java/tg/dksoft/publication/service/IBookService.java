/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Book;

/**
 *
 * @author Birkhoff
 */
public interface IBookService extends IService<Long, Book> {

    /**
     *
     * @param authorId
     * @param pageable
     * @return
     */
    public Page<BookDTO> getBookByAuthor(Long authorId, Pageable pageable);

    /**
     *
     * @param authorId
     * @return
     */
    public List<BookDTO> getBookByAuthor(Long authorId);

    /**
     *
     * @param pageRequest
     * @return
     */
    public Page<Book> findByPage(PageRequest pageRequest);
}
