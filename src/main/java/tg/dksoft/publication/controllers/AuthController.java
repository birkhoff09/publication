/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tg.dksoft.publication.model.User;
import tg.dksoft.publication.security.config.JwtTokenProvider;
import tg.dksoft.publication.service.IUserService;

/**
 *
 * @author Birkhoff
 */
@RestController
@RequestMapping("/rest/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    IUserService userService;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody User data) {
        try {
//            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
            String token = jwtTokenProvider.createToken(data.getUsername(), Arrays.asList(this.userService.findByUsername(data.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username " + data.getUsername() + "not found")).getRole().getRoleName()));
            Map<Object, Object> model = new HashMap<>();
            model.put("username", data.getUsername());
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException ex) {
            if (ex instanceof BadCredentialsException) {
                throw new BadCredentialsException("Invalid username/password supplied");
            }
            if (ex instanceof DisabledException) {
                throw new DisabledException("User account is disabled");
            } else {
                throw new LockedException("User account is locked");
            }
        }
    }
}
