package com.contruccion.software.invoices.infrastructure.persistence.mapper;


import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.infrastructure.persistence.entities.InvoiceEntity;

import java.util.ArrayList;
import java.util.List;

public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice invoice) {

        if (invoice == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setPatientId(invoice.getPatientId());
        entity.setEmployeeId(invoice.getEmployeeId());
        entity.setOrderId(invoice.getOrderId());

        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {

        if (entity == null) return null;

        Invoice invoice = new Invoice();
        invoice.setId(entity.getId());
        invoice.setPatientId(entity.getPatientId());
        invoice.setEmployeeId(entity.getEmployeeId());
        invoice.setOrderId(entity.getOrderId());

        return invoice;
    }

    public static List<Invoice> toDomain(List<InvoiceEntity> entityList) {

        if (entityList == null || entityList.isEmpty()) return null;

        List<Invoice> invoiceList = new ArrayList<>();
        for (InvoiceEntity entity : entityList) {
            invoiceList.add(toDomain(entity));
        }

        return invoiceList;
    }
}
