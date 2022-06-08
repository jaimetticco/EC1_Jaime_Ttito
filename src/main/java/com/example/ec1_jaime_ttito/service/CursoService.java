package com.example.ec1_jaime_ttito.service;

import com.example.ec1_jaime_ttito.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    void nuevo(Curso curso);
    void actualizar(Curso curso);
    void eliminar(Integer id_curso);
    Curso listarPorId(Integer id_curso);
}
