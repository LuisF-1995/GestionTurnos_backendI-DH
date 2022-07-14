package com.dh.clase35.service;

import com.dh.clase35.entities.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    Turno guardarTurno(Turno turno);
    List<Turno> listarTurnos();
    Optional<Turno> buscarTurnoXId(Long id);
    Turno actualizarTurno(Turno turno);
    void eliminarTurno(Long id);

}
