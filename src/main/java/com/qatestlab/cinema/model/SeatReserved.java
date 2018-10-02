package com.qatestlab.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "SEAT_RESERVED")
public class SeatReserved {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SEAT_ID", nullable = false)
    private Integer seatId;

    @Column(name = "RESERVATION_ID", nullable = false)
    private Integer reservationId;

    @Column(name = "SCREENING_ID", nullable = false)
    private Integer screeningId;

    //TODO Add FK to screening_id, ref. to SCREENING.id
    //TODO Add FK to reservation_id, ref. to RESERVATION.id
    //TODO Add FK to seat_id, ref. to SEAT.id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Integer screeningId) {
        this.screeningId = screeningId;
    }
}
