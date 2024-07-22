package org.ptode_la_fuente.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ordine implements Serializable {
    private int id;
    private int numero;
    private LocalDate data;
    private List<Articolo> articoli;

    public Ordine(int id, int numero, LocalDate data) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        articoli = new ArrayList<>();
    }
}
