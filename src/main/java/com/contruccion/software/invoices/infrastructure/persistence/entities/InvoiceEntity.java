package com.contruccion.software.invoices.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices", indexes = {
        @Index(name = "idx_patient_id", columnList = "patientId"),
})
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long patientId;

    @Column(nullable = false)
    private long employeeId;

    @Column(nullable = false)
    private String orderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
