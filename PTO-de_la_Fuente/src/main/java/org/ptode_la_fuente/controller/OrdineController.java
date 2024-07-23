package org.ptode_la_fuente.controller;

import org.ptode_la_fuente.model.Ordine;
import org.ptode_la_fuente.model.Tariffa;
import org.ptode_la_fuente.payload.OrdineConTariffa;
import org.ptode_la_fuente.repository.OrdineRepository;
import org.ptode_la_fuente.repository.TariffaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class OrdineController {
    @GetMapping("/ordini")
    public List<OrdineConTariffa> getOrdini() {
        List<OrdineConTariffa> ordiniConT = new ArrayList<>();
        List<Ordine> ordini = OrdineRepository.getOrdini();
        List<Tariffa> tariffe = TariffaRepository.getTariffe();

        for (Ordine ordine : ordini) {
            double pesoTotale = OrdineRepository.calcolaPesoTotale(ordine);
            Tariffa tariffaMigliore = tariffe.stream()
                    .filter(t -> t.getPesoMassimo() >= pesoTotale)
                    .min(Comparator.comparingDouble(Tariffa::getCosto))
                    .orElse(null);

            if (tariffaMigliore != null) {
                ordiniConT.add(new OrdineConTariffa(ordine, tariffaMigliore));
            }
        }

        return ordiniConT;
    }
}
