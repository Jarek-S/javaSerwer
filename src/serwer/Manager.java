/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serwer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 *
 * @author Agnieszka
 */
public interface Manager extends Remote {
    public void zapiszDoPliku(String dane) throws RemoteException;
    public HashMap odczytajPlik() throws RemoteException;
}
