/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.Role;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.RoleRepository;
import tg.dksoft.publication.service.IRoleService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<Long, Role> implements IRoleService {

    RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, IGenericRepository<Role> genericRepository) {
        super(Role.class, genericRepository);
        this.repository = repository;
    }

}
