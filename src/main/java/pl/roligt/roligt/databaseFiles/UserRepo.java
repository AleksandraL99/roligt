package pl.roligt.roligt.databaseFiles;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UsersTable, Long> {
}

