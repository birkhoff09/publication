/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.BlogPost;
import tg.dksoft.publication.repository.AuthorRepository;
import tg.dksoft.publication.repository.BlogPostRepository;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IBlogPostService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class BlogPostServiceImpl extends ServiceImpl<Long, BlogPost> implements IBlogPostService {

    BlogPostRepository repository;
    AuthorRepository authorRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository repository, AuthorRepository authorRepository, IGenericRepository<Long, BlogPost> genericRepository) {
        super(BlogPost.class, genericRepository);
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Page<BlogPostDTO> getBlogPostByAuthor(Long authorId, Pageable pageable) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            return new PageImpl<>(Collections.EMPTY_LIST, pageable, 0);
        }
        return repository.findBlogPostsByAuthor(author, pageable);
    }

    @Override
    public List<BlogPostDTO> getBlogPostByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            return Collections.EMPTY_LIST;
        }
        return repository.findBlogPostsByAuthor(author);
    }

}
