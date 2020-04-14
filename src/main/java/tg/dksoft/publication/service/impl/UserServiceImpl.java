/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserServiceImpl extends ServiceImpl<Long, User> implements IUserService, UserDetailsService {

    UserRepository repository;

    public UserServiceImpl(UserRepository repository, IGenericRepository<Long, User> genericRepository) {
        super(User.class, genericRepository);
        this.repository = repository;
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("UserName not found"));
    }
}
