/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.dksoft.publication.model.Privilege;

/**
 *
 * @author Birkhoff
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

}
