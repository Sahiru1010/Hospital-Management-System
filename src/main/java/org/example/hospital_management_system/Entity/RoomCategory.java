package org.example.hospital_management_system.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ROOM_CATEGORY")
@Data
public class RoomCategory {
    @Id
    @Column(name = "Category_ID", length = 20)
    private String categoryId;

    @Column(name = "Category_Name", nullable = false, unique = true, length = 50)
    private String categoryName;
}
