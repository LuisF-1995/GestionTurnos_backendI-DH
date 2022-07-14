package com.dh.clase35.service;

import com.dh.clase35.entities.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    List<Odontologo> listarOdontologo();
    Optional<Odontologo> buscarOdontologo(Long id);
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
}
