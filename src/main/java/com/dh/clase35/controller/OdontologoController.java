package com.dh.clase35.controller;

import com.dh.clase35.entities.Odontologo;
import com.dh.clase35.exceptions.ResourceNotFoundException;
import com.dh.clase35.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Odontologo>> traerOdontologos() {
        return ResponseEntity.ok(odontologoService.listarOdontologo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> traerOdontologoPorId(@PathVariable("id") Long id){
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologo(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("")
    public ResponseEntity<Odontologo> registrarNuevoOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }
    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoParaActualizar= odontologoService.buscarOdontologo(odontologo.getId());
        if(odontologoParaActualizar.isPresent()){
            return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoABorrar= odontologoService.buscarOdontologo(id);
        if (odontologoABorrar.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó al odontólogo con ID="+id);
        }
        else{
            //estoy en el caso de no encontrar el ID en la base de datos
            throw new ResourceNotFoundException("!Error al eliminar¡ No se encontró al odontólogo con " +
                    "id="+id+". Error al ingresar el ID");

            /*
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al paciente con " +
                    "ID="+id+" para realizar su eliminación. ¿Ingresó un ID correcto?.");

             */
        }
    }
}
