package com.example.ec1_jaime_ttito.serviceImplement;

import com.example.ec1_jaime_ttito.model.MallaCurricular;
import com.example.ec1_jaime_ttito.repository.IMallaCurricularRespository;
import com.example.ec1_jaime_ttito.service.MallaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

    @Autowired
    private IMallaCurricularRespository respository;

    @Override
    @Transactional(readOnly = true)
    public List<MallaCurricular> listar() {
        return respository.findAll();
    }

    @Override
    @Transactional
    public void nuevo(MallaCurricular mallaCurricular) {
        respository.save(mallaCurricular);
    }

    @Override
    public void actualizar(MallaCurricular mallaCurricular) {
        respository.saveAndFlush(mallaCurricular);
    }

    @Override
    @Transactional(readOnly = true)
    public void eliminar(Integer id_malla) {
        respository.deleteById(id_malla);
    }

    @Override
    @Transactional
    public MallaCurricular listarPorId(Integer id_malla) {
        return respository.findById(id_malla).orElse(null);
    }
}
