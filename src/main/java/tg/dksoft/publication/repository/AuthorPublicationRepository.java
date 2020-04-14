/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tg.dksoft.publication.model.AuthorPublication;
import tg.dksoft.publication.model.Publication;

/**
 *
 * @author Birkhoff
 */
public interface AuthorPublicationRepository extends JpaRepository<AuthorPublication, Long> {

    public List<AuthorPublication> findByPublication_Id(Long publicationId);

    public void deleteByPublication(Publication publication);
}
