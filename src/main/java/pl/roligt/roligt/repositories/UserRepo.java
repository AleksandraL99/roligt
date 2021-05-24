package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);

    @Override
    User save(User entity);

    @Query(value = """
            SELECT password from users where email=:mail""",
            nativeQuery = true)
    String findPasswordByEmail(String mail);

}

