/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.dksoft.publication.model.User;

/**
 *
 * @author Birkhoff
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String userName);
}
