package pl.roligt.roligt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.roligt.roligt.repositories.CategoryRepo;
import pl.roligt.roligt.repositories.ReservationsRepo;
import pl.roligt.roligt.repositories.UserRepo;

import java.sql.Date;
import java.sql.Time;

@Service
public class ReservationsService {
    private ReservationsRepo reservationsRepo;
    private CategoryRepo categoryRepo;
    private UserRepo userRepo;

    @Autowired
    public ReservationsService(ReservationsRepo reservationsRepo, CategoryRepo categoryRepo, UserRepo userRepo) {
        this.reservationsRepo = reservationsRepo;
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
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


    public Long getNumberOfCategory(String partyType, String children) {
        int number=Integer.parseInt(children);
        Long category_id = categoryRepo.findByNumber_of_childrenAndAndName(number, partyType);
        return category_id;
    }

    public void deleteRecord (Long id) {
        reservationsRepo.deleteById(id);
    }

    public String getRole( String mail) {
        System.out.println(userRepo.findUserByEmail(mail).getStatus());
        //TODO dlaczego wyrzuca NOTa?
        if(userRepo.findUserByEmail(mail).getStatus()==null)
            return "NOT";
        else return userRepo.findUserByEmail(mail).getStatus();
    }

}
