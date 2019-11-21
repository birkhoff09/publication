/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * ResponseEntityUtil
 *
 * @author Birkhoff
 */
public class ResponseEntityUtil {

    public static HttpHeaders getHeaders() {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders(multiValueMap);
        return headers;
    }

    /**
     *
     * @return
     */
    public static ResponseEntity<Void> createResponseEntity() {
        return new ResponseEntity(getHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param httpStatus
     * @return
     */
    public static ResponseEntity<Void> createResponseEntity(HttpStatus httpStatus) {
        return new ResponseEntity(getHeaders(), httpStatus);
    }

    /**
     *
     * @param body
     * @param httpStatus
     * @return
     */
    public static ResponseEntity createResponseEntity(Object body, HttpStatus httpStatus) {
        return new ResponseEntity(body, getHeaders(), httpStatus);
    }

    /**
     *
     * @param body
     * @param headers
     * @param httpStatus
     * @return
     */
    public static ResponseEntity createResponseEntity(Object body, HttpHeaders headers, HttpStatus httpStatus) {
        return new ResponseEntity(body, headers, httpStatus);
    }

    /**
     *
     * @param body
     * @return
     */
    public static ResponseEntity createGetResponseEntity(Object body) {
        return new ResponseEntity(body, getHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param body
     * @param headers
     * @return
     */
    public static ResponseEntity createGetResponseEntity(Object body, HttpHeaders headers) {
        return new ResponseEntity(body, headers, HttpStatus.OK);
    }

    /**
     *
     * @param body
     * @return
     */
    public static ResponseEntity createPostResponseEntity(Object body) {
        return new ResponseEntity(body, getHeaders(), HttpStatus.CREATED);
    }

    /**
     *
     * @param body
     * @param headers
     * @return
     */
    public static ResponseEntity createPostResponseEntity(Object body, HttpHeaders headers) {
        return new ResponseEntity(body, headers, HttpStatus.CREATED);
    }

    /**
     *
     * @param body
     * @return
     */
    public static ResponseEntity createPutResponseEntity(Object body) {
        return new ResponseEntity(body, getHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param body
     * @param headers
     * @return
     */
    public static ResponseEntity createPutResponseEntity(Object body, HttpHeaders headers) {
        return new ResponseEntity(body, headers, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    public static ResponseEntity<Void> createDeleteResponseEntity() {
        return new ResponseEntity(getHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param headers
     * @return
     */
    public static ResponseEntity<Void> createDeleteResponseEntity(HttpHeaders headers) {
        return new ResponseEntity(headers, HttpStatus.OK);
    }
}
