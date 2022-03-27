package com.example.daoAndHibernate.service;

import com.example.daoAndHibernate.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
public class PersonDetailsService implements UserDetailsService {
    @Autowired
    private PersonsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByPersonsId_name(username).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return new User(user.getPersonsId().getName(), encoder.encode(user.getPass()), Collections.singletonList(new SimpleGrantedAuthority(user.getRoll())));
    }
}
