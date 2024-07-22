package org.ptode_la_fuente.repository;

import org.ptode_la_fuente.model.Articolo;
import org.ptode_la_fuente.model.Ordine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.ptode_la_fuente.constants.DBConfig.*;

public class OrdineRepository {
    public static List<Ordine> getLinee(){
        List<Articolo> articoli = ArticoloRepository.getArticoli();
        List<Ordine> ordini = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT id, nome FROM linea");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Ordine ordine = new Ordine(rs.getInt("id"),rs.getString("nome"));
                // aggiungo alla lista
                ordini.add(ordine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select id, id_fermata, id_linea from fermata_linea");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                aggiungiFermata(rs.getInt("id_ordine"),rs.getInt("id_articolo"), articoli, ordini);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordini;
    }

    private static void aggiungiFermata(int articoloId, int ordineId, List<Articolo> articoli, List<Ordine> ordini) {
        Articolo articolo = null;
        for (Articolo a : articoli){
            if(a.getId() == articoloId)
                articolo = a;
        }

        Ordine ordine = ordini.stream().filter(l->l.getId() == ordineId).toList().get(0);
        ordine.getArticoli().add(articolo);
    }
}
