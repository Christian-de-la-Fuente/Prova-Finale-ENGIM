package org.ptode_la_fuente.repository;

import org.ptode_la_fuente.model.Tariffa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.ptode_la_fuente.constants.DBConfig.*;

public class TariffaRepository {
    public static List<Tariffa> getTariffe(){
        List<Tariffa> tariffe = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM preventivo");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                // creo una fermata con i dati del DB
                Tariffa tariffa = new Tariffa(
                        rs.getInt("id"),
                        rs.getString("nome_corriere"),
                        rs.getString("nome_tariffa"),
                        rs.getDouble("peso_massimo"),
                        rs.getDouble("costo")
                );
                // aggiungo alla lista
                tariffe.add(tariffa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tariffe;
    }
}
