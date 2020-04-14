/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import tg.dksoft.publication.enums.PublicationTypeEnum;
import tg.dksoft.publication.model.Book;

/**
 *
 * @author Birkhoff
 */
public class BookDTO extends PublicationDTO {

    private int pages;

    public BookDTO(Book book) {
        super(book);
        super.setTypePublication(PublicationTypeEnum.BOOK.value());
        book.setPages(book.getPages());
    }

    public BookDTO(int pages, Book book) {
        super(book);
        super.setTypePublication(PublicationTypeEnum.BOOK.value());
        this.pages = pages;
//        this.publisherName = publisherName;
    }

    public BookDTO(Long bookId, int pages, String title, Date datePublication) {
        super(title, datePublication);
        this.pages = pages;
        this.publicationId = bookId;
        super.setTypePublication(PublicationTypeEnum.BOOK.value());
    }

    @JsonProperty("book_id")
    @Override
    public Long getPublicationId() {
        return this.publicationId;
    }

    public void setPublication(Long publicationId) {
        this.publicationId = publicationId;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @JsonIgnore
    @Override
    protected String getTypePublication() {
        return super.getTypePublication();
    }

    @Override
    protected void setTypePublication(String typePublication) {
        super.setTypePublication(typePublication);
    }
}
