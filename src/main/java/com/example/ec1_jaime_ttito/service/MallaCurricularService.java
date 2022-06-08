package com.example.ec1_jaime_ttito.service;

import com.example.ec1_jaime_ttito.model.MallaCurricular;

import java.util.List;

public interface MallaCurricularService {
    List<MallaCurricular> listar();
    void nuevo(MallaCurricular mallaCurricular);
    void actualizar(MallaCurricular mallaCurricular);
    void eliminar(Integer id_malla);
    MallaCurricular listarPorId(Integer id_malla);
}
