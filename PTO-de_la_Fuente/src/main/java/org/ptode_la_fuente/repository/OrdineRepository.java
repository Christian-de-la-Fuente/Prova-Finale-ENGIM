package org.ptode_la_fuente.repository;

import org.ptode_la_fuente.model.Articolo;
import org.ptode_la_fuente.model.Ordine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.ptode_la_fuente.constants.DBConfig.*;

public class OrdineRepository {
    public static List<Ordine> getOrdini(){
        List<Articolo> articoli = ArticoloRepository.getArticoli();
        List<Ordine> ordini = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordine");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Ordine ordine = new Ordine(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getDate("data").toLocalDate());
                // aggiungo alla lista
                ordini.add(ordine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select id, ordine_id, articolo_id from voce");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                aggiungiArticolo(rs.getInt("id_ordine"),rs.getInt("id_articolo"), articoli, ordini);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordini;
    }

    private static void aggiungiArticolo(int articoloId, int ordineId, List<Articolo> articoli, List<Ordine> ordini) {
        Articolo articolo = null;
        for (Articolo a : articoli){
            if(a.getId() == articoloId)
                articolo = a;
        }

        Ordine ordine = ordini.stream().filter(o->o.getId() == ordineId).toList().get(0);
        ordine.getArticoli().add(articolo);
    }
}
