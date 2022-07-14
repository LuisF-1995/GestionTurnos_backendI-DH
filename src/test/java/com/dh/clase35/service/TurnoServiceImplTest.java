package com.dh.clase35.service;

import com.dh.clase35.entities.Domicilio;
import com.dh.clase35.entities.Odontologo;
import com.dh.clase35.entities.Paciente;
import com.dh.clase35.entities.Turno;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoServiceImplTest {
    @Autowired
    ITurnoService turnoService;
    @Autowired
    PacienteServiceImpl pacienteService;
    @Autowired
    OdontologoServiceImpl odontologoService;


    @Test
    @Order(1)
    void guardarTurnoTest() {
        Domicilio domicilio = new Domicilio("barrio", 45, "BA", "Argentina");
        Paciente paciente= new Paciente("lopez", "daniel", "daniel@gmail.com", 4568932, LocalDate.now(), domicilio );
        Odontologo odonto= new Odontologo("Luz", "Suarez", "Matricula-98");

        Turno turno = new Turno(odonto, paciente, LocalDate.now());

        pacienteService.guardarPaciente(paciente);
        odontologoService.guardarOdontologo(odonto);
        turnoService.guardarTurno(turno);
        Optional<Turno> turnoRecuperado=turnoService.buscarTurnoXId(1l);
        assertTrue(turnoRecuperado.isPresent());
    }

    @Test
    @Order(2)
    void listarTurnosTest() {
        List<Turno> listaTurnosRecuperados = turnoService.listarTurnos();
        assertTrue(listaTurnosRecuperados.size()>0);
    }

    @Test
    @Order(3)
    void buscarTurnoXIdTest() {
        long idTurnoBuscar = 1l;
        Optional<Turno> turnoBuscado = turnoService.buscarTurnoXId(idTurnoBuscar);
        assertTrue(turnoBuscado.isPresent());
    }

    @Test
    @Order(4)
    void eliminarTurnoTest() {
        long idTurnoEliminar = 1l;
        turnoService.eliminarTurno(idTurnoEliminar);

        Optional<Turno> turnoBuscadoDespuesDeEliminar = turnoService.buscarTurnoXId(1l);
        assertFalse(turnoBuscadoDespuesDeEliminar.isPresent());
    }
}