package com.qatestlab.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "SEAT")
public class Seat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ROW", nullable = false)
    private Integer row;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Column(name = "AUDITORIUM_ID", nullable = false)
    private Integer auditoriumId;

    //TODO Add FK to auditorium_id, ref. to AUDITORIUM.id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

}
