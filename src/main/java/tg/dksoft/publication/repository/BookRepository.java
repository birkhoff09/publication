/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Book;

/**
 *
 * @author Birkhoff
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT new tg.dksoft.publication.dto.BookDTO(p.pages,p.title, p.datePublication, 'Book') "
            + "From publication p JOIN p.authors ap where ap.id =:authorId")
    List<BookDTO> findBookByAuthor(Long authorId, Pageable pageable);
}
