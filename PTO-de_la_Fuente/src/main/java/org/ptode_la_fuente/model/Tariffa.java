package org.ptode_la_fuente.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tariffa implements Serializable {
    private int id;
    private String nomeCorriere;
    private String nomeTariffa;
    private double pesoMassimo;
    private double costo;
}
