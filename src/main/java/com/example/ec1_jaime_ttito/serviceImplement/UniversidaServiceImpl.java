package com.example.ec1_jaime_ttito.serviceImplement;

import com.example.ec1_jaime_ttito.model.Universidad;
import com.example.ec1_jaime_ttito.repository.IUniversidadRepository;
import com.example.ec1_jaime_ttito.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidaServiceImpl implements UniversidadService {

    @Autowired
    private IUniversidadRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Universidad> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(Universidad universidad) {
        repository.save(universidad);
    }

    @Override
    public void actualizar(Universidad universidad) {
        repository.saveAndFlush(universidad);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_universidad) {
        repository.deleteById(id_universidad);
    }

    @Override
    @Transactional
    public Universidad listarPorId(Integer id_universidad) {
        return repository.findById(id_universidad).orElse(null);
    }
}
