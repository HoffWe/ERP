package sda.pl.zdjavapol96.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.repository.UserAppRepository;

@Service
public class UserAppService implements UserDetailsService {
    private final UserAppRepository users;

    public UserAppService(UserAppRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findByUsername(username).orElse(null);
    }
}