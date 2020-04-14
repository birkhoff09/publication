/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Birkhoff
 */
@Entity
@DiscriminatorValue(value = "book")
public class Book extends Publication {

    private int pages;

    @Column(name = "pages")
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + super.hashCode();
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
        return true;
    }

}
