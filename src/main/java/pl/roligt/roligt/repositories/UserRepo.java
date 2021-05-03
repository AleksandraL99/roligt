package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}

