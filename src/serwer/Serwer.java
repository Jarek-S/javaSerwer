/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

/**
 *
 * @author Agnieszka
 */
import java.io.*;
import java.net.*;

/**
 *
 * @author Agnieszka
 */
public class Serwer {

    public static void main(String args[]) {
        ServerSocket gnd = null;
        Socket polaczenie = null;
        OutputStream wyjscie = null;
        PrintWriter komunikat = null;
        try {
            gnd = new ServerSocket(6666);
            System.out.println("Serwer testowy. Nasłuch: " + gnd);
        } catch (IOException e) {
            System.out.println("Problem z utworzeniem gniazda na serwerze");
        }

        try {
            polaczenie = gnd.accept();
            wyjscie = polaczenie.getOutputStream();
            komunikat = new PrintWriter(wyjscie);
            komunikat.print("Tu serwer. Czym mogę słuzyć?");
        } catch (Exception e) {
            System.out.println("Nie można zapisać danych do strumienia wyjściowego");
        }

        try {
            polaczenie.close();
            wyjscie.close();
            komunikat.close();
        } catch (IOException e) {
            System.out.println("Problem z zamknięciem połączenia lub strumienia");
        }
    }
}
