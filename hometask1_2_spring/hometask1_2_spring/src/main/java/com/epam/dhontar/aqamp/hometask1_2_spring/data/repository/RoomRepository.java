package com.epam.dhontar.aqamp.hometask1_2_spring.data.repository;

import com.epam.dhontar.aqamp.hometask1_2_spring.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
