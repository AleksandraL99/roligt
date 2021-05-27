package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Reservation;
import pl.roligt.roligt.models.User;

import java.sql.Date;


@Repository
public interface ReservationsRepo extends JpaRepository<Reservation, Long> {
    boolean existsByDate(Date date);

    @Override
    void deleteById(Long id);

    @Override
    Reservation save(Reservation entity);
}
