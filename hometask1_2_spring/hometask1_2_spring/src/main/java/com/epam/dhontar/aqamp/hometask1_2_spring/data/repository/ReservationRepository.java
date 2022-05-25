package com.epam.dhontar.aqamp.hometask1_2_spring.data.repository;

import com.epam.dhontar.aqamp.hometask1_2_spring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
