package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = """
            SELECT * from Category  where Number_of_children=:number AND name=:nameType""",
            nativeQuery = true)
    Category findByNumber_of_childrenAndAndName(int number, String nameType);
}