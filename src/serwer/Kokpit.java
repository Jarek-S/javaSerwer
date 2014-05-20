/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Agnieszka
 */
public class Kokpit {

    private final String DB_USER = "jarek";
    private final String DB_PASS = "1234";
    private final String DB_NAME = "baza_pracownikow";

    public static String DB_URL = "jdbc:derby://localhost:1527/baza_pracownikow";
    public static String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    private Connection polaczenie;
    private Statement zapytanie;

    public static String LINIA = "--------------------------------------------------";

    public Kokpit() {
        try {
            Class.forName(Kokpit.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Nie ma sterownika JDBC!");
            e.printStackTrace();
        }
        try {
            polaczenie = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //    System.out.println("Połączenie z bazą nawiazane.");
            zapytanie = polaczenie.createStatement();
            //    System.out.println("Obiekt zapytania gotowy.");
        } catch (SQLException e) {
            System.err.println("Problem z połączeniem z bazą danych!");
        }
    }

    public void closeConnection() {
        try {
            polaczenie.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknięciem połączenia!");
            e.printStackTrace();
        }
    }

    public String pobierzPracownikow() {
        ResultSet lista = null;
        String zestaw = null;
        try {
            lista = zapytanie.executeQuery("SELECT * FROM pracownicy");
            while (lista.next()) {
                zestaw = "Id               : " + lista.getInt("id_pracownika")
                        + "\nImię             : " + lista.getString("imie")
                        + "\nNazwisko         : " + lista.getString("nazwisko")
                        + "\nWynagrodzenie    : " + lista.getString("pensja")
                        + "\nStanowisko       : " + lista.getString("stanowisko")
                        + "\nTelefon          : " + lista.getString("telefon");

                if (lista.getString("stanowisko").equalsIgnoreCase("Dyrektor")) {
                    zestaw += "\nDodatek służbowy : " + lista.getString("dodatek")
                            + "\nKarta służbowa   : " + lista.getString("karta_nr")
                            + "\nLimit kosztów    : " + lista.getString("limit");
                } else {
                    zestaw += "\nProwizja %       : " + lista.getString("prowizja")
                            + "\nLimit prowizji   : " + lista.getString("limit");
                }
                zestaw += "\n"+LINIA+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zestaw;
    }
}
