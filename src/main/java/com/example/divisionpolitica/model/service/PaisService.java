package com.example.divisionpolitica.model.service;

import com.example.divisionpolitica.model.entity.Pais;
import com.example.divisionpolitica.model.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {
    @Autowired
    PaisRepository paisRepository;

    public List<Pais> getPaises(){
        return paisRepository.findAll();
    }

    public Optional<Pais> getPaise(Long id){
        return paisRepository.findById(id);
    }

    public void saveOrUpdate(Pais pais){
        paisRepository.save(pais);
    }

    public void delete(Long id){
        paisRepository.deleteById(id);
    }

    public List<Pais> listSave(List<Pais> pais){
       return paisRepository.saveAll(pais);
    }

}
