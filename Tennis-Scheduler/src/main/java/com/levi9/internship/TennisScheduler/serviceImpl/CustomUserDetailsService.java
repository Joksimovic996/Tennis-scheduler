package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private TennisPlayerRepository tennisPlayerRepository;

    /*
    @Autowired
    private PasswordEncoder passwordEncoder;
*/
    @Autowired
	private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TennisPlayer tennisPlayer = tennisPlayerRepository.findByUsername(username);
        if (tennisPlayer == null) {
            throw new UsernameNotFoundException(String.format("No tennis player found with username '%s'.", username));
        } else {
            return tennisPlayer;
        }
    }

    public void changePassword(String oldPassword, String newPassword) {

        Authentication currentTennisPlayer = SecurityContextHolder.getContext().getAuthentication();
        String username = currentTennisPlayer.getName();

        if (authenticationManager != null) {
            LOGGER.debug("Re-authenticating tennis player '" + username + "' for password change request.");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            LOGGER.debug("No authentication manager set. can't change Password!");

            return;
        }

        LOGGER.debug("Changing password for tennis player '" + username + "'");

        TennisPlayer tennisPlayer = (TennisPlayer) loadUserByUsername(username);

        /*
        tennisPlayer.setPassword(passwordEncoder.encode(newPassword));
         */

        tennisPlayerRepository.save(tennisPlayer);

    }
}
