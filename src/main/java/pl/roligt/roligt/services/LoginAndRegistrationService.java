package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.models.User;
import pl.roligt.roligt.repositories.UserRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginAndRegistrationService {
    private UserRepo userRepo;

    @Autowired
    public LoginAndRegistrationService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean checkEmail(String email) {
        if(userRepo.findUserByEmail(email)==null)
            return false;
        else
            return true;
    }
    public boolean login(String email, String password) {
        return userRepo.existsByEmailAndPassword(email, password);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean checkPhone(String phone) {
        if((phone.matches("\\d{9}")))
            return true;
        else
            return false;
    }
}
