package org.ptode_la_fuente.controller;

import org.ptode_la_fuente.model.Articolo;
import org.ptode_la_fuente.repository.ArticoloRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticoloController {
    @GetMapping("/articoli")
    public List<Articolo> getArticoli(){
        return ArticoloRepository.getArticoli();
    }
}
