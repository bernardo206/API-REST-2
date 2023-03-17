package org.dh.c2023I.clinica.controller;

import org.apache.coyote.Response;
import org.apache.log4j.Logger;
import org.dh.c2023I.clinica.model.Paciente;
import org.dh.c2023I.clinica.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController implements IController<Paciente>{

    Logger logger = Logger.getLogger(PacienteController.class);

    PacienteService service = new PacienteService();

    @Override
    @GetMapping("todos")
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok().body(service.listarTodos());
    }

    @PostMapping("crear")
    public ResponseEntity<Paciente> crear(@RequestBody Paciente p){
        ResponseEntity<Paciente> respuesta;

        if(p.getDomicilio() == null){
            respuesta = ResponseEntity.badRequest().body(null);
        }else {
            respuesta = ResponseEntity.ok().body(service.crear(p));
        }

        return respuesta;
    }

    @PutMapping("modificar")
    public Paciente modificar(@RequestBody Paciente p){
        return service.modificar(p);
    }

    @GetMapping("buscarPorId/{id}") //localhost:8080/paciente/buscarPorId/
    public Paciente buscarPorIdPathVariable(@PathVariable Integer id){
        return null;
    }

    @GetMapping("buscarPorId")//localhost:8080/paciente/buscarPorId?id=2
    public Paciente buscarPorIdRequestParam(@RequestParam Integer id){
        return null;
    }
}
