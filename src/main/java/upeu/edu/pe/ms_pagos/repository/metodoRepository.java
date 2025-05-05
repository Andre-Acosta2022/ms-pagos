package upeu.edu.pe.ms_pagos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.ms_pagos.domain.metodo_pago;

public interface metodoRepository extends JpaRepository<metodo_pago,Long> {
}
