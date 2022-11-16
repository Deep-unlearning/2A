public class SFicheImpl implements SFiche {

	private static final long serialVersionUID = 1L;

	String SNom;
	String SEmail;
	
	public SFicheImpl (String nom, String email) {
		this.SNom = nom;
		this.SEmail = email;	
	}
	
	@Override
	public String getNom() {
		return this.SNom;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.SEmail;
	}
}