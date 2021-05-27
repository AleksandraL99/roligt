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

    public Reservation( User user_id, Date date, Time hour, String place, Category id_category) {
        this.user_id = user_id;
        this.date = date;
        this.hour = hour;
        this.place = place;
        this.category_id = id_category;
    }


    public Long getReservation_id() {
        return reservation_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public Date getDate() {
        return date;
    }

    public Time getHour() {
        return hour;
    }

    public String getPlace() {
        return place;
    }

    public Category getCategory_id() {
        return category_id;
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
