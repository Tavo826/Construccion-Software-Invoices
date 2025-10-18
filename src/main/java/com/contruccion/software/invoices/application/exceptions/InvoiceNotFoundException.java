package com.contruccion.software.invoices.application.exceptions;

public class InvoiceNotFoundException extends Exception {
    public InvoiceNotFoundException(String message) {
        super(message);
    }
}
