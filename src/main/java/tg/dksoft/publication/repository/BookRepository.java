/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.Book;

/**
 *
 * @author Birkhoff
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT new tg.dksoft.publication.dto.BookDTO(b.id, b.pages, b.title, b.datePublication) "
            + "From Book b JOIN b.authorPublications ap WHERE ap.author=:author")
    Page<BookDTO> findBooksByAuthor(Author author, Pageable pageable);

    @Query(value = "SELECT new tg.dksoft.publication.dto.BookDTO(b.id, b.pages, b.title, b.datePublication) "
            + "From Book b JOIN b.authorPublications ap WHERE ap.author=:author")
    List<BookDTO> findBooksByAuthor(Author author);
}
