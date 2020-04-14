/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import tg.dksoft.publication.enums.PublicationTypeEnum;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.model.Publication;

/**
 *
 * @author Birkhoff
 */
public class PublicationDTO {

    protected Long publicationId;
    protected String title;
    protected Date datePublication;
    private String typePublication;
    protected Set<AuthorDTO> authors;

    public PublicationDTO(Publication publication) {
        this.title = publication.getTitle();
        this.datePublication = publication.getDatePublication();
        if (publication instanceof Book) {
            typePublication = PublicationTypeEnum.BOOK.value();
        } else {
            typePublication = PublicationTypeEnum.BLOG_POST.value();
        }
        this.publicationId = publication.getId();
//        this.authors = new HashSet<>();
//        publication.getAuthors().forEach(author -> {
//            this.authors.add(new AuthorDTO(author.getFirstName(), author.getLastName()));
//        });
    }

    public PublicationDTO(String title, Date datePublication) {
        this.title = title;
        this.datePublication = datePublication;
    }

    public PublicationDTO(String title, Date datePublication, Set<AuthorDTO> authors) {
        this.title = title;
        this.datePublication = datePublication;
        this.authors = authors;
    }

    @JsonProperty("publication_id")
    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty(value = "date_publication")
    public Date getDatePublication() {
        return datePublication;
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @JsonProperty(value = "type_publication")
    protected String getTypePublication() {
        return typePublication;
    }

    protected void setTypePublication(String typePublication) {
        this.typePublication = typePublication;
    }

    public Set<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDTO> authors) {
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.datePublication);
        hash = 71 * hash + Objects.hashCode(this.authors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PublicationDTO other = (PublicationDTO) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.datePublication, other.datePublication)) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        return true;
    }

}
