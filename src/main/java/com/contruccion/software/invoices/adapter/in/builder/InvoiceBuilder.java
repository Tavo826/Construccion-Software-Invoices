package com.contruccion.software.invoices.adapter.in.builder;

import com.contruccion.software.invoices.adapter.in.validators.InvoiceValidator;
import com.contruccion.software.invoices.application.exceptions.InputsException;
import com.contruccion.software.invoices.domain.models.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceBuilder {

    private final InvoiceValidator invoiceValidator;

    public InvoiceBuilder(InvoiceValidator invoiceValidator) {
        this.invoiceValidator = invoiceValidator;
    }

    public Invoice build(String name) throws InputsException {

        Invoice invoice = new Invoice();
        invoice.setName(invoiceValidator.nameValidator(name));

        return invoice;
    }

    public long getId(String id) throws InputsException {

        return invoiceValidator.idValidator(id);
    }
}
