package com.example.ec1_jaime_ttito.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("ALL")
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profesor;
    private String profesor;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "profesor_curso",
            joinColumns = @JoinColumn(
                    name = "id_profesor",
                    nullable = false, unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_profesor) references profesor(id_profesor)")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_curso",
                    nullable = false, unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_curso) references clientes(id_curso)")

            )

    )
    private List<Curso> cursos = new ArrayList<>();

    public Integer getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Integer id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }


}
