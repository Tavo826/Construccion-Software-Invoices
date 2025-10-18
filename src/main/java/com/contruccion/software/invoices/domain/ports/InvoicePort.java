package com.contruccion.software.invoices.domain.ports;

import com.contruccion.software.invoices.domain.models.Invoice;

public interface InvoicePort {

    public Invoice findById(long id);
    public Invoice save(Invoice invoice);
    public Invoice update(long id, Invoice invoice);
    public void delete(long id);
}
