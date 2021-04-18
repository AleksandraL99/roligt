package pl.roligt.roligt.databaseFiles;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @ManyToOne
    //@JoinColumn(name="user_id")
    private UsersTable user_id;


    private Date date;
    private Time hour;
    private String place;
    private int children;

    public Reservations() {
    }
    public Reservations(Long reservation_id, UsersTable user_id, Date date, Time hour, String place, int children) {
        this.reservation_id = reservation_id;
        this.user_id = user_id;
        this.date = date;
        this.hour = hour;
        this.place = place;
        this.children = children;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public UsersTable getUser_id() {
        return user_id;
    }

    public void setUser_id(UsersTable user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }


}
