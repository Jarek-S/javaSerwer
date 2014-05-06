/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serwer {

    public static void main(String args[]) {
        ServerSocket gnd;
        Socket polaczenie;
        OutputStream wyjscie;
        PrintWriter komunikat;
        try {
            gnd = new ServerSocket(6666);
            System.out.println("Serwer testowy. Nasłuch: " + gnd);
        
            polaczenie = gnd.accept();
            wyjscie = polaczenie.getOutputStream();
            komunikat = new PrintWriter(wyjscie);
            komunikat.print("Tu serwer. Czym mogę słuzyć?");
       
            polaczenie.close();
            wyjscie.close();
            komunikat.close();
        } catch (IOException e) {
            System.out.println("Problem z zamknięciem połączenia lub strumienia");
        }
    }
}
