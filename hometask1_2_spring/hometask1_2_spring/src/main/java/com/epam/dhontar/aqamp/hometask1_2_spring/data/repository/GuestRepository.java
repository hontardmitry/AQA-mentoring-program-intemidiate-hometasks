package com.epam.dhontar.aqamp.hometask1_2_spring.data.repository;

import com.epam.dhontar.aqamp.hometask1_2_spring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}