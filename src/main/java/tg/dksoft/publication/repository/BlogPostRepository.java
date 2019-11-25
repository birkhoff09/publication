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
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.model.BlogPost;

/**
 *
 * @author Birkhoff
 */
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    @Query(value = "SELECT new tg.dksoft.publication.dto.BlogPostDTO(p.url,p.title, p.datePublication, 'Blog') "
            + "From publication p JOIN p.authors ap where ap.id =:authorId")
    List<BlogPostDTO> findBlogPostByAuthor(Long authorId, Pageable pageable);
}
