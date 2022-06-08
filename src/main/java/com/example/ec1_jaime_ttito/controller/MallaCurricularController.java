package com.example.ec1_jaime_ttito.controller;

import com.example.ec1_jaime_ttito.model.MallaCurricular;
import com.example.ec1_jaime_ttito.service.MallaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("malla/v1")
public class MallaCurricularController {

    @Autowired
    private MallaCurricularService service;

    @GetMapping("/listar")
    public @ResponseBody
    List<MallaCurricular> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevo(@Validated @RequestBody MallaCurricular mallaCurricular){
        service.nuevo(mallaCurricular);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizar(@RequestBody MallaCurricular mallaCurricular){
        MallaCurricular mll = service.listarPorId(mallaCurricular.getId_malla());
        if(mll != null){
            service.actualizar(mallaCurricular);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listarId/{id_malla}")
    public ResponseEntity<MallaCurricular> obtenerId(@PathVariable Integer id_malla) {
        MallaCurricular mll = service.listarPorId(id_malla);
        if(mll != null) {
            return new ResponseEntity<MallaCurricular>(service.listarPorId(id_malla),HttpStatus.OK);
        }
        return  new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{id_malla}")
    public ResponseEntity<Void> eliminar(@Validated @RequestBody @PathVariable("id_malla")Integer id_malla) throws Exception{
        MallaCurricular mll = service.listarPorId(id_malla);
        if(mll == null){
            throw new Exception("No existe Id");
        }
        service.eliminar(id_malla);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
