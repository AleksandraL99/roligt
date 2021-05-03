package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.repositories.UserRepo;

@Service
public class LoginAndRegistrationService {
    //musi sprawdzić czy użytkownik istnieje i jesli tak to dać mu token
    private UserRepo userRepo;

    @Autowired
    public LoginAndRegistrationService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean login(String email, String password) {
        //exist do sprawdzenia czy użyszkodnik istnieje
        return true;
    }
}
