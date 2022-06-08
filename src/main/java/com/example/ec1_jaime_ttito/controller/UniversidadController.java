package com.example.ec1_jaime_ttito.controller;

import com.example.ec1_jaime_ttito.model.Universidad;
import com.example.ec1_jaime_ttito.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universidad/v1")
public class UniversidadController {

    @Autowired
    private UniversidadService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<Universidad> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevo(@Validated @RequestBody Universidad universidad){
        service.nuevo(universidad);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizar(@RequestBody Universidad universidad){
        Universidad uni = service.listarPorId(universidad.getId_universidad());
        if(uni != null){
            service.actualizar(universidad);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listarId/{id_universidad}")
    public ResponseEntity<Universidad> obtenerId(@PathVariable Integer id_universidad) {
        Universidad uni = service.listarPorId(id_universidad);
        if(uni != null) {
            return new ResponseEntity<Universidad>(service.listarPorId(id_universidad),HttpStatus.OK);
        }
        return  new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id_universidad}")
    public ResponseEntity<Void> eliminar(@Validated @RequestBody @PathVariable("id_universidad")Integer id_universidad) throws Exception{
        Universidad uni = service.listarPorId(id_universidad);
        if(uni == null){
            throw new Exception("No existe Id");
        }
        service.eliminar(id_universidad);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
