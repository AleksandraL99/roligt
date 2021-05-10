package pl.roligt.roligt.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Table(name="reservations")
@Entity(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category_id;

    private Date date;
    private Time hour;
    private String place;

    public Reservation() {
    }

    public Reservation(Long reservation_id, User user_id, Date date, Time hour, String place, Category id_category) {
        this.reservation_id = reservation_id;
        this.user_id = user_id;
        this.date = date;
        this.hour = hour;
        this.place = place;
        this.category_id = id_category;
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
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

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category children) {
        this.category_id = children;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", date=" + date +
                ", hour=" + hour +
                ", place='" + place + '\'' +
                '}';
    }
}
