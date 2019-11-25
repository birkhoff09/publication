/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import java.util.Optional;
import tg.dksoft.publication.model.User;

/**
 *
 * @author Birkhoff
 */
public interface IUserService extends IService<Long, User> {

    public Optional<User> findByUsername(String username);

}
