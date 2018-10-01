CREATE TABLE APP_USER (
    id serial  NOT NULL,
    sso_id varchar(30)  NOT NULL,
    password varchar(100)  NOT NULL,
    first_name varchar(30)  NOT NULL,
    last_name varchar(30)  NOT NULL,
    email varchar(30)  NOT NULL,
    CONSTRAINT APP_USER_pk PRIMARY KEY (id)
);

-- Populate one Admin User which will further create other users for the application using GUI
INSERT INTO public.APP_USER(sso_id, password, first_name, last_name, email)
VALUES ('Roman','$2a$10$6t5dcvMst.Eo4r4XlIK6GO.JGqM2qprFrYT/2trJ4t3Bt3dkA4ury', 'Roman','Horbenko','romanich1987@meta.ua');;

CREATE TABLE APP_USER_TO_USER_PROFILE (
    app_user_id int  NOT NULL,
    user_profile_id int  NOT NULL
);

INSERT INTO APP_USER_TO_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='Roman' and profile.type='ADMIN';;

CREATE TABLE PERSISTENT_LOGINS (
    username varchar(30)  NOT NULL,
    series varchar(64)  NOT NULL,
    token varchar(64)  NOT NULL,
    last_used timestamp  NOT NULL,
    CONSTRAINT PERSISTENT_LOGINS_pk PRIMARY KEY (series)
);

CREATE TABLE AUDITORIUM (
    id serial  NOT NULL,
    name varchar(30)  NOT NULL,
    seats_no int  NOT NULL,
    CONSTRAINT AUDITORIUM_pk PRIMARY KEY (id)
);

CREATE TABLE MOVIE (
    id serial  NOT NULL,
    title varchar(256)  NOT NULL,
    director varchar(256)  NULL,
    "cast" varchar(1024)  NULL,
    description text  NULL,
    duration_min int  NULL,
    CONSTRAINT MOVIE_pk PRIMARY KEY (id)
);

CREATE TABLE RESERVATION (
    id int  NOT NULL,
    screening_id int  NOT NULL,
    employee_reserved_id int  NULL,
    reservation_type_id int  NULL,
    reservation_contact varchar(1024)  NOT NULL,
    reserved bool  NULL,
    employee_paid_id int  NULL,
    paid bool  NULL,
    active bool  NOT NULL,
    CONSTRAINT RESERVATION_pk PRIMARY KEY (id)
);

CREATE TABLE RESERVATION_TYPE (
    id serial  NOT NULL,
    reservation_type varchar(30)  NOT NULL,
    CONSTRAINT RESERVATION_TYPE_pk PRIMARY KEY (id)
);

CREATE TABLE SCREENING (
    id serial  NOT NULL,
    movie_id int  NOT NULL,
    auditorium_id int  NOT NULL,
    screening_start timestamp  NOT NULL,
    CONSTRAINT Projection_ak_1 UNIQUE (auditorium_id, screening_start) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT SCREENING_pk PRIMARY KEY (id)
);

CREATE TABLE SEAT (
    id serial  NOT NULL,
    row int  NOT NULL,
    number int  NOT NULL,
    auditorium_id int  NOT NULL,
    CONSTRAINT SEAT_pk PRIMARY KEY (id)
);

CREATE TABLE SEAT_RESERVED (
    id serial  NOT NULL,
    seat_id int  NOT NULL,
    reservation_id int  NOT NULL,
    screening_id int  NOT NULL,
    CONSTRAINT SEAT_RESERVED_pk PRIMARY KEY (id)
);

CREATE TABLE USER_PROFILE (
    id serial  NOT NULL,
    type varchar(30)  NOT NULL DEFAULT USER,
    CONSTRAINT USER_PROFILE_pk PRIMARY KEY (id)
);

INSERT INTO USER_PROFILE(type)
VALUES ('USER');
  
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');
  
INSERT INTO USER_PROFILE(type)
VALUES ('DBA');;

-- foreign keys
-- Reference: APP_USER_TO_USER_PROFILE_APP_USER (table: APP_USER_TO_USER_PROFILE)
ALTER TABLE APP_USER_TO_USER_PROFILE ADD CONSTRAINT APP_USER_TO_USER_PROFILE_APP_USER
    FOREIGN KEY (app_user_id)
    REFERENCES APP_USER (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: APP_USER_TO_USER_PROFILE_USER_PROFILE (table: APP_USER_TO_USER_PROFILE)
ALTER TABLE APP_USER_TO_USER_PROFILE ADD CONSTRAINT APP_USER_TO_USER_PROFILE_USER_PROFILE
    FOREIGN KEY (user_profile_id)
    REFERENCES USER_PROFILE (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Projection_Movie (table: SCREENING)
ALTER TABLE SCREENING ADD CONSTRAINT Projection_Movie
    FOREIGN KEY (movie_id)
    REFERENCES MOVIE (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Projection_Room (table: SCREENING)
ALTER TABLE SCREENING ADD CONSTRAINT Projection_Room
    FOREIGN KEY (auditorium_id)
    REFERENCES AUDITORIUM (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Reservation_Projection (table: RESERVATION)
ALTER TABLE RESERVATION ADD CONSTRAINT Reservation_Projection
    FOREIGN KEY (screening_id)
    REFERENCES SCREENING (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Reservation_Reservation_type (table: RESERVATION)
ALTER TABLE RESERVATION ADD CONSTRAINT Reservation_Reservation_type
    FOREIGN KEY (reservation_type_id)
    REFERENCES RESERVATION_TYPE (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Reservation_paid_Employee (table: RESERVATION)
ALTER TABLE RESERVATION ADD CONSTRAINT Reservation_paid_Employee
    FOREIGN KEY (employee_paid_id)
    REFERENCES APP_USER (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Reservation_reserving_employee (table: RESERVATION)
ALTER TABLE RESERVATION ADD CONSTRAINT Reservation_reserving_employee
    FOREIGN KEY (employee_reserved_id)
    REFERENCES APP_USER (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Seat_Room (table: SEAT)
ALTER TABLE SEAT ADD CONSTRAINT Seat_Room
    FOREIGN KEY (auditorium_id)
    REFERENCES AUDITORIUM (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Seat_reserved_Reservation_projection (table: SEAT_RESERVED)
ALTER TABLE SEAT_RESERVED ADD CONSTRAINT Seat_reserved_Reservation_projection
    FOREIGN KEY (screening_id)
    REFERENCES SCREENING (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Seat_reserved_Reservation_reservation (table: SEAT_RESERVED)
ALTER TABLE SEAT_RESERVED ADD CONSTRAINT Seat_reserved_Reservation_reservation
    FOREIGN KEY (reservation_id)
    REFERENCES RESERVATION (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Seat_reserved_Seat (table: SEAT_RESERVED)
ALTER TABLE SEAT_RESERVED ADD CONSTRAINT Seat_reserved_Seat
    FOREIGN KEY (seat_id)
    REFERENCES SEAT (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

commit;


