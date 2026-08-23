package org.example.hospital_management_system.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "BILL_ITEM")
@Data

public class BillItem {

    @Id
    @Column(name = "Bill_Item_ID", length = 20)
    private String billItemId;

    @Column(name = "Bill_ID", nullable = false, length = 20)
    private String billId;

    @Column(name = "Charge_Type", nullable = false, length = 30)
    private String chargeType;

    @Column(name = "Description")
    private String description;

    @Column(name = "Amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
}