package com.example.ec1_jaime_ttito.service;

import com.example.ec1_jaime_ttito.model.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> listar();
    void nuevo(Profesor profesor);
    void actualizar(Profesor profesor);
    void eliminar(Integer id_profesor);
    Profesor listarPorId(Integer id_profesor);
}
