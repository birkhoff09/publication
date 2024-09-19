/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Birkhoff
 */
@Entity
@DiscriminatorValue(value = "book")
class Book extends Publication implements Serializable {

    private int pages;
    private Publisher publisher;

    @Column(name = "pages")
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + super.hashCode();
        hash = 17 * hash + Objects.hashCode(this.publisher);
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
        final Book other = (Book) obj;
        if (!Objects.equals(super.getId(), other.getId())) {
            return false;
        }
        if (!Objects.equals(super.getTitle(), other.getTitle())) {
            return false;
        }
        if (!Objects.equals(super.getDatePublication(), other.getDatePublication())) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        return true;
    }

}
