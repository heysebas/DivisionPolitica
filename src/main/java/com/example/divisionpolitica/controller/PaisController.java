package com.example.divisionpolitica.controller;

import com.example.divisionpolitica.model.entity.Pais;
import com.example.divisionpolitica.model.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAll(){
        return paisService.getPaises();
    }

    @GetMapping("/{paisID}")
    public Optional<Pais> getBId(@PathVariable("paisId") Long paisId){
        return paisService.getPaise(paisId);
    }


    //@PostMapping
    //public void saveUpdate(@RequestBody Pais pais){
    //     paisService.saveOrUpdate(pais);
  //  }

    @PostMapping
    public List<Pais> listSave(@RequestBody List<Pais> pais){
        return paisService.listSave(pais);
    }


    @DeleteMapping("/{paisId}")
    public void delete(@PathVariable("paisId") Long paisId){
        paisService.delete(paisId);
    }
}
