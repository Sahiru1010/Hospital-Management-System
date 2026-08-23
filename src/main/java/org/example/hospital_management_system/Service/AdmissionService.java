package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Admission;
import org.example.hospital_management_system.Entity.Room;
import org.example.hospital_management_system.Repository.AdmissionRepo;
import org.example.hospital_management_system.Repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdmissionService {

    @Autowired private AdmissionRepo admissionRepo;
    @Autowired private RoomRepo roomRepo;

    public List<Admission> getAllAdmissions() { return admissionRepo.findAll(); }

    //ADMIT PATIENT & ALLOCATE ROOM
    @Transactional
    public Admission admitPatient(Admission admission) {
        Room room = roomRepo.findById(admission.getRoom().getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if ("Occupied".equalsIgnoreCase(room.getAvailabilityStatus())) {
            throw new RuntimeException("Room is already occupied!");
        }

        // Change room status to Occupied
        room.setAvailabilityStatus("Occupied");
        roomRepo.save(room);

        return admissionRepo.save(admission);
    }

    //DISCHARGE PATIENT
    @Transactional
    public Admission dischargePatient(String admissionId) {
        Admission admission = admissionRepo.findById(admissionId)
                .orElseThrow(() -> new RuntimeException("Admission not found"));

        //Update Admission status and log the date
        admission.setAdmissionStatus("Discharged");
        admission.setDischargeDate(LocalDate.now());

        //Free up the room
        Room room = admission.getRoom();
        room.setAvailabilityStatus("Available");
        roomRepo.save(room);

        return admissionRepo.save(admission);
    }
}