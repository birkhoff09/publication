/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Birkhoff
 */
public class UserDTO {

    @JsonProperty(value = "username")
    String userName;
    String password;
}
