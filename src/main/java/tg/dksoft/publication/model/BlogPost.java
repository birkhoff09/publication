/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Birkhoff
 */
@Entity
@DiscriminatorValue(value = "post")
class BlogPost extends Publication implements Serializable {

}
