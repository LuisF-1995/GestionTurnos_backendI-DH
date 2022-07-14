package com.dh.clase35.service;

import com.dh.clase35.entities.Domicilio;
import com.dh.clase35.entities.Paciente;
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
public class PacienteServiceImplTest {
    @Autowired
    IPacienteService pacienteService;

    @Test
    @Order(1)
    public void agregarPacienteTest(){
        Domicilio domicilioTest = new Domicilio("calle", 59, "Medellin", "Antioquia");

        Paciente pacienteTest= new Paciente("Rodriguez", "Luis", "luis@mailTest.com", 109461, LocalDate.now(), domicilioTest);
        pacienteService.guardarPaciente(pacienteTest);
        //busqueda del nuevo elemento
        Optional<Paciente> pacienteTestRecuperado=pacienteService.buscarPaciente(1l);
        assertTrue(pacienteTestRecuperado.isPresent());
    }
    @Test
    @Order(2)
    public void buscarPacienteTest(){
        Long idBuscado=1l;
        Optional<Paciente> pacienteRecuperado=pacienteService.buscarPaciente(idBuscado);
        assertTrue(pacienteRecuperado.isPresent());
    }

    @Test
    @Order(3)
    public void listarPacientesTest(){
        List<Paciente> listaDePrueba=pacienteService.listarPacientes();
        assertTrue(listaDePrueba.size()>0);
    }

    @Test
    @Order(4)
    public void actualizarPacienteTest(){
        Long idBuscado=1l;
        Domicilio domicilioNuevoTest = new Domicilio("Cra", 24, "Medellin", "Antioquia");
        Paciente pacienteActualizar = new Paciente(idBuscado,"Ramirez", "Luis", "luisNuevo@mailTest.com", 109461, LocalDate.now(), domicilioNuevoTest);
        pacienteService.actualizarPaciente(pacienteActualizar);
        Optional<Paciente> pacienteActualizadoEncontrado = pacienteService.buscarPaciente(idBuscado);
        assertEquals("Ramirez",pacienteActualizadoEncontrado.get().getApellido());
    }

    @Test
    @Order(5)
    void eliminarPacienteTest() {
        Long idAEliminar=1l;
        pacienteService.eliminarPaciente(idAEliminar);
        Optional<Paciente> pacienteEliminar = pacienteService.buscarPaciente(idAEliminar);
        System.out.println(pacienteEliminar);
        assertTrue(pacienteEliminar.isEmpty());
    }
}