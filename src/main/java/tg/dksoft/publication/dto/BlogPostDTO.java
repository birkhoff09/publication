/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import java.util.Date;
import java.util.Set;
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
    }

    public BlogPostDTO(String url, String title, Date datePublication, String typePublication) {
        super(title, datePublication, typePublication);
        this.url = url;
    }

    public BlogPostDTO(String url, String title, Date datePublication, String typePublication, Set<AuthorDTO> authors) {
        super(title, datePublication, typePublication, authors);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
