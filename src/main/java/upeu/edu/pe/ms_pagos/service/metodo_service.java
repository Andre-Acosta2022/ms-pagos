package upeu.edu.pe.ms_pagos.service;
import upeu.edu.pe.ms_pagos.domain.metodo_pago;
import java.util.List;
import java.util.Optional;

public interface metodo_service {
    metodo_pago create(metodo_pago p);
    metodo_pago update(metodo_pago p);
    void delete(Long id);
    Optional<metodo_pago> read(Long id);
    List<metodo_pago> readAll();
}
