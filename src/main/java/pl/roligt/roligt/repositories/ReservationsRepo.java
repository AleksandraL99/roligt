package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Reservation;


@Repository
public interface ReservationsRepo extends JpaRepository<Reservation, Long> {
}
