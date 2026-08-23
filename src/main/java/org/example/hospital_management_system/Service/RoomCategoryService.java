package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.RoomCategory;
import org.example.hospital_management_system.Repository.RoomCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryService {
    @Autowired private RoomCategoryRepo roomCategoryRepo;

    public List<RoomCategory> getAllRoomCategories() { return roomCategoryRepo.findAll(); }
    public Optional<RoomCategory> getRoomCategoryById(String id) { return roomCategoryRepo.findById(id); }
    public RoomCategory saveRoomCategory(RoomCategory roomCategory) { return roomCategoryRepo.save(roomCategory); }
    public void deleteRoomCategory(String id) { roomCategoryRepo.deleteById(id); }
}