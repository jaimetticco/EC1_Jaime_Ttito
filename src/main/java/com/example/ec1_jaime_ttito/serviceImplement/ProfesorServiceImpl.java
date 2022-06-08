package com.example.ec1_jaime_ttito.serviceImplement;

import com.example.ec1_jaime_ttito.model.Profesor;
import com.example.ec1_jaime_ttito.repository.IProfesorRepository;
import com.example.ec1_jaime_ttito.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private IProfesorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(Profesor profesor) {
        repository.save(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        repository.saveAndFlush(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_profesor) {
        repository.deleteById(id_profesor);
    }

    @Override
    @Transactional
    public Profesor listarPorId(Integer id_profesor) {
        return repository.findById(id_profesor).orElse(null);
    }
}
