package pl.roligt.roligt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}

