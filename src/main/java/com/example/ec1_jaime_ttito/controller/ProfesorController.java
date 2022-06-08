package com.example.ec1_jaime_ttito.controller;

import com.example.ec1_jaime_ttito.model.Profesor;
import com.example.ec1_jaime_ttito.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor/v1")
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<Profesor> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevo(@Validated @RequestBody Profesor profesor){
        service.nuevo(profesor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizar(@RequestBody Profesor profesor){
        Profesor pro = service.listarPorId(profesor.getId_profesor());
        if(pro != null){
            service.actualizar(profesor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listarId/{id_profesor}")
    public ResponseEntity<Profesor> obtenerId(@PathVariable Integer id_profesor) {
        Profesor pro = service.listarPorId(id_profesor);
        if(pro != null) {
            return new ResponseEntity<Profesor>(service.listarPorId(id_profesor),HttpStatus.OK);
        }
        return  new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id_profesor}")
    public ResponseEntity<Void> eliminar(@Validated @RequestBody @PathVariable("id_profesor")Integer id_profesor) throws Exception{
        Profesor pro = service.listarPorId(id_profesor);
        if(pro == null){
            throw new Exception("No existe Id");
        }
        service.eliminar(id_profesor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
