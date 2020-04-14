/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Birkhoff
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typePublication")
@Entity(name = "publication")
public abstract class Publication extends AbstractModel implements Serializable {

    protected String title;
    protected Date datePublication;
    protected Set<AuthorPublication> authorPublications;

    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "date_publication", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @OneToMany(mappedBy = "publication", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public Set<AuthorPublication> getAuthorPublications() {
        return authorPublications;
    }

    public void setAuthorPublications(Set<AuthorPublication> authorPublications) {
        this.authorPublications = authorPublications;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.datePublication);
//        hash = 71 * hash + Objects.hashCode(this.authorPublications);
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
        final Publication other = (Publication) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datePublication, other.datePublication)) {
            return false;
        }
//        if (!Objects.equals(this.authorPublications, other.authorPublications)) {
//            return false;
//        }
        return true;
    }

}
