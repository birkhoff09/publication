/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository.impl;

import java.util.List;
import javax.persistence.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tg.dksoft.publication.dto.BookDTO;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.repository.IBookRepository;

/**
 *
 * @author Birkhoff
 */
@Repository
public class BookRepositoryImpl extends GenericRepositoryImpl<Book> implements IBookRepository<Book, Long> {

    @Override
    public List<BookDTO> findBookByAuthor(Long authorId, Pageable pageable) {
        Query query = this.createSqlQuery("SELECT p.pages,p.title, p.date_publication, p.type_publication "
                + "From publication p where p.id IN (SELECT ap.publication_id FROM author_publication ap where ap.author_id =:authorId)");
        return query.setParameter("authorId", authorId).getResultList();
    }
}
