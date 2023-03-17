package org.dh.c2023I.clinica.controller;

import org.dh.c2023I.clinica.model.Odontologo;
import org.dh.c2023I.clinica.service.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OdontologoController implements IController<Odontologo> {

    OdontologoService service = new OdontologoService();

    @Override
    @GetMapping("odontologo-todos")
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok().body(service.listarTodos());
    }
}
