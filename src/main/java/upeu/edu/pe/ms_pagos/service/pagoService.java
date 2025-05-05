package upeu.edu.pe.ms_pagos.service;
import upeu.edu.pe.ms_pagos.domain.pago;
import java.util.List;
import java.util.Optional;

public interface pagoService {
    pago create(pago p);
    pago update(pago p);
    void delete(Long id);
    Optional<pago> read(Long id);
    List<pago> readAll();
}
