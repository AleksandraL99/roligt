package pl.roligt.roligt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.roligt.roligt.models.Reservation;
import java.sql.Date;


@Repository
public interface ReservationsRepo extends JpaRepository<Reservation, Long> {
    boolean existsByDate(Date date);
/*
    @Query(value = """
            DELETE * from Reservations where reservation_id=:id""",
            nativeQuery = true)
    void deleteByReservation_id(Long id);*/
    @Override
        void deleteById(Long id);
}
