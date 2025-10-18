package com.contruccion.software.invoices.infrastructure.persistence.mapper;


import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.infrastructure.persistence.entities.InvoiceEntity;

public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice invoice) {

        if (invoice == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setName(invoice.getName());

        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {

        if (entity == null) return null;

        Invoice invoice = new Invoice();
        invoice.setId(entity.getId());
        invoice.setName(entity.getName());

        return invoice;
    }
}
