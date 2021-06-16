package com.levi9.internship.tennisscheduler.repository;

import com.levi9.internship.tennisscheduler.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Authority findByName(String name);
}
