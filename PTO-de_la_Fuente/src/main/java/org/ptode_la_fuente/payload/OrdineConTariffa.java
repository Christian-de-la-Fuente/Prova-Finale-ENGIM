package org.ptode_la_fuente.payload;

import lombok.Getter;
import org.ptode_la_fuente.model.Ordine;
import org.ptode_la_fuente.model.Tariffa;

@Getter
public class OrdineConTariffa extends Ordine {
    private double costo;
    private String nomeCorriere;
    private String nomeTariffa;

    public OrdineConTariffa(Ordine o, Tariffa t){
        super(o.getId(), o.getNumero(), o.getData());
        costo = t.getCosto();
        nomeCorriere = t.getNomeCorriere();
        nomeTariffa = t.getNomeTariffa();
    }
}
