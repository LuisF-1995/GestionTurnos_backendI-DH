package com.dh.clase35.controller;
import com.dh.clase35.entities.Paciente;
import com.dh.clase35.exceptions.ResourceNotFoundException;
import com.dh.clase35.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//usamos @Controller con vistas
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService IPacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> traerPacientes() {
        return ResponseEntity.ok(IPacienteService.listarPacientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> traerPacientePorId(@PathVariable("id") Long id){
        Optional<Paciente> pacienteBuscado= IPacienteService.buscarPaciente(id);
        if(pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Paciente> registrarNuevoPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(IPacienteService.guardarPaciente(paciente));
    }
    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteParaActualizar= IPacienteService.buscarPaciente(paciente.getId());
        if(pacienteParaActualizar.isPresent()){
            return ResponseEntity.ok(IPacienteService.actualizarPaciente(paciente));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteABorrar= IPacienteService.buscarPaciente(id);
        if (pacienteABorrar.isPresent()){
            IPacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó al paciente con ID="+id);
        }
        else{
            //estoy en el caso de no encontrar el ID en la base de datos
            throw new ResourceNotFoundException("!Error al eliminar¡ No se encontró al paciente con " +
                    "id="+id+". Error al ingresar el ID");

            /*
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró al paciente con " +
                    "ID="+id+" para realizar su eliminación. ¿Ingresó un ID correcto?.");

             */
        }
    }

    /*
    @GetMapping("/paciente")
    public String traerPacienteXEmail(Model model, @RequestParam("email") String email){
        Paciente paciente=pacienteService.buscarXEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "paciente";
    }

     */

}
