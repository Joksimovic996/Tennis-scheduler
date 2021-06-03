package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TennisCourt;

import java.util.List;

public interface TennisCourtService {

    public TennisCourt getTennisCourt(Long id);

    public List<TennisCourt> getAllCourts();
}
