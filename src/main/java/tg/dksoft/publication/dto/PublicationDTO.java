/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import tg.dksoft.publication.model.Publication;

/**
 *
 * @author Birkhoff
 */
public class PublicationDTO {

    private String title;
    private Date datePublication;
    private Set<AuthorDTO> authors;

    public PublicationDTO(Publication publication) {
        this.title = publication.getTitle();
        this.datePublication = publication.getDatePublication();
        this.authors = new HashSet<>();
        publication.getAuthors().forEach(author -> {
            this.authors.add(new AuthorDTO(author.getFirstName(), author.getLastName()));
        });
    }

    PublicationDTO(String title, Date datePublication) {
        this.title = title;
        this.datePublication = datePublication;
    }

    public PublicationDTO(String title, Date datePublication, Set<AuthorDTO> authors) {
        this.title = title;
        this.datePublication = datePublication;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
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
