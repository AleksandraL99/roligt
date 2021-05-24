package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.models.User;
import pl.roligt.roligt.repositories.UserRepo;

@Service
public class SecurityService implements UserDetailsService {
    private UserRepo userRepo;

    @Autowired
    public SecurityService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

    }
}
