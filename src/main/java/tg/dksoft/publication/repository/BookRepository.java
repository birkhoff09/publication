/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.dksoft.publication.model.Book;

/**
 *
 * @author Birkhoff
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
