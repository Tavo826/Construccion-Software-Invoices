package com.contruccion.software.invoices.domain.services;

import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.domain.ports.InvoicePort;
import org.springframework.stereotype.Service;

@Service
public class DeleteInvoice {

    private final InvoicePort invoicePort;

    public DeleteInvoice(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public void delete(long id) throws Exception {

        invoicePort.delete(id);
    }
}
