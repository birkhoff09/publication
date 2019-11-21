/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import tg.dksoft.publication.model.User;

/**
 *
 * @author Birkhoff
 */
public interface IUserService extends IService<Long, User> {

    /**
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
