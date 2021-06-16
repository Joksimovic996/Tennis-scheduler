package com.levi9.internship.tennisscheduler.service;

import com.levi9.internship.tennisscheduler.modeldto.AuthenticationRequestDTO;
import com.levi9.internship.tennisscheduler.modeldto.TokenStateDTO;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    TokenStateDTO createAuthenticationToken(AuthenticationRequestDTO requestDTO);
    TokenStateDTO refreshAuthenticationToken(HttpServletRequest request);

}
