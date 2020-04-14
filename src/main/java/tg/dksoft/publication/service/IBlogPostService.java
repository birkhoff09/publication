/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.model.BlogPost;

/**
 *
 * @author Birkhoff
 */
public interface IBlogPostService extends IService<Long, BlogPost> {

    /**
     *
     * @param authorId
     * @param pageable
     * @return
     */
    public Page<BlogPostDTO> getBlogPostByAuthor(Long authorId, Pageable pageable);

    /**
     *
     * @param authorId
     * @return
     */
    public List<BlogPostDTO> getBlogPostByAuthor(Long authorId);
}
