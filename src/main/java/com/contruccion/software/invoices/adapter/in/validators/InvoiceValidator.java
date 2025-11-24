package com.contruccion.software.invoices.adapter.in.validators;

import com.contruccion.software.invoices.application.exceptions.InputsException;
import org.springframework.stereotype.Component;

@Component
public class InvoiceValidator extends SimpleValidator {

    public long idValidator(String value) throws InputsException {
        return longValidator("id", value);
    }
}
