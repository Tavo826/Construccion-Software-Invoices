package com.contruccion.software.invoices.adapter.out;

import com.contruccion.software.invoices.domain.models.Invoice;
import com.contruccion.software.invoices.domain.ports.InvoicePort;
import com.contruccion.software.invoices.infrastructure.persistence.entities.InvoiceEntity;
import com.contruccion.software.invoices.infrastructure.persistence.mapper.InvoiceMapper;
import com.contruccion.software.invoices.infrastructure.persistence.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceAdapter implements InvoicePort {

    private final InvoiceRepository invoiceRepository;

    public InvoiceAdapter(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice findById(long id) {

        Optional<InvoiceEntity> invoiceOptional = invoiceRepository.findById(id);

        if (invoiceOptional.isPresent()) {
            InvoiceEntity invoiceEntity = invoiceOptional.get();

            return InvoiceMapper.toDomain(invoiceEntity);
        }

        return null;
    }

    @Override
    public Invoice save(Invoice invoice) {

        InvoiceEntity invoiceEntity = invoiceRepository.save(InvoiceMapper.toEntity(invoice));

        return InvoiceMapper.toDomain(invoiceEntity);
    }

    @Override
    public Invoice update(long id, Invoice invoice) {

        Optional<InvoiceEntity> invoiceOptional = invoiceRepository.findById(id);

        if (invoiceOptional.isPresent()) {
            InvoiceEntity invoiceEntity = invoiceOptional.get();

            invoiceEntity.setName(invoice.getName());

            InvoiceEntity updatedInvoiceInvoice = invoiceRepository.save(invoiceEntity);

            return InvoiceMapper.toDomain(updatedInvoiceInvoice);
        }

        return null;
    }

    @Override
    public void delete(long id) {

        invoiceRepository.deleteById(id);
    }
}
