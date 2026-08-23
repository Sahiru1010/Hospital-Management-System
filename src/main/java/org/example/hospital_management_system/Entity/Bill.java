package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "BILL")
@Data
public class Bill {

    //Primary Key
    @Id
    @Column(name = "Bill_ID", length = 20)
    private String billId;

    //Association to Patient
    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    //Charge Breakdown
    @Column(name = "Consultation_Charges")
    private Double consultationCharges = 0.0;

    @Column(name = "Room_Charges")
    private Double roomCharges = 0.0;

    @Column(name = "Laboratory_Charges")
    private Double laboratoryCharges = 0.0;

    @Column(name = "Medicine_Charges")
    private Double medicineCharges = 0.0;

    //Final Bill Details
    @Column(name = "Total_Amount", nullable = false)
    private Double totalAmount;

    @Column(name = "Bill_Date", nullable = false)
    private LocalDate billDate;

    //"Pending", "Paid"
    @Column(name = "Payment_Status", length = 50)
    private String paymentStatus = "Pending";

    //Cash, "Credit Card", "Insurance"
    @Column(name = "Payment_Method", length = 50)
    private String paymentMethod;
}