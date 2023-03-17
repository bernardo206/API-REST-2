package org.dh.c2023I.clinica.controller;

import org.apache.log4j.Logger;
import org.dh.c2023I.clinica.model.Turno;
import org.dh.c2023I.clinica.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController implements IController<Turno>{

    Logger logger = Logger.getLogger(TurnoService.class);

    TurnoService service = new TurnoService();

    @GetMapping("buscarPorPaciente")
    public List<Turno> listarTodosLosTurnosDeUnPaciente(@RequestParam Integer idPaciente) {
        return service.listarTodosLosTurnosDeUnPaciente(idPaciente);
    }

    @Override
    @GetMapping("todos")
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok().body(service.listarTodos());
    }

    @PostMapping("nuevo")
    public ResponseEntity<Turno> crearNuevo(@RequestBody Turno t){
        ResponseEntity<Turno> respuesta;

        logger.info("Intentando crear el turno:" + t.toString());

        if(t.getPaciente() == null || t.getOdontologo() == null){
            respuesta = ResponseEntity.badRequest().body(null);
        }else {
            try {
                respuesta = ResponseEntity.ok().body(service.crear(t));
            } catch (Exception e) {
                respuesta = ResponseEntity.notFound().build();
            }
        }

        return respuesta;
    }
}
