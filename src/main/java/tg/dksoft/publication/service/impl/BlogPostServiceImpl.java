/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.BlogPost;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IBlogPostService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class BlogPostServiceImpl extends ServiceImpl<Long, BlogPost> implements IBlogPostService {

    @Autowired
    public BlogPostServiceImpl(IGenericRepository<BlogPost> genericRepository) {
        super(BlogPost.class, genericRepository);
    }

}
