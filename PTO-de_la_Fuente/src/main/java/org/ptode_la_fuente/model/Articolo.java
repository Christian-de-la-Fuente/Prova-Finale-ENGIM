package org.ptode_la_fuente.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Articolo implements Serializable {
    private int id;
    private String codice;
    private String descrizione;
    private double peso;
}
