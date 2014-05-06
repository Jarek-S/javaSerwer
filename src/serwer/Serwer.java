/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serwer {

    String komunikat = "Cześć, to ja, Twój serwer.";
    
    public void doRoboty() {

        try {
            ServerSocket gniazdoSerwera = new ServerSocket(6666);
            while(true) {
                Socket gniazdo = gniazdoSerwera.accept();
                PrintWriter nadawca = new PrintWriter(gniazdo.getOutputStream());
                nadawca.println(komunikat);
                nadawca.close();
                System.out.println("Do klienta wysłano komunikat: "+komunikat);
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
