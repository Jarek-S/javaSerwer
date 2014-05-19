/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serwer {

    String komunikat = "Połączenie nawiązane";

    public void doRoboty() {

        try {
            ServerSocket gniazdoSerwera = new ServerSocket(6666);
            while (true) {
                Socket gniazdo = gniazdoSerwera.accept();
                PrintWriter nadawca = new PrintWriter(gniazdo.getOutputStream());
                nadawca.println(komunikat);
                nadawca.close();
                
                System.out.println("Do klienta wysłano komunikat: " + komunikat);

                InputStreamReader czytnikStrumienia = new InputStreamReader(gniazdo.getInputStream());
                BufferedReader czytnik = new BufferedReader(czytnikStrumienia);
                String komunikatKlienta = czytnik.readLine();
                System.out.println(komunikatKlienta);
                nadawca.close();
                System.out.println("Połączenie zakończone");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Serwer serwerek = new Serwer();
        serwerek.doRoboty();
    }
}
