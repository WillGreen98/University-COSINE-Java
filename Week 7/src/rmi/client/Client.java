package rmi.client;

import java.io.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
        rmi.RemoteInterface handle = (rmi.RemoteInterface) reg.lookup("Server");

        int messageCount = 0;
        do {
            String message = in.readLine();
            messageCount += 1;

            handle.printMessage(message);
        } while(messageCount <= 10);
    }
}