package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.models.User;
import pl.roligt.roligt.repositories.UserRepo;

import javax.servlet.http.Cookie;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletResponse;

@Service
public class LoginAndRegistrationService {
    private UserRepo userRepo;

    @Autowired
    public LoginAndRegistrationService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean checkEmail(String email) {
        return (userRepo.findUserByEmail(email)!=null);
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
        return (phone.matches("\\d{9}"));
    }

    public String hashPassword(String pass) {
        return pass; //passwordEncoder.encode(pass);
    }

    public Boolean verifyPassword(String email, String password) {
        String encodedPassword = userRepo.findPasswordByEmail(email);
        return true; //
    }

    public void addCookie(String mail) {

    }
}
