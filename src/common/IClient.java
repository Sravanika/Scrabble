package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observable;

public interface IClient extends Remote{

	public void update(Observable arg0, Object arg1) throws RemoteException;

}
