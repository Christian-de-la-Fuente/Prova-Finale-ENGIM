package org.ptode_la_fuente.repository;

import org.ptode_la_fuente.model.Articolo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.ptode_la_fuente.constants.DBConfig.*;

public class ArticoloRepository {
    public static List<Articolo> getArticoli(){
        List<Articolo> articoli = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT id, codice, descrizione, peso FROM articolo");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Articolo articolo = new Articolo(
                        rs.getInt("id"),
                        rs.getString("codice"),
                        rs.getString("descrizione"),
                        rs.getDouble("peso")
                        );
                // aggiungo alla lista
                articoli.add(articolo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articoli;
    }
}
