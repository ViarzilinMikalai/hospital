package org.viarzilin.hospital.model.service.impl;


import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.domain.User;
import org.viarzilin.hospital.model.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        org.springframework.security.core.userdetails.User userDetails = null;

        User user = userService.getUserByUsername(username);

        if(user != null){
            //Set<GrantedAuthority> roles = new HashSet<>();
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority (user.getAuth().getRole().name()));

            userDetails = new org.springframework.security.core.userdetails.User(  user.getAuth().getUsername(),
                            user.getAuth().getPassword(),
                            roles);
        }
        return userDetails;
    }
}
