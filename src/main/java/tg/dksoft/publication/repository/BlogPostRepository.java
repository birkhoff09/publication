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
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.BlogPost;

/**
 *
 * @author Birkhoff
 */
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    @Query(value = "SELECT new tg.dksoft.publication.dto.BlogPostDTO(b.id, b.url, b.title, b.datePublication) "
            + "From BlogPost b WHERE :author MEMBER OF b.authorPublications ")
    Page<BlogPostDTO> findBlogPostsByAuthor(Author author, Pageable pageable);

    @Query(value = "SELECT new tg.dksoft.publication.dto.BlogPostDTO(b.id, b.url, b.title, b.datePublication) "
            + "From BlogPost b WHERE :author MEMBER OF b.authorPublications ")
    List<BlogPostDTO> findBlogPostsByAuthor(Author author);
}
