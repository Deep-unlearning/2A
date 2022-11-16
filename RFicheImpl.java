import java.rmi.RemoteException;

public class RFicheImpl implements RFiche {

	String RNom;
	String REmail;
	
	public RFicheImpl (String nom, String email) {
		this.RNom = nom;
		this.REmail = email;	
	}
	
	
	@Override
	public String getNom() throws RemoteException {
		return this.RNom;
	}

	@Override
	public String getEmail() throws RemoteException {
		return this.REmail;
	}
	
}