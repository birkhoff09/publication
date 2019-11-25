/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import java.util.Date;
import java.util.Set;
import tg.dksoft.publication.model.Book;

/**
 *
 * @author Birkhoff
 */
public class BookDTO extends PublicationDTO {

    private int pages;
//    private String publisherName;

    public BookDTO(int pages, Book book) {
        super(book);
        this.pages = pages;
//        this.publisherName = publisherName;
    }

    public BookDTO(int pages, String title, Date datePublication, String typePublication) {
        super(title, datePublication, typePublication);
        this.pages = pages;
//        this.publisherName = publisherName;
    }

    public BookDTO(int pages, String title, Date datePublication, String typePublication, Set<AuthorDTO> authors) {
        super(title, datePublication, typePublication, authors);
        this.pages = pages;
//        this.publisherName = publisherName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

//    public String getPublisherName() {
//        return publisherName;
//    }
//
//    public void setPublisherName(String publisherName) {
//        this.publisherName = publisherName;
//    }

}
