/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.IOException;
import java.io.ObjectOutputStream;
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
                System.out.println("Do klienta wysłano komunikat: " + komunikat);
                ObjectOutputStream so = new ObjectOutputStream(gniazdo.getOutputStream());
                Kokpit paczka = new Kokpit();
                so.writeObject(paczka.pobierzPracownikow());
                //nadawca.println(paczka.pobierzPracownikow());
                nadawca.println("komunikat 2");
                nadawca.println("komunikat 3");
                nadawca.println("komunikat 4");
                nadawca.println("komunikat 5");

                /*InputStreamReader czytnikStrumienia = new InputStreamReader(gniazdo.getInputStream());
                BufferedReader czytnik = new BufferedReader(czytnikStrumienia);
                String komunikatKlienta = czytnik.readLine();
                System.out.println(komunikatKlienta);*/
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
