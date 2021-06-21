
public class Note {
	
	private int aFachID;
	private int aPunkte;
	private String aDatum;
	private boolean aIstSchriftlich;
	
	public Note(int FachID, int Punkte, String Datum, boolean istSchriftlich) {
		this.aFachID = FachID;
		this.aPunkte = Punkte;
		this.aDatum = Datum;
		this.aIstSchriftlich = istSchriftlich;
	}
	
	public int getFachID() {
		return aFachID;
	}
	
	public boolean getIstSchriftlich() {
		return aIstSchriftlich;
	}
	
	public int getPunkte() {
		return aPunkte;
	}
	
	public String getDatum() {
		return aDatum;
	}
}
