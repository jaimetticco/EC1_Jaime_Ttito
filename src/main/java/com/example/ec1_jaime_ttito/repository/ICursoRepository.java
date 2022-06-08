package com.example.ec1_jaime_ttito.repository;

import com.example.ec1_jaime_ttito.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
