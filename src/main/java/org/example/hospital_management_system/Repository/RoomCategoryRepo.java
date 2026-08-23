package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCategoryRepo extends JpaRepository<RoomCategory, String> {
}
