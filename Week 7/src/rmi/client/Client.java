package rmi.client;

import java.io.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
        rmi.RemoteInterface handle = (rmi.RemoteInterface) reg.lookup("Server");

        String message = in.readLine();
        handle.printMessage(message);
    }
}