/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import java.util.List;
import tg.dksoft.publication.model.AuthorPublication;

/**
 *
 * @author Birkhoff
 */
public interface IAuthorPublicationService extends IService<Long, AuthorPublication> {

    public List<AuthorPublication> findByPublication(Long publicationId);

    public void deleteByPublication(Long publicationId);

}
