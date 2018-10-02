package com.qatestlab.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "AUDITORIUM")
public class Auditorium {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "SEATS_NO", nullable = false)
    private Integer seatsNo;

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

    public Integer getSeatsNo() {
        return seatsNo;
    }

    public void setSeatsNo(Integer seatsNo) {
        this.seatsNo = seatsNo;
    }
}
