package com.example.ec1_jaime_ttito.controller;

import com.example.ec1_jaime_ttito.model.Curso;
import com.example.ec1_jaime_ttito.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curso/v1")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<Curso> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevo(@Validated @RequestBody Curso curso){
        service.nuevo(curso);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizar(@RequestBody Curso curso){
        Curso crs = service.listarPorId(curso.getId_curso());
        if(crs != null){
            service.actualizar(curso);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listarId/{id_curso}")
    public ResponseEntity<Curso> obtenerId(@PathVariable Integer id_curso) {
        Curso crs = service.listarPorId(id_curso);
        if(crs != null) {
            return new ResponseEntity<Curso>(service.listarPorId(id_curso),HttpStatus.OK);
        }
        return  new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id_curso}")
    public ResponseEntity<Void> eliminar(@Validated @RequestBody @PathVariable("id_curso")Integer id_curso) throws Exception{
        Curso crs = service.listarPorId(id_curso);
        if(crs == null){
            throw new Exception("No existe Id");
        }
        service.eliminar(id_curso);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }




}
