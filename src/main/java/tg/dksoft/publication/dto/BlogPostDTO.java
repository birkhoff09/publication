/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Set;
import tg.dksoft.publication.enums.PublicationTypeEnum;
import tg.dksoft.publication.model.BlogPost;

/**
 *
 * @author Birkhoff
 */
public class BlogPostDTO extends PublicationDTO {

    String url;

    public BlogPostDTO(String url, BlogPost blogPost) {
        super(blogPost);
        this.url = url;
        super.setTypePublication(PublicationTypeEnum.BLOG_POST.value());
    }

    public BlogPostDTO(Long blogPostId, String url, String title, Date datePublication) {
        super(title, datePublication);
        this.publicationId = blogPostId;
        this.url = url;
        super.setTypePublication(PublicationTypeEnum.BLOG_POST.value());
    }

    public BlogPostDTO(Long blogPostId, String url, String title, Date datePublication, Set<AuthorDTO> authors) {
        super(title, datePublication, authors);
        this.publicationId = blogPostId;
        this.url = url;
        super.setTypePublication(PublicationTypeEnum.BLOG_POST.value());
    }

    @JsonProperty("blog_post_id")
    @Override
    public Long getPublicationId() {
        return this.publicationId;
    }

    public void setPublication(Long publicationId) {
        this.publicationId = publicationId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
