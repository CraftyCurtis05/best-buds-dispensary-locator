package com.bestbuds.security;

import com.bestbuds.dao.UserDao;
import com.bestbuds.model.Authority;
import com.bestbuds.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(
            UserDao userDao
    ) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) {

        User user =
                userDao.getUserByUsername(
                        username
                );

        if (user == null) {
            throw new UsernameNotFoundException(
                    "User not found"
            );
        }

        List<GrantedAuthority> grantedAuthorities =
                getGrantedAuthorities(
                        user.getAuthorities()
                );

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities
        );
    }

    // Convert Best Buds authorities into Spring Security authorities
    private List<GrantedAuthority> getGrantedAuthorities(
            Iterable<Authority> authorities
    ) {

        List<GrantedAuthority> grantedAuthorities =
                new ArrayList<>();

        for (Authority authority : authorities) {

            grantedAuthorities.add(
                    new SimpleGrantedAuthority(
                            authority.getName()
                    )
            );
        }

        return grantedAuthorities;
    }
}