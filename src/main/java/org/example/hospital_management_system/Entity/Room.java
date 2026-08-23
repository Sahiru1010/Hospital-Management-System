package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ROOM")
@Data
public class Room {
    @Id
    @Column(name = "Room_ID", length = 20)
    private String roomId;

    //"General Ward", "Private Room", "ICU"
    @Column(name = "Room_Category", nullable = false, length = 50)
    private String roomCategory;

    //Enforces the "Maintain room availability" rule
    @Column(name = "Availability_Status", nullable = false, length = 20)
    private String availabilityStatus = "Available";
}