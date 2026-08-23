package org.example.hospital_management_system.Controller;

import org.example.hospital_management_system.Entity.Appointment;
import org.example.hospital_management_system.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    //BOOK
    @PostMapping
    public ResponseEntity<?> book(@RequestBody Appointment appointment) {
        try {
            Appointment savedAppt = appointmentService.bookAppointment(appointment);
            return new ResponseEntity<>(savedAppt, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); // Returns 409 Conflict if clash
        }
    }

    //Update Appointment
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable String id, @RequestBody Appointment appointment) {
        return appointmentService.getAppointmentById(id).map(existing -> {
            appointment.setAppointmentId(id);
            return ResponseEntity.ok(appointmentService.updateAppointment(appointment));
        }).orElse(ResponseEntity.notFound().build());
    }

    //Cancel Appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancel(@PathVariable String id) {
        appointmentService.cancelAppointment(id);
        return ResponseEntity.ok("Appointment Cancelled Successfully");
    }

    //View Doctor's Schedule
    @GetMapping("/schedule/{doctorId}")
    public ResponseEntity<List<Appointment>> viewSchedule(@PathVariable String doctorId) {
        return ResponseEntity.ok(appointmentService.getDoctorSchedule(doctorId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable String doctorId) {
        return ResponseEntity.ok(appointmentService.getDoctorAppointments(doctorId));
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
}