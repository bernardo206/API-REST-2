package org.dh.c2023I.clinica.service;

import org.apache.log4j.Logger;
import org.dh.c2023I.clinica.model.Turno;
import org.dh.c2023I.clinica.persistence.dao.impl.TurnoDao;

import java.util.List;

public class TurnoService {

    Logger logger = Logger.getLogger(TurnoService.class);

    private TurnoDao dao = new TurnoDao();
    private PacienteService pacienteService = new PacienteService();

    public List<Turno> listarTodosLosTurnosDeUnPaciente(Integer idPaciente) {
        if(idPaciente >= 1) {
            logger.info("El id es válido :D");
            return dao.findByPaciente(idPaciente);
        }

        return null;
    }

    public Turno crear(Turno t) throws Exception {

        if(pacienteService.buscarPorId(t.getPaciente().getId()) != null){
            dao.save(t);
            return t;
        }else{
            throw new Exception("No se encontró el paciente");
        }
    }


    public List<Turno> listarTodos() {
        return dao.findAll();
    }
}
