package com.contruccion.software.invoices.adapter.in.validators;

import com.contruccion.software.invoices.application.exceptions.InputsException;

public abstract class SimpleValidator {

    public String stringValidator(String element, String value) throws InputsException {
        if (value == null || value.equals("")) {
            throw new InputsException(element + " no puede tener un valor vacío o nulo");
        }
        return value;
    }

    public long longValidator(String element, String value) throws InputsException {
        stringValidator(element, value);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new InputsException(element + " debe ser un valor numérico");
        }
    }
}
