package rmi_clojure;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRemoteHelloWorld extends Remote {
    String sayHello() throws RemoteException;
}
