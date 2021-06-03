package com.levi9.internship.TennisScheduler.repository;

import com.levi9.internship.TennisScheduler.model.TennisCourt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisCourtRepository extends JpaRepository<TennisCourt, Long> {
}
