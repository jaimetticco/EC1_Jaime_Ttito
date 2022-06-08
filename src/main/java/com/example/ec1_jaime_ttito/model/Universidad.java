package com.example.ec1_jaime_ttito.model;

import javax.persistence.*;

@Entity
@Table(name = "universidad")
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_universidad;
    private String universidad;

    @OneToOne(mappedBy = "universidad")
    private MallaCurricular mallaCurricular;

    public Integer getId_universidad() {
        return id_universidad;
    }

    public void setId_universidad(Integer id_universidad) {
        this.id_universidad = id_universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public MallaCurricular getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(MallaCurricular mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }
}
