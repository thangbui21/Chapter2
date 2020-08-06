/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Thắng Bùi
 */
public class RMIClient {

    RMIInterface rmiServer;
    Registry registry;

    public RMIClient(String address, int port) {
        try {
            registry = LocateRegistry.getRegistry(address, port);
            rmiServer = (RMIInterface) (registry.lookup("rmiServer"));
        } catch (RemoteException e) {
            System.out.println(e);
        } catch (NotBoundException e) {
            System.out.println(e);
        }
    }

    public String convert(String str) {
        try {
            return rmiServer.convert(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public void theEnd() {
        try {
            rmiServer.end();
        } catch (RemoteException e) {
            //e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RMIClient client = new RMIClient("localhost", 3232);
        Scanner scan = new Scanner(System.in);
        String str = "";
        try {
            do {
                System.out.println(client.convert(str));
                System.out.println("Nhập từ viết tắt: ");
                str = scan.nextLine();
            } while (!str.equalsIgnoreCase("exit"));
            client.theEnd();
        } catch (Exception e) {
            //System.out.println(e);
        }
    }
}
