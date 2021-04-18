package pl.roligt.roligt.databaseFiles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsersTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;



    private String email;
    private String password;
    private int phone_number;
    private String status;

    public UsersTable(Long user_id, String email, String password, int phone_number, String status) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.status = status;
    }
    public UsersTable() {
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
