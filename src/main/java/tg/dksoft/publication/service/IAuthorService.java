/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tg.dksoft.publication.dto.AuthorDTO;
import tg.dksoft.publication.model.Author;

/**
 *
 * @author Birkhoff
 */
public interface IAuthorService extends IService<Long, Author> {

    /**
     *
     * @param pageable
     * @return
     */
    Page<Author> findByPage(Pageable pageable);

    public List<AuthorDTO> findAuthorsByPublication(Long publicationId);
}
