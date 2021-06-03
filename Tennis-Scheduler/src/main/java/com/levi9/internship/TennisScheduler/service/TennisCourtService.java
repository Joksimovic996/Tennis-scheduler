package com.levi9.internship.TennisScheduler.service;

import java.util.List;

public interface TennisCourtService {

    public TennisCourt getTennisCourt(Long id);

    public List<TennisCourt> getAllCourts();
}
