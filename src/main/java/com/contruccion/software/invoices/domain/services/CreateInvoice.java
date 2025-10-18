package com.contruccion.software.invoices.domain.services;

import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.domain.ports.InvoicePort;
import org.springframework.stereotype.Service;

@Service
public class CreateInvoice {

    private final InvoicePort invoicePort;

    public CreateInvoice(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public Invoice create(Invoice invoice) {

        return invoicePort.save(invoice);
    }
}
