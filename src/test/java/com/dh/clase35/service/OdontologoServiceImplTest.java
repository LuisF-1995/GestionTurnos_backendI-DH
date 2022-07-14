package com.dh.clase35.service;

import com.dh.clase35.entities.Odontologo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceImplTest {
    @Autowired
    IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void agregarOdontologoTest(){
        Odontologo odontoDePrueba= new Odontologo("Pablo","Torres","847");
        odontologoService.guardarOdontologo(odontoDePrueba);
        //busqueda del nuevo elemento
        Optional<Odontologo> odontoDePruebaRecuperado=odontologoService.buscarOdontologo(1l);
        assertTrue(odontoDePruebaRecuperado.isPresent());
    }
    @Test
    @Order(2)
    public void buscarOdontologoTest(){
        Long idBuscado=1l;
        Optional<Odontologo> odontoDeRecuperado=odontologoService.buscarOdontologo(idBuscado);
        assertTrue(odontoDeRecuperado.isPresent());
    }
    @Test
    @Order(3)
    public void listarOdontologosTest(){
        List<Odontologo> listaDePrueba=odontologoService.listarOdontologo();
        assertTrue(listaDePrueba.size()>0);
    }
    @Test
    @Order(4)
    public void actualizarOdontologoTest(){
        Long idBuscado=1l;
        Odontologo odontoConNuevosDatos=
                new Odontologo(idBuscado,"Diego","Reales","847");
        odontologoService.actualizarOdontologo(odontoConNuevosDatos);
        Optional<Odontologo> odontoRecuperado=odontologoService.buscarOdontologo(idBuscado);
        assertEquals("Reales",odontoRecuperado.get().getApellido());
    }

    @Test
    @Order(5)
    void eliminarOdontologoTest() {
        Long idAEliminar=1l;
        odontologoService.eliminarOdontologo(idAEliminar);
        Optional<Odontologo> odontologoEliminar = odontologoService.buscarOdontologo(idAEliminar);
        System.out.println(odontologoEliminar);
        assertTrue(odontologoEliminar.isEmpty());
    }
}