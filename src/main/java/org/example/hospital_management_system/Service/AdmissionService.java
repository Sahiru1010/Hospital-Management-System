package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.DTO.Request.AdmissionRequestDTO;
import org.example.hospital_management_system.exception.BusinessRuleException;
import org.example.hospital_management_system.Entity.Admission;
import org.example.hospital_management_system.Entity.Room;
import org.example.hospital_management_system.Repository.AdmissionRepo;
import org.example.hospital_management_system.Repository.RoomRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AdmissionService {

    @Autowired
    private AdmissionRepo admissionRepo;
    public List<Admission> getAllAdmissions() { return admissionRepo.findAll(); }
    public Optional<Admission> getAdmissionById(String id) { return admissionRepo.findById(id); }
    public void deleteAdmission(String id) { admissionRepo.deleteById(id); }



    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private ModelMapper modelMapper;

    // --- Upgraded Admission Logic ---
    @Transactional
    public Admission saveAdmission(Admission admission) {
        // 1. Fetch the room the patient wants to stay in
        String roomId = admission.getRoom().getRoomId();
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new BusinessRuleException("Room not found in database."));

        // 2. Check if the room is already occupied
        if (!room.getAvailabilityStatus().equalsIgnoreCase("Available")) {
            throw new BusinessRuleException("Cannot admit patient. Room " + roomId + " is currently " + room.getAvailabilityStatus());
        }

        // 3. Mark the room as Occupied and save it
        room.setAvailabilityStatus("Occupied");
        roomRepo.save(room);

        // 4. Save the actual admission record
        return admissionRepo.save(admission);
    }



    }


}
