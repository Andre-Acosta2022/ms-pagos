package upeu.edu.pe.ms_pagos.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ms_pagos.domain.metodo_pago;
import upeu.edu.pe.ms_pagos.repository.metodoRepository;
import upeu.edu.pe.ms_pagos.domain.pago;
import upeu.edu.pe.ms_pagos.service.metodo_service;
import java.util.List;
import java.util.Optional;
@Service
public class metodoServiceImpl implements metodo_service {
    @Autowired
    private metodoRepository repository;
    @Override
    public metodo_pago create(metodo_pago p) {
        return  repository.save(p);
    }

    @Override
    public metodo_pago update(metodo_pago p) {
        return repository.save(p);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);

    }

    @Override
    public Optional<metodo_pago> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<metodo_pago> readAll() {
        return repository.findAll();
    }
}
