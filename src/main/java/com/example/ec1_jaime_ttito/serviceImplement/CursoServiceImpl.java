package com.example.ec1_jaime_ttito.serviceImplement;

import com.example.ec1_jaime_ttito.model.Curso;
import com.example.ec1_jaime_ttito.repository.ICursoRepository;
import com.example.ec1_jaime_ttito.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private ICursoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(Curso curso) {
        repository.save(curso);
    }

    @Override
    public void actualizar(Curso curso) {
        repository.saveAndFlush(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_curso) {
        repository.deleteById(id_curso);
    }

    @Override
    @Transactional
    public Curso listarPorId(Integer id_curso) {
        return repository.findById(id_curso).orElse(null);
    }
}
