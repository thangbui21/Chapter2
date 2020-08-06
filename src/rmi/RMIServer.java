/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Thắng Bùi
 */
public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    int thisPort = 3232;
    String thisAddress;
    Registry registry;

    public RMIServer() throws RemoteException {
        try {
            registry = LocateRegistry.createRegistry(thisPort);
            registry.rebind("rmiServer", this);
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Word> getListWord() {
        ArrayList<Word> list = new ArrayList<Word>();
        try {
            FileReader fr = new FileReader("src\\rmi\\Word.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine()) != null) {
                String s[] = str.split("\\$");
                //Word(String low, String high)
                Word w = new Word(s[0], s[1]);
                list.add(w);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public String convert(String str) throws RemoteException {
        String result = "";
        for (int i = 0; i < getListWord().size(); i++) {
            if (str.equalsIgnoreCase(getListWord().get(i).getLow())) {
                System.out.println();
                result += getListWord().get(i).getHigh();
            }
        }
        return result;
    }

    public static void main(String[] args) throws RemoteException, Exception {
        new RMIServer();
    }

    @Override
    public void end() throws RemoteException {
        System.out.println("Stopping rmi Server");
        UnicastRemoteObject.unexportObject(registry, true);
        System.exit(0);
    }
}
