package com.levi9.internship.tennisscheduler.serviceimpl;

import com.levi9.internship.tennisscheduler.model.Authority;
import com.levi9.internship.tennisscheduler.repository.AuthorityRepository;
import com.levi9.internship.tennisscheduler.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public List<Authority> findByName(String name) {
        Authority auth = this.authorityRepository.findByName(name);
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        return auths;
    }
}
