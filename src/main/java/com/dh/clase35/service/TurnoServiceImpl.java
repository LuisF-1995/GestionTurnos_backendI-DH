package com.dh.clase35.service;

import com.dh.clase35.entities.Turno;
import com.dh.clase35.respository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public Turno guardarTurno(Turno turno){
        return turnoRepository.save(turno);
    }

    @Override
    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> buscarTurnoXId(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
