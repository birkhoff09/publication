/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import tg.dksoft.publication.model.User;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.repository.UserRepository;
import tg.dksoft.publication.service.IUserService;

/**
 *
 * @author Birkhoff
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<Long, User> implements IUserService {

    UserRepository repository;

    public UserServiceImpl(UserRepository repository, IGenericRepository<User> genericRepository) {
        super(User.class, genericRepository);
        this.repository = repository;
    }

    @Override
    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}
