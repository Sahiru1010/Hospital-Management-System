package org.example.hospital_management_system.Repository;

import org.example.hospital_management_system.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, String> {

    //Enforces the Business Rule: Checks if the doctor already has an appointment at this exact time
    boolean existsByDoctor_DoctorIdAndAppointmentDateAndAppointmentTime(String doctorId, LocalDate date, LocalTime time);

    //View doctor schedules: Finds all appointments for a specific doctor, ordered by date and time
    List<Appointment> findByDoctor_DoctorIdOrderByAppointmentDateAscAppointmentTimeAsc(String doctorId);

}