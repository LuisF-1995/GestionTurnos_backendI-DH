package com.dh.clase35.respository;

import com.dh.clase35.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    /*
     List<T> listarElementos(); -- > findAll()
     T buscarXId(int id); findById
     T buscarXCriterio(String criterio);
     void eliminar(int id);
     T guardar(T t);
     T actualizar(T t);
     */
}
