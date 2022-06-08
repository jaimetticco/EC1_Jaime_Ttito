package com.example.ec1_jaime_ttito.service;

import com.example.ec1_jaime_ttito.model.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversidadService {

    List<Universidad> listar();
    void nuevo(Universidad universidad);
    void actualizar(Universidad universidad);
    void eliminar(Integer id_universidad);
    Universidad listarPorId(Integer id_universidad);
}
