package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}


