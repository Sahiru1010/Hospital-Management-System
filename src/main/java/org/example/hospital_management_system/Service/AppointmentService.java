package org.example.hospital_management_system.Service;

import org.example.hospital_management_system.Entity.Appointment;
import org.example.hospital_management_system.Repository.AppointmentRepo;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    //Book Appointment With Clash Prevention
    public Appointment bookAppointment(@NonNull Appointment appointment) {
        boolean isClash = appointmentRepo.existsByDoctor_DoctorIdAndAppointmentDateAndAppointmentTime(
                appointment.getDoctor().getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime()
        );

        if (isClash) {
            throw new RuntimeException("The doctor is already booked at this exact date and time.");
        }
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> getDoctorAppointments(String doctorId) {
        return appointmentRepo.findByDoctor_DoctorIdOrderByAppointmentDateAscAppointmentTimeAsc(doctorId);
    }


    //Update Appointment
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    //Cancel Appointment
    public void cancelAppointment(String id) {
        appointmentRepo.deleteById(id);
    }

    //View Doctor Schedules
    public List<Appointment> getDoctorSchedule(String doctorId) {
        return appointmentRepo.findByDoctor_DoctorIdOrderByAppointmentDateAscAppointmentTimeAsc(doctorId);
    }

    public Optional<Appointment> getAppointmentById(String id) {
        return appointmentRepo.findById(id);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
}