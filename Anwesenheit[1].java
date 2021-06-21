
public class Anwesenheit {
	
	private int aFachID;
	private String aDatum;
	private int aStunde;
	private int aFehlzeitInMinuten;
	private String aZustand;
	
	public Anwesenheit(int fID, String datum, int stunde, int minuten, String zustand) {
		this.aFachID = fID;
		this.aDatum = datum;
		this.aStunde = stunde;
		this.aFehlzeitInMinuten = minuten;
		this.aZustand = zustand;
	}
	
	public int getStunde() {
		return aStunde;
	}
	
	public String getZustand() {
		return aZustand;
	}
	
	public String getDatum() {
		return aDatum;
	}
	
	public int getFehlzeitInMinuten() {
		return aFehlzeitInMinuten;
	}

	public int getFachID() {
		return aFachID;
	}
}
