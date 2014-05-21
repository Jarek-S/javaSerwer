/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Agnieszka
 */
public class SerwerRMI {

    public SerwerRMI(){
    }
    
        public static void main(String args[]) {

        try {
            Registry registry = LocateRegistry.createRegistry(7777);
            ManagerImpl rmi = new ManagerImpl();
            registry.rebind("Zarządca", rmi);
            System.out.println("Serwer RMI czeka na żądanie...");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
