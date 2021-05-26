package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.models.User;
import pl.roligt.roligt.repositories.UserRepo;


@Service
public class SecurityServiceImpl implements SecurityService {
    private UserRepo userRepo;

    @Autowired
    public SecurityServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }
/*

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

    }

}
