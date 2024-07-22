package org.ptode_la_fuente.controller;

import org.ptode_la_fuente.model.Ordine;
import org.ptode_la_fuente.model.Tariffa;
import org.ptode_la_fuente.payload.OrdineConTariffa;
import org.ptode_la_fuente.repository.OrdineRepository;
import org.ptode_la_fuente.repository.TariffaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdineController {
    @GetMapping("/ordini")
    public List<OrdineConTariffa> getOrdini(){

        List<OrdineConTariffa> ordiniConT = new ArrayList<>();

        List<Ordine> ordini = OrdineRepository.getOrdini();
        List<Tariffa> tariffe = TariffaRepository.getTariffe();

        for (Ordine o: ordini){
            List<Tariffa> tariffeAmmissibili = new ArrayList<>();
            for (Tariffa t : tariffe){
                /*if(preventivoAmmissibile(o,t)){
                    tariffeAmmissibili.add(t);
                }*/
            }
            Tariffa tMinore = tariffeAmmissibili.get(0);
            for(Tariffa t: tariffeAmmissibili){
                if(tMinore.getCosto()> t.getCosto())
                    tMinore = t;
            }
            ordiniConT.add(new OrdineConTariffa(o,tMinore));


        }

        return ordiniConT;
    }

    /*private boolean preventivoAmmissibile(Ordine o, Tariffa t) {


        int nFermate = 0;
        int nExtraUrbane = 0;
        int nZone = 0;
        List<String> zoneViste = new ArrayList<>();
        for (Fermata f : l.getFermate()){
            nFermate++;
            if(!f.getZona().equals("U"))
                nExtraUrbane++;
            if(!zoneViste.contains(f.getZona())) {
                nZone++;
                zoneViste.add(f.getZona());
            }
        }
        return nFermate <= p.getMaxFermate() &&
                nExtraUrbane <= p.getMaxExtraurbane() &&
                nZone <= p.getMaxZone();
    }*/
}
