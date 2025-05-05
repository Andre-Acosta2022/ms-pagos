package upeu.edu.pe.ms_pagos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import upeu.edu.pe.ms_pagos.domain.pago;
import upeu.edu.pe.ms_pagos.repository.pagoRepository;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ms_pagos.service.pagoService;
import java.util.List;
import java.util.Optional;
@Service
public class pagoServiceImpl implements pagoService {
        @Autowired
        private pagoRepository repository;
        @Override
        public pago create(pago p) {
            return repository.save(p);
        }

        @Override
        public pago update(pago p) {
            return repository.save(p);
        }

        @Override
        public void delete(Long id) {
            repository.deleteById(id);
        }

        @Override
        public Optional<pago> read(Long id) {
            return repository.findById(id);
        }

        @Override
        public List<pago> readAll() {
            return repository.findAll();
        }
}
