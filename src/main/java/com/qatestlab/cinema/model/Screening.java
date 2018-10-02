package com.qatestlab.cinema.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SCREENING")
public class Screening {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MOVIE_ID", nullable = false)
    private Integer movieId;

    @Column(name = "AUDITORIUM_ID", nullable = false)
    private  Integer auditoriumId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date screeningStart;

    //TODO Add FK to movie_id, ref. to MOVIE.id
    //TODO Add FK to auditorium_id, ref. to AUDITORIUM.id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public Date getScreeningStart() {
        return screeningStart;
    }

    public void setScreeningStart(Date screeningStart) {
        this.screeningStart = screeningStart;
    }

}
