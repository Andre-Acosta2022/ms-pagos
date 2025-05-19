package upeu.edu.pe.ms_pagos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ms_pagos.domain.metodo_pago;
import upeu.edu.pe.ms_pagos.domain.pago;
import upeu.edu.pe.ms_pagos.service.metodo_service;
import upeu.edu.pe.ms_pagos.service.pagoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    @Autowired
    private pagoService service;

    @GetMapping
    public ResponseEntity<List<pago>> readAll() {
        try {
            List<pago> pagos = service.readAll();
            if(pagos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<pago> guardarPago(@Valid @RequestBody pago pag) {
        try {
            pago c = service.create(pag);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<pago> getPagoId(@PathVariable("id") Long id) {
        try {
            pago c = service.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePago(@PathVariable("id") Long id, @Valid @RequestBody pago pag){

        Optional<pago> c = service.read(id);
        if(!c.isEmpty()) {
            pag.setId(id); // Asigna el ID para evitar crear uno nuevo
            return new ResponseEntity<>(service.update(pag), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
