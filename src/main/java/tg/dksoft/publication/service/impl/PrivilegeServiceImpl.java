/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.Privilege;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.PrivilegeRepository;
import tg.dksoft.publication.service.IPrivilegeService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends ServiceImpl<Long, Privilege> implements IPrivilegeService {

    PrivilegeRepository repository;

    @Autowired
    public PrivilegeServiceImpl(PrivilegeRepository repository, IGenericRepository<Long, Privilege> genericRepository) {
        super(Privilege.class, genericRepository);
        this.repository = repository;
    }

}
