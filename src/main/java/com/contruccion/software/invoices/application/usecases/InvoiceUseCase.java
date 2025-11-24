package com.contruccion.software.invoices.application.usecases;

import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.domain.services.CreateInvoice;
import com.contruccion.software.invoices.domain.services.DeleteInvoice;
import com.contruccion.software.invoices.domain.services.GetInvoice;
import com.contruccion.software.invoices.domain.services.UpdateInvoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceUseCase {

    private final GetInvoice getInvoice;
    private final CreateInvoice createInvoice;
    private final UpdateInvoice updateInvoice;
    private final DeleteInvoice deleteInvoice;

    public InvoiceUseCase(
            GetInvoice getInvoice,
            CreateInvoice createInvoice,
            UpdateInvoice updateInvoice,
            DeleteInvoice deleteInvoice) {
        this.getInvoice = getInvoice;
        this.createInvoice = createInvoice;
        this.updateInvoice = updateInvoice;
        this.deleteInvoice = deleteInvoice;
    }

    public Invoice getInvoiceById(long id) throws Exception {

        return getInvoice.getById(id);
    }

    public List<Invoice> getAllInvoicesByPatientId(long id) throws Exception {

        return getInvoice.getAllByPatientId(id);
    }

    public Invoice createInvoice(Invoice invoice) {

        return createInvoice.create(invoice);
    }

    public Invoice updateInvoice(long id, Invoice invoice) throws Exception {

        return updateInvoice.update(id, invoice);
    }

    public void deleteInvoice(long id) throws Exception {

        deleteInvoice.delete(id);
    }
}
