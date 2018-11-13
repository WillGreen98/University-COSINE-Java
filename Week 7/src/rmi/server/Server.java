package rmi.server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server extends UnicastRemoteObject implements rmi.RemoteInterface {
    private Server() throws RemoteException {}

    public void printMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();

        Registry reg = LocateRegistry.createRegistry(1234);
        reg.bind("Server", server);
    }
}