/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.Publication;

/**
 *
 * @author Birkhoff
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT new tg.dksoft.publication.dto.AuthorDTO(a) FROM Author a "
            + "JOIN a.authorPublications ap WHERE ap.publication = :publication")
    public List<AuthorDTO> findAuthorsByPublication(Publication publication);
}
