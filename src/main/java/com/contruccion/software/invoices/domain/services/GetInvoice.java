package com.contruccion.software.invoices.domain.services;

import com.contruccion.software.invoices.application.exceptions.InvoiceNotFoundException;
import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.domain.ports.InvoicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetInvoice {

    private final InvoicePort invoicePort;

    public GetInvoice(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public Invoice getById(long id) throws Exception {

        Invoice invoice = invoicePort.findById(id);
        if (invoice == null) {
            throw new InvoiceNotFoundException("factura no encontrada");
        }

        return invoice;
    }

    public List<Invoice> getAllByPatientId(long id) throws Exception {

        List<Invoice> invoices = invoicePort.findAllByPatientId(id);
        if (invoices == null) {
            throw new InvoiceNotFoundException("factura no encontrada");
        }

        return invoices;
    }
}
