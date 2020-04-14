/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.exceptions;

import tg.dksoft.publication.enums.ErrorMessageEnum;

/**
 * This will be thrown where rows is not exist on DB
 *
 * @author Birkhoff
 */
public class DocumentNotFoundException extends RuntimeException {

    public DocumentNotFoundException() {
        super(ErrorMessageEnum.DOCUMENT_NOT_FOUND.getValue());
    }

}
