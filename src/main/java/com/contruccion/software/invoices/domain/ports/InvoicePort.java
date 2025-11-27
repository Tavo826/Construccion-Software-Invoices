package com.contruccion.software.invoices.domain.ports;

import com.contruccion.software.invoices.domain.models.Invoice;

import java.util.List;

public interface InvoicePort {

    Invoice findById(long id);
    List<Invoice> findAllByPatientId(long id);
    Invoice save(Invoice invoice);
    Invoice update(long id, Invoice invoice);
    void delete(long id);
}
