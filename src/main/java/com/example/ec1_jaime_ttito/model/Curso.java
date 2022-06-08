package com.example.ec1_jaime_ttito.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer id_curso;
    private String curso;
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "id_malla", nullable = false, unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition =
            "foreign key (id_malla) references malla_curricular(id_malla)"))
    private MallaCurricular mallaCurricular;

    @OneToOne
    @JoinColumn(name = "id_profesor",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_profesor) references profesor(id_profesor)"))//aqui se crea como esta en base de datos
    private Profesor profesores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MallaCurricular getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(MallaCurricular mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

    public Profesor getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesor profesores) {
        this.profesores = profesores;
    }


}
