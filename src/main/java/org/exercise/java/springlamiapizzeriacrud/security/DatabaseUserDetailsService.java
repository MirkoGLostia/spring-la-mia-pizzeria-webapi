package org.exercise.java.springlamiapizzeriacrud.security;

import org.exercise.java.springlamiapizzeriacrud.model.User;
import org.exercise.java.springlamiapizzeriacrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> loggedUser = userRepository.findByEmail(username);
        if (loggedUser.isPresent()) {

            return new DatabaseUserDetails(loggedUser.get());
        } else {

            throw new UsernameNotFoundException(username);
        }
    }

}
