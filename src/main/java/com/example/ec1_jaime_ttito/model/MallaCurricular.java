package com.example.ec1_jaime_ttito.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "malla_curricular")
public class MallaCurricular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_malla;
    private String anio;

    @OneToOne
    @JoinColumn(name = "id_universidad",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_universidad) references universida(id_universidad)"))//aqui se crea como esta en base de datos
    private Universidad universidad;

    @OneToMany(mappedBy = "mallaCurricular")
    private List<Curso> cursos = new ArrayList<>();


    public Integer getId_malla() {
        return id_malla;
    }

    public void setId_malla(Integer id_malla) {
        this.id_malla = id_malla;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
}


