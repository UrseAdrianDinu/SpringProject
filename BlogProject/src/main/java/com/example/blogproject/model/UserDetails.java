package com.example.blogproject.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_DETAILS_ID")
    private Long id;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserDetails(Long id, LocalDate dateOfBirth, User user) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
    }

    public UserDetails() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
