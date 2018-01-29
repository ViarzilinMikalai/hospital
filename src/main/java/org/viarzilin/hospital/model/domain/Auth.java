package org.viarzilin.hospital.model.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import org.viarzilin.hospital.model.domain.enumerated.UserRole;
import javax.validation.constraints.Size;


@Table(name = "auth")
@Entity
public class Auth {

    @Id
    @Column(name = "ID_AUTH")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERNAME", updatable = false, unique = true, nullable = false, length = 16)
    private String username;

    @Size(min = 6, max = 24, message = "Very short password")
    @Column(name = "PASSWORD", nullable = false, length = 16)
    private String password;

    @Email
    @Column(name = "EMAIL",unique = true, nullable = false, length = 20)
    private String email;

    @Column(name="ISACTIVE")
    private boolean isActive;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole role;


    /**
    * User of this authentication
    */

    @OneToOne(optional = false, mappedBy = "auth")
    private User user;


    public Auth(){

    }

    /**
    * Getters and Setters
    */
    public int getId() {
    return id;
    }

    public void setId(int id) {
    this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
    this.password = password;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public boolean isActive() {
    return isActive;
    }

    public void setActive(boolean active) {
    isActive = active;
    }

    public UserRole getRole() {
    return role;
    }

    public void setRole(UserRole role) {
    this.role = role;
    }

    public User getUser() {
    return user;
    }

    public void setUser(User user) {
    this.user = user;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

}
