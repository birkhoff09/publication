/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import tg.dksoft.publication.model.Author;

/**
 *
 * @author Birkhoff
 */
public class AuthorDTO {

    private String firstName;
    private String lastName;
    private Set<PublicationDTO> publications;

    public AuthorDTO(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.publications = new HashSet<>();
        author.getPublications().forEach(publication -> {
            publications.add(new PublicationDTO(publication.getTitle(), publication.getDatePublication()));
        });
    }

    AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<PublicationDTO> getPublications() {
        return this.publications;
    }

    public void setPublications(Set<PublicationDTO> publications) {
        this.publications = publications;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.publications);
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
        final AuthorDTO other = (AuthorDTO) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.publications, other.publications)) {
            return false;
        }
        return true;
    }

}
