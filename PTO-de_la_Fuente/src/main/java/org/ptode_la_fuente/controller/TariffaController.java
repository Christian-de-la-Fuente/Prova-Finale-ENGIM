package org.ptode_la_fuente.controller;

import org.ptode_la_fuente.model.Tariffa;
import org.ptode_la_fuente.repository.TariffaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TariffaController {
    @GetMapping("/tariffe")
    public List<Tariffa> getTariffe(){
        return TariffaRepository.getTariffe();
    }
}
