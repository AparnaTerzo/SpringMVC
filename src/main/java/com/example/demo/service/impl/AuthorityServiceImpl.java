package com.example.demo.service.impl;

import com.example.demo.models.Authority;
import com.example.demo.models.Users;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    private AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository){
        this.authorityRepository=authorityRepository;
    }
    @Override
    public void saveUser(Authority authority) {
        authorityRepository.save(authority);
    }
}
