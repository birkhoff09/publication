/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.dto.BlogPostDTO;
import tg.dksoft.publication.model.BlogPost;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IBlogPostService;
import tg.dksoft.publication.repository.BlogPostRepository;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class BlogPostServiceImpl extends ServiceImpl<Long, BlogPost> implements IBlogPostService {

    BlogPostRepository repository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository repository, IGenericRepository<BlogPost> genericRepository) {
        super(BlogPost.class, genericRepository);
        this.repository = repository;
    }

    @Override
    public List<BlogPostDTO> getBlogPostByAuthor(Long authorId, Pageable pageable) {
        return repository.findBlogPostByAuthor(authorId, pageable);
    }

}
