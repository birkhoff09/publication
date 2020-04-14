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
public enum ErrorMessageEnum {

    DOCUMENT_NOT_FOUND("Requested document not found.");
    String value;

    ErrorMessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
