package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/db_gestion_examen";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie !");

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM notefinales";

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ID | Eleve | Matiere | Note Finale");
            System.out.println("------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nomEleve = rs.getString("nom_eleve");
                String nomMatiere = rs.getString("nom_matiere");
                double noteFinale = rs.getDouble("notefinale");

                System.out.printf("%d | %s | %s | %.2f%n", id, nomEleve, nomMatiere, noteFinale);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}