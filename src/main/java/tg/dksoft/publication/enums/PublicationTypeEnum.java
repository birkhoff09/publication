/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.enums;

/**
 *
 * @author Birkhoff
 */
public enum PublicationTypeEnum {
    BOOK("book"),
    BLOG_POST("post");

    String publicationType;

    PublicationTypeEnum(String publicationType) {
        this.publicationType = publicationType;
    }

    public String value() {
        return this.publicationType;
    }
}
