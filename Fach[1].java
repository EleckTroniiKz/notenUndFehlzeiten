
public class Fach {

	private String aName;
	private int FachID;
	private int aAnteilSchriftlich;
	
	public Fach(String FachName, int schriftlicherAnteil, int fID) {
		this.aName = FachName;
		this.aAnteilSchriftlich = schriftlicherAnteil;
		this.FachID = fID;
	}
	
	public int getFachID() {
		return FachID;
	}
	
	public String getName() {
		return aName;
	}
	
	public int getAnteilSchriftlich() {
		return aAnteilSchriftlich;
	}
}
