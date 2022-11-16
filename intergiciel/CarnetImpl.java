import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.HashMap;
import java.util.Map;

public class CarnetImpl implements Carnet {
	

	private Map<String, SFiche> carnet;
	private int nCarnet;
	
	public CarnetImpl(int n) throws RemoteException {
		this.carnet = new HashMap<String,SFiche>();
		this.nCarnet = n;
	}
	
	@Override
	public void Ajouter(SFiche sf) throws RemoteException {
		this.carnet.put(sf.getNom(),sf);
		
	}

	@Override
	public RFiche Consulter(String n, boolean forward) throws RemoteException {
		SFiche sf = this.carnet.get(n);
		if (sf != null) {
			RFiche rf = new RFicheImpl(sf.getNom(),sf.getEmail());
			return rf;
		}
		return null; 
		
	}
	
	public static void main(String[] args) {
		
		try {
			Registry registre =  LocateRegistry.createRegistry(4000);
	        Carnet carnet = new CarnetImpl(4000);
	        registre.rebind("//"+InetAddress.getLocalHost().getHostName()+":4000/", carnet);
		} catch (Exception exc) { 
			exc.printStackTrace();
		}
        
    }
}