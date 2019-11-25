/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import tg.dksoft.publication.dto.BookDTO;

/**
 *
 * @author Birkhoff
 * @param <Book>
 * @param <Long>
 */
public interface IBookRepository<Book, Long> {

    List<BookDTO> findBookByAuthor(Long authorId, Pageable pageable);
//    @Query(value = "SELECT new tg.dksoft.publication.dto.BookDTO(p.pages,p.title, p.datePublication, '') "
//            + "From Book p where p.id IN (SELECT ap.publication_id FROM author_publication ap where ap.author_id =:authorId)")
//    List<BookDTO> findBookByAuthor(Long authorId, Pageable pageable);
}
