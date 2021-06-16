package com.levi9.internship.tennisscheduler.service;

import com.levi9.internship.tennisscheduler.model.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> findByName(String name);
}
