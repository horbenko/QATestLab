package com.qatestlab.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_TYPE")
public class ReservationType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "RESERVATION_TYPE", nullable = false, length = 30)
    private String reservationType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

}
