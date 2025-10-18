package com.contruccion.software.invoices.domain.services;

import com.contruccion.software.invoices.application.exceptions.InvoiceNotFoundException;
import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.domain.ports.InvoicePort;
import org.springframework.stereotype.Service;

@Service
public class UpdateInvoice {

    private final InvoicePort invoicePort;

    public UpdateInvoice(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public Invoice update(long id, Invoice invoice) throws Exception {

        Invoice updatedInvoice = invoicePort.update(id, invoice);
        if (updatedInvoice == null) {
            throw new InvoiceNotFoundException("factura no encontrada");
        }

        return updatedInvoice;
    }
}
