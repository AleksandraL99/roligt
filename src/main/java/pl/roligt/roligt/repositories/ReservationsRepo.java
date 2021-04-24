package pl.roligt.roligt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Reservation;


@Repository
public interface ReservationsRepo extends CrudRepository<Reservation, Long> {
}
