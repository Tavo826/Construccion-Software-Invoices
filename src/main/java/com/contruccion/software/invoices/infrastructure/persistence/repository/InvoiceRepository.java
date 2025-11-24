package com.contruccion.software.invoices.infrastructure.persistence.repository;

import com.contruccion.software.invoices.infrastructure.persistence.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    Optional<List<InvoiceEntity>> findAllByPatientId(long id);
}
