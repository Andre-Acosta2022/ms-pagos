package upeu.edu.pe.ms_pagos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ms_pagos.domain.metodo_pago;
import upeu.edu.pe.ms_pagos.service.metodo_service;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/metodopagos")
public class MetodoController {
    @Autowired
    private metodo_service service;

    @GetMapping
    public ResponseEntity<List<metodo_pago>> readAll() {
        try {
            List<metodo_pago> metodos = service.readAll();
            if(metodos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(metodos, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<metodo_pago> guardarPaciente(@Valid @RequestBody metodo_pago met) {
        try {
            metodo_pago c = service.create(met);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<metodo_pago> getPacienteId(@PathVariable("id") Long id) {
        try {
            metodo_pago c = service.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable("id") Long id, @Valid @RequestBody metodo_pago met){

        Optional<metodo_pago> c = service.read(id);
        if(!c.isEmpty()) {
            met.setId(id); // Asigna el ID para evitar crear uno nuevo
            return new ResponseEntity<>(service.update(met), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}

