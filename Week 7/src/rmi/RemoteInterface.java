package rmi;

import java.rmi.* ;

public interface RemoteInterface extends Remote {
    void printMessage(String message) throws RemoteException ;
}