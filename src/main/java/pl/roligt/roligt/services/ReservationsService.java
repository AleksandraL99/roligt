package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.repositories.ReservationsRepo;

import java.sql.Date;
import java.sql.Time;

@Service
public class ReservationsService {
    private ReservationsRepo reservationsRepo;

    @Autowired
    public ReservationsService(ReservationsRepo reservationsRepo) {
        this.reservationsRepo = reservationsRepo;
    }

    public boolean checkDate(Date date) {
        java.sql.Date systemDate = new java.sql.Date(System.currentTimeMillis());
        if(reservationsRepo.existsByDate(date)==true || !date.after(systemDate)) {
            return true;
        }
        else
            return false;
    }

    public Date convertDate(int day, int month, int year) {
        year -= 1900;
        month -= 1;
        java.sql.Date date = new Date(year, month, day);
        return date;
    }

    public Time convertTime(int hour, int minute) {
        java.sql.Time time = new Time(hour,minute,0);
        return time;
    }

}
