/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Birkhoff
 */
@EqualsAndHashCode(callSuper = true)
@Entity(name = "publisher")
@Data
class Publisher extends AbstractModel {

    @Id
    private Long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publisher")
    private Set<Book> books;

}
