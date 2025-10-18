package com.contruccion.software.invoices.adapter.in.rest.controllers;

import com.contruccion.software.invoices.adapter.in.builder.InvoiceBuilder;
import com.contruccion.software.invoices.adapter.in.rest.request.InvoiceRequest;
import com.contruccion.software.invoices.application.exceptions.InputsException;
import com.contruccion.software.invoices.application.usecases.InvoiceUseCase;
import com.contruccion.software.invoices.domain.models.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    private final InvoiceBuilder invoiceBuilder;
    private final InvoiceUseCase invoiceUseCase;

    public InvoiceController(InvoiceBuilder invoiceBuilder, InvoiceUseCase invoiceUseCase) {
        this.invoiceBuilder = invoiceBuilder;
        this.invoiceUseCase = invoiceUseCase;
    }

    @GetMapping("/Invoices/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable String id) throws Exception {

        Invoice invoice = invoiceUseCase.getInvoiceById(invoiceBuilder.getId(id));

        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/Invoices")
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceRequest request) throws Exception {

        Invoice invoice = invoiceBuilder.build(request.getName());

        Invoice createdInvoice = invoiceUseCase.createInvoice(invoice);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdInvoice);
    }

    @PatchMapping("/Invoices/{id}")
    public ResponseEntity<?> updateInvoice(@PathVariable String id, @RequestBody InvoiceRequest request) throws Exception {

        Invoice invoice = invoiceBuilder.build(request.getName());

        Invoice updatedInvoice = invoiceUseCase.updateInvoice(invoiceBuilder.getId(id), invoice);

        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/Invoices/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable String id) throws Exception {

        invoiceUseCase.deleteInvoice(invoiceBuilder.getId(id));

        return ResponseEntity.noContent().build();
    }
}
