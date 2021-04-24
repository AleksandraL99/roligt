package pl.roligt.roligt.models;

import javax.persistence.*;
import java.util.List;

@Table(name="users")
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user_id")
    private List<Reservation> reservations;



    private String email;
    private String password;
    private int phone_number;
    private String status;

    public User(Long user_id, String email, String password, int phone_number, String status) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.status = status;
    }
    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long id) {
        this.user_id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, email='%s', phone_number='%d', status='%s']",
                user_id, email, phone_number, status);
    }
}