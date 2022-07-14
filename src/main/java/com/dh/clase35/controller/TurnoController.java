package com.dh.clase35.controller;

import com.dh.clase35.entities.Turno;
import com.dh.clase35.exceptions.BadRequestException;
import com.dh.clase35.exceptions.ResourceNotFoundException;
import com.dh.clase35.service.ITurnoService;
import com.dh.clase35.service.IOdontologoService;
import com.dh.clase35.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService IPacienteService;

    @Autowired
    public TurnoController(ITurnoService turnoService, IOdontologoService odontologoService, com.dh.clase35.service.IPacienteService IPacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.IPacienteService = IPacienteService;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> verTurnos(){
        if (turnoService.listarTurnos().isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurnoId(@PathVariable Long id){
        Optional<Turno> turnoBuscado=turnoService.buscarTurnoXId(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Turno> registrarNuevoTurno(@RequestBody Turno turno) throws BadRequestException {
        Long pacienteId = turno.getPaciente().getId();
        Long odontologoId = turno.getOdontologo().getId();

        if (IPacienteService.buscarPaciente(pacienteId).isEmpty()){
            throw new BadRequestException("!Error al agregar turno¡ El paciente con ID "+ pacienteId +" no existe, favor crearlo");
        } else if (odontologoService.buscarOdontologo(odontologoId).isEmpty()) {
            throw new BadRequestException("!Error al agregar turno¡ El odontologo con ID "+ odontologoId +" no existe, favor crearlo");
        } else {
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
    }

    @PutMapping
    public ResponseEntity<Turno> modificarTurno(@RequestBody Turno turno){
        Optional<Turno> turnoParaActualizar= turnoService.buscarTurnoXId(turno.getId());
        if (turnoParaActualizar.isPresent()){
            return ResponseEntity.ok(turnoService.actualizarTurno(turno));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoAEliminar=turnoService.buscarTurnoXId(id);
        if (turnoAEliminar.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se eliminó al turno con id= "+id+" de la base de datos");
        }
        else{
            throw new ResourceNotFoundException("!Error¡ No se pudo eliminar el turno con id "+ id+", Turno no encontrado");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
