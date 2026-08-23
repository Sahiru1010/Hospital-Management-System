package org.example.hospital_management_system.Repository;
import org.example.hospital_management_system.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, String> {
    //Finds all rooms with the specified availability status
    List<Room> findByAvailabilityStatus(String status);
}
