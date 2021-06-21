
import javax.swing.SwingUtilities;

public class Steuerung {

	private int aAnzSchueler = 5;
	private Schueler[] derSchueler = new Schueler[aAnzSchueler];
	private int[] schuelerIDS;
	private GUI dieGUI;

	public Steuerung() {
		dieGUI = new GUI(this);
		String[] fachSchueler1 = {"Mathe", "Deutsch", "Englisch", "Informatik", "Sport", "Ethik", "Wirtschaft", "Italienisch", "Geschichte", "Chemie", "Computertechnik"};
		String[] fachSchueler2 = {"Mathe", "Deutsch", "Englisch", "Mechatronik", "Sport", "Religion", "Physik", "Französisch"};
		String[] fachSchueler3 = {"Alte Runen", "Arithmantik", "Astronomie", "Geschichte der Zauberei", "Muggelkunde", "V.g.d.d.K.", "Zaubertränke"};
		String[] fachSchueler4 = {"Physik", "Mathe", "Chemie", "Biologie", "Sport", "Handwerken", "Englisch"};
		String[] fachSchueler5 = {"Deutsch", "Geschichte", "Philosophie", "Literatur", "Griechisch"};
		derSchueler[0] = new Schueler("Can Cetin", 4, fachSchueler1, 33);
		derSchueler[1] = new Schueler("Max Mustermann", 5, fachSchueler2, 24);
		derSchueler[2] = new Schueler("Harry Potter", 4, fachSchueler3, 21);
		derSchueler[3] = new Schueler("Peter Parker", 2, fachSchueler4, 21);
		derSchueler[4] = new Schueler("Karl May", 6, fachSchueler5, 15);
		this.schuelerIDS = new int[] {23112001, 14032003, 31071980, 10082004, 25021842, 42};
	}

	public String[] getFaecherListe(String schueler) {
		String[] emptyArray = new String[0];
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(schueler)) {
				return derSchueler[idS].getFaecher();
			}
		}
		return emptyArray;
	}

	public String[] getSchuelerListe(){
		String[] schuelerListe = new String[aAnzSchueler];
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			schuelerListe[idS] = derSchueler[idS].getName();
		}
		return schuelerListe;
	}

	public void anzeigenFehlzeiten(String pVon, String pBis, String pSchueler ) {

		for(int idS = 0; idS < aAnzSchueler; idS++) {
			String s = derSchueler[idS].getName();
			if(pSchueler.equals(s)) {
				dieGUI.anzeigenFehlzeiten(derSchueler[idS].berechnenFehlzeiten(pVon, pBis));
				break;
			}
		}
		return;
	}

	public boolean pruefeLogIn(String name, int pin) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(name.equals(derSchueler[idS].getName())) {
				if(pin == schuelerIDS[idS]) {
					return true;
				}
			}
		}
		return false;
	}

	public void anzeigenMNoten(String pFach, String pSchueler) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(pSchueler)) {
				dieGUI.anzeigenMNoten(this.derSchueler[idS].getMNoten(pFach));
				break;
			}
		}
		return;
	}

	public void anzeigenMNotenSchnitt(String pFach, String pSchueler) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(pSchueler)) {
				dieGUI.anzeigenMNotenSchnitt(derSchueler[idS].berechnenDurchschnittMuendlich(pFach));
			}
		}
	}

	public void anzeigenSNotenSchnitt(String pFach, String pSchueler) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(pSchueler)) {
				dieGUI.anzeigenSNotenSchnitt(derSchueler[idS].berechnenDurchschnittSchriftlich(pFach));
			}
		}
	}

	public void anzeigenSNoten(String pFach, String pSchueler) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(pSchueler)) {
				dieGUI.anzeigenSNoten(derSchueler[idS].getSNoten(pFach));
			}
		}
	}
	
	public void setAnwesenheit(String schueler, int minuten, int stunde, String[] datum, String zustand) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(schueler)) {
				derSchueler[idS].setAnwesenheit(schueler, minuten, stunde, datum, zustand);
				return;
			}
		}
	}
	
	public void setNote(String schueler, String fach, String datum, int Punkte, boolean schriftlich) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(schueler)) {
				derSchueler[idS].setNote(derSchueler[idS].getFachID(fach), Punkte, datum, schriftlich);
				return;
			}
		}
	}

	public void deleteNote(int id, String schueler) {
		for(int i = 0; i < aAnzSchueler; i++) {
			if(derSchueler[i].getName().equals(schueler)) {
				derSchueler[i].deleteNote(id);
			}
		}
	}
	
	public String[] getNotenListe(String ausgewaehlterSchueler) {
		String[] emptyArray = new String[0];
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(ausgewaehlterSchueler)) {
				return derSchueler[idS].getNotenListe();
			}
		}
		return emptyArray;
	}
	
	public String[] getFehlzeitenListe(String schueler) {
		String[] emptyArray = new String[0];
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(schueler)) {
				return derSchueler[idS].getFehlzeitenListe();
			}
		}
		return emptyArray;
	}
	
	public void setFehlzeit(String datum , String Zustand, String fach,String schueler, int stunde, int fehlzeitInMinuten) {
		for(int idS = 0; idS < aAnzSchueler; idS++) {
			if(derSchueler[idS].getName().equals(schueler)) {
				derSchueler[idS].setFehlzeit(datum, Zustand, derSchueler[idS].getFachID(fach), stunde, fehlzeitInMinuten);
				return;
			}
		}
	}
	
	public void deleteFehlzeit(String schueler, int id) {
		for(int i = 0; i < aAnzSchueler; i++) {
			if(derSchueler[i].getName().equals(schueler)) {
				derSchueler[i].deleteFehlzeit(id);
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Steuerung();
			}
		});
	}

}