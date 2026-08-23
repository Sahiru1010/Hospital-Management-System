package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.RoomCategory;
import org.example.hospital_management_system.Service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room-categories")
public class RoomCategoryController {

    @Autowired private RoomCategoryService roomCategoryService;

    @GetMapping
    public ResponseEntity<List<RoomCategory>> getAll() { return ResponseEntity.ok(roomCategoryService.getAllRoomCategories()); }

    @PostMapping
    public ResponseEntity<RoomCategory> create(@RequestBody RoomCategory roomCategory) { return new ResponseEntity<>(roomCategoryService.saveRoomCategory(roomCategory), HttpStatus.CREATED); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) { roomCategoryService.deleteRoomCategory(id); return ResponseEntity.ok("Deleted successfully"); }
}
