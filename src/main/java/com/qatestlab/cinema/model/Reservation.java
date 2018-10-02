package com.qatestlab.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SCREENING_ID", nullable = false)
    private Integer screeningId;

    @Column(name = "APP_USER_RESERVED_ID")
    private Integer appUserReservedId;

    @Column(name = "RESERVATION_TYPE_ID")
    private Integer reservationTypeId;

    @Column(name = "RESERVATION_CONTACT", nullable = false)
    private String reservationContact;

    @Column(name = "RESERVED")
    private Boolean reserved;

    @Column(name = "APP_USER_PAID_ID")
    private Integer appUserPaidId;

    @Column(name = "IS_PAID")
    private Boolean isPaid;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;

    //TODO Add FK to screening_id, ref. to SCREENING.id
    //TODO Add FK to reservation_type_id, ref. to RESERVATION_TYPE.id
    //TODO Add FK to employee_paid_id, ref. to APP_USER.id
    //TODO Add FK to employee_reserved_id, ref. to APP_USER.id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Integer screeningId) {
        this.screeningId = screeningId;
    }

    public Integer getAppUserReservedId() {
        return appUserReservedId;
    }

    public void setAppUserReservedId(Integer appUserReservedId) {
        this.appUserReservedId = appUserReservedId;
    }

    public Integer getReservationTypeId() {
        return reservationTypeId;
    }

    public void setReservationTypeId(Integer reservationTypeId) {
        this.reservationTypeId = reservationTypeId;
    }

    public String getReservationContact() {
        return reservationContact;
    }

    public void setReservationContact(String reservationContact) {
        this.reservationContact = reservationContact;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Integer getAppUserPaidId() {
        return appUserPaidId;
    }

    public void setAppUserPaidId(Integer appUserPaidId) {
        this.appUserPaidId = appUserPaidId;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}
