package ru.stud.kpfu.baigulova.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Appeal> appeals;

    public User() {

    }

    public User(String name, String email, String password, List<Appeal> appeals) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.appeals = appeals;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User(Integer id,String name, String email, String password, List<Appeal> appeals) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.appeals = appeals;
    }
}
