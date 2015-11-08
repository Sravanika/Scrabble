package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import code.Board_CE_085;
import code.Dictionary_085;
import code.Inventory_CE;
import code.Player_CE_085;
import code.Position;

public interface IServer extends Remote {
	public static final String SERVER_REGISTRY_KEY = "Dog";
	
	public void addIClient(IClient c) throws RemoteException;
	
	public void boardButtonPressed(int x, int y) throws RemoteException;
	
	public void tileRackButtonPressed(int index) throws RemoteException;
	
	public void endTurnButtonPressed() throws RemoteException;
	

}
