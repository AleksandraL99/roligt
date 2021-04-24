package pl.roligt.roligt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}


