import java.util.ArrayList;

public class Schueler {

	private String aName;
	private int aAnzAnwesenheit;
	private int aAnzFaecher;
	private int aAnzNoten;
	private Fach[] dasFach;
	private Note[] dieNote;
	private Anwesenheit[] dieAnwesenheit;

	public Schueler(String Name, int AnzAnwesenheit, String[] faecherNamen, int AnzNoten) {
		this.aName = Name;
		this.aAnzAnwesenheit = AnzAnwesenheit;
		this.aAnzFaecher = faecherNamen.length;
		this.aAnzNoten = AnzNoten;
		this.dasFach = new Fach[aAnzFaecher];
		for(int i = 0; i < faecherNamen.length; i++) {
			this.dasFach[i] = new Fach(faecherNamen[i], 50, i);
		}
		this.dieAnwesenheit = new Anwesenheit[this.aAnzAnwesenheit];
		this.dieNote = new Note[this.aAnzNoten];
		if(Name.equals("Can Cetin")) {
			this.dieAnwesenheit[0] = new Anwesenheit(1, "01-01-2020", 1, 15, "verspätet");
			this.dieAnwesenheit[1] = new Anwesenheit(3, "02-02-2021", 4, 20, "verspätet");
			this.dieAnwesenheit[2] = new Anwesenheit(1, "03-03-2021", 1, 12, "verspätet");
			this.dieAnwesenheit[3] = new Anwesenheit(2, "04-04-2021", 1, 4, "verspätet");
			
			this.dieNote[0] = new Note(0, 13, "15-02-2021", true);
			this.dieNote[1] = new Note(0, 15, "16-03-2021", false);
			this.dieNote[2] = new Note(0, 14, "17-04-2021", true);

			this.dieNote[3] = new Note(1, 8, "01-02-2021", true);
			this.dieNote[4] = new Note(1, 13, "08-04-2021", false);
			this.dieNote[5] = new Note(1, 9, "10-05-2021", true);

			this.dieNote[6] = new Note(2, 11, "17-01-2021", true);
			this.dieNote[7] = new Note(2, 15, "18-03-2021", false);
			this.dieNote[8] = new Note(2, 13, "19-06-2021", true);

			this.dieNote[9] = new Note(3, 13, "14-02-2021", false);
			this.dieNote[10] = new Note(3, 12, "24-03-2021", true);
			this.dieNote[11] = new Note(3, 12, "13-06-2021", true);

			this.dieNote[12] = new Note(4, 14, "11-04-2021", false);
			this.dieNote[13] = new Note(4, 12, "12-05-2021", true);
			this.dieNote[14] = new Note(4, 8, "24-06-2021", true);

			this.dieNote[15] = new Note(5, 14, "12-06-2021", false);
			this.dieNote[16] = new Note(5, 11, "14-03-2021", true);
			this.dieNote[17] = new Note(5, 13, "23-05-2021", false);

			this.dieNote[18] = new Note(6, 12, "30-04-2021", true);
			this.dieNote[19] = new Note(6, 1, "29-03-2021", true);
			this.dieNote[20] = new Note(6, 15, "15-01-2021", false);

			this.dieNote[21] = new Note(7, 14, "12-01-2021", true);
			this.dieNote[22] = new Note(7, 15, "14-02-2021", false);
			this.dieNote[23] = new Note(7, 14, "15-03-2021", true);

			this.dieNote[24] = new Note(8, 13, "16-01-2021", true);
			this.dieNote[25] = new Note(8, 12, "18-02-2021", false);
			this.dieNote[26] = new Note(8, 10, "10-02-2021", true);

			this.dieNote[27] = new Note(9, 12, "17-04-2021", true);
			this.dieNote[28] = new Note(9, 13, "18-05-2021", false);
			this.dieNote[29] = new Note(9, 13, "19-06-2021", true);

			this.dieNote[30] = new Note(10, 14, "02-04-2021", false);
			this.dieNote[31] = new Note(10, 13, "26-04-2021", true);
			this.dieNote[32] = new Note(10, 13, "02-05-2021", false);

		}
		else if(Name.equals("Max Mustermann")) {
			this.dieAnwesenheit[0] = new Anwesenheit(1, "01-01-2021", 1, 15, "verspätet");
			this.dieAnwesenheit[1] = new Anwesenheit(3, "02-02-2021", 4, 20, "verspätet");
			this.dieAnwesenheit[2] = new Anwesenheit(1, "03-03-2021", 1, 12, "verspätet");
			this.dieAnwesenheit[3] = new Anwesenheit(2, "04-04-2021", 1, 4, "verspätet");
			this.dieAnwesenheit[4] = new Anwesenheit(2, "05-05-2021", 1, 2, "verspätet");

			this.dieNote[0] = new Note(0, 10, "01-03-2021", true);
			this.dieNote[1] = new Note(0, 11, "05-05-2021", false);
			this.dieNote[2] = new Note(0, 12, "09-06-2021", true);

			this.dieNote[3] = new Note(1, 13, "01-02-2021", true);
			this.dieNote[4] = new Note(1, 14, "08-03-2021", false);
			this.dieNote[5] = new Note(1, 15, "10-06-2021", true);

			this.dieNote[6] = new Note(2, 10, "17-03-2021", true);
			this.dieNote[7] = new Note(2, 11, "11-06-2021", false);
			this.dieNote[8] = new Note(2, 12, "26-06-2021", true);

			this.dieNote[9] = new Note(3, 13, "02-01-2021", false);
			this.dieNote[10] = new Note(3, 14, "03-03-2021", true);
			this.dieNote[11] = new Note(3, 15, "14-04-2021", true);

			this.dieNote[12] = new Note(4, 10, "15-03-2021", false);
			this.dieNote[13] = new Note(4, 12, "16-04-2021", true);
			this.dieNote[14] = new Note(4, 11, "19-05-2021", true);

			this.dieNote[15] = new Note(5, 12, "23-04-2021", false);
			this.dieNote[16] = new Note(5, 11, "28-05-2021", true);
			this.dieNote[17] = new Note(5, 13, "30-06-2021", false);

			this.dieNote[18] = new Note(6, 10, "13-02-2021", true);
			this.dieNote[19] = new Note(6, 9, "14-04-2021", true);
			this.dieNote[20] = new Note(6, 12, "15-05-2021", false);

			this.dieNote[21] = new Note(7, 11, "01-03-2021", true);
			this.dieNote[22] = new Note(7, 12, "05-04-2021", false);
			this.dieNote[23] = new Note(7, 10, "09-06-2021", true);
		}
		else if(Name.equals("Harry Potter")) {
			this.dieAnwesenheit[0] = new Anwesenheit(1, "12-02-1992", 1, 45, "fehlend");
			this.dieAnwesenheit[1] = new Anwesenheit(3, "13-03-1994", 4, 8, "verspätet");
			this.dieAnwesenheit[2] = new Anwesenheit(1, "14-04-1993", 1, 45, "fehlend");
			this.dieAnwesenheit[3] = new Anwesenheit(3, "15-05-1994", 4, 45, "fehlend");

			this.dieNote[0] = new Note(0, 8, "01-03-1994", true);
			this.dieNote[1] = new Note(0, 12, "05-03-1994", false);
			this.dieNote[2] = new Note(0, 10, "09-03-1994", true);

			this.dieNote[3] = new Note(1, 9, "01-02-1994", true);
			this.dieNote[4] = new Note(1, 11, "08-02-1994", false);
			this.dieNote[5] = new Note(1, 10, "10-02-1994", true);

			this.dieNote[6] = new Note(2, 8, "17-03-1994", true);
			this.dieNote[7] = new Note(2, 9, "18-03-1994", false);
			this.dieNote[8] = new Note(2, 10, "19-03-1994", true);

			this.dieNote[9] = new Note(3, 12, "02-01-1994", false);
			this.dieNote[10] = new Note(3, 10, "03-01-1994", true);
			this.dieNote[11] = new Note(3, 14, "14-01-1994", true);

			this.dieNote[12] = new Note(4, 14, "15-03-1994", false);
			this.dieNote[13] = new Note(4, 13, "16-03-1994", true);
			this.dieNote[14] = new Note(4, 15, "19-03-1994", true);

			this.dieNote[15] = new Note(5, 14, "23-04-1994", false);
			this.dieNote[16] = new Note(5, 15, "28-04-1994", true);
			this.dieNote[17] = new Note(5, 14, "30-04-1994", false);

			this.dieNote[18] = new Note(6, 7, "23-04-1994", false);
			this.dieNote[19] = new Note(6, 6, "28-04-1994", true);
			this.dieNote[20] = new Note(6, 8, "30-04-1994", false);
		}
		else if(Name.equals("Peter Parker")){
			this.dieAnwesenheit[0] = new Anwesenheit(1, "02-02-2021", 1, 2, "verspätet");
			this.dieAnwesenheit[1] = new Anwesenheit(3, "07-03-2021", 4, 4, "verspätet");

			this.dieNote[0] = new Note(0, 14, "01-02-2021", true);
			this.dieNote[1] = new Note(0, 13, "05-04-2021", false);
			this.dieNote[2] = new Note(0, 15, "09-05-2021", true);

			this.dieNote[3] = new Note(1, 13, "01-02-2021", true);
			this.dieNote[4] = new Note(1, 15, "08-03-2021", false);
			this.dieNote[5] = new Note(1, 14, "10-04-2021", true);

			this.dieNote[6] = new Note(2, 14, "17-04-2021", true);
			this.dieNote[7] = new Note(2, 15, "18-05-2021", false);
			this.dieNote[8] = new Note(2, 13, "19-06-2021", true);

			this.dieNote[9] = new Note(3, 14, "02-02-2021", false);
			this.dieNote[10] = new Note(3, 15, "03-03-2021", true);
			this.dieNote[11] = new Note(3, 15, "14-05-2021", true);

			this.dieNote[12] = new Note(4, 15, "15-01-2021", false);
			this.dieNote[13] = new Note(4, 13, "16-05-2021", true);
			this.dieNote[14] = new Note(4, 14, "19-06-2021", true);

			this.dieNote[15] = new Note(5, 14, "23-04-2021", false);
			this.dieNote[16] = new Note(5, 15, "23-05-2021", true);
			this.dieNote[17] = new Note(5, 12, "30-05-2021", false);

			this.dieNote[18] = new Note(6, 14, "23-02-2021", false);
			this.dieNote[19] = new Note(6, 15, "28-03-2021", true);
			this.dieNote[20] = new Note(6, 12, "30-05-2021", false);
		}
		else if(Name.equals("Karl May")) {
			this.dieAnwesenheit[0] = new Anwesenheit(1, "12-02-1857", 1, 45, "fehlend");
			this.dieAnwesenheit[1] = new Anwesenheit(3, "13-03-1859", 4, 8, "verspätet");
			this.dieAnwesenheit[2] = new Anwesenheit(1, "14-04-1859", 1, 45, "fehlend");
			this.dieAnwesenheit[3] = new Anwesenheit(3, "15-05-1858", 4, 45, "fehlend");
			this.dieAnwesenheit[4] = new Anwesenheit(1, "16-05-1858", 1, 5, "verspätet");
			this.dieAnwesenheit[5] = new Anwesenheit(3, "17-06-1858", 4, 8, "verspätet");

			this.dieNote[0] = new Note(0, 12, "01-02-1858", true);
			this.dieNote[1] = new Note(0, 13, "05-04-1858", false);
			this.dieNote[2] = new Note(0, 11, "09-06-1858", true);

			this.dieNote[3] = new Note(1, 14, "01-02-1858", true);
			this.dieNote[4] = new Note(1, 12, "08-04-1858", false);
			this.dieNote[5] = new Note(1, 11, "10-06-1858", true);

			this.dieNote[6] = new Note(2, 14, "17-03-1859", true);
			this.dieNote[7] = new Note(2, 12, "18-05-1859", false);
			this.dieNote[8] = new Note(2, 13, "19-06-1859", true);

			this.dieNote[9] = new Note(3, 12, "02-02-1858", false);
			this.dieNote[10] = new Note(3, 10, "03-04-1858", true);
			this.dieNote[11] = new Note(3, 11, "14-05-1858", true);

			this.dieNote[12] = new Note(4, 11, "15-02-1858", false);
			this.dieNote[13] = new Note(4, 12, "16-03-1858", true);
			this.dieNote[14] = new Note(4, 11, "19-06-1858", true);
		}
	}

	public int getFachID(String fach) {
		for(int idF = 0; idF < aAnzFaecher; idF++) {
			if(dasFach[idF].getName().equals(fach)) {
				return dasFach[idF].getFachID();
			}
		}
		return 0;
	}
	
	private String fachIDtoName(int fID) {
		for(int i  = 0; i < aAnzFaecher; i++) {
			if(dasFach[i].getFachID() == fID) {
				return dasFach[i].getName();
			}
		}
		return null;
	}
	
	public String[] getNotenListe() {
		String[] arr = new String[aAnzNoten];
		for(int i = 0; i < aAnzNoten; i++) {
			String boolWert = "";
			if(dieNote[i].getIstSchriftlich()) {
				boolWert = "Schriftlich";
			}
			else {
				boolWert = "Mündlich";
			}
			String line = Integer.toString(dieNote[i].getPunkte()) + " "  + dieNote[i].getDatum() + " " + boolWert + " " + fachIDtoName(dieNote[i].getFachID()) ;
			arr[i] = line;
		}
		return arr;
	}
	
	public void deleteNote(int id) {
		if(aAnzNoten == 0) {
			return;
		}
		else {
			dieNote[id] = dieNote[dieNote.length - 1];
			
			Note[] arr = new Note[dieNote.length - 1];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = dieNote[i];
			}
			dieNote = new Note[arr.length];
			for(int i = 0; i < arr.length; i++) {
				dieNote[i] = arr[i];
			}
			aAnzNoten--;
		}
		for(int i = 0; i < dieNote.length; i++) {
			System.out.println(dieNote[i].getPunkte());
		}
	}
	
	public String[] getFehlzeitenListe() {
		String[] arr = new String[aAnzAnwesenheit];
		for(int i = 0; i < aAnzAnwesenheit; i++) {
			String line = dieAnwesenheit[i].getDatum() + " "  + Integer.toString(dieAnwesenheit[i].getStunde()) + " " + Integer.toString(dieAnwesenheit[i].getFehlzeitInMinuten()) + " " + fachIDtoName(dieAnwesenheit[i].getFachID());
			arr[i] = line;
		}
		return arr;
	}
	
	public void deleteFehlzeit(int id) {
		if(aAnzAnwesenheit == 0) {
			return;
		}
		else {
			dieAnwesenheit[id] = dieAnwesenheit[dieAnwesenheit.length - 1];
			
			Anwesenheit[] arr = new Anwesenheit[dieAnwesenheit.length - 1];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = dieAnwesenheit[i];
			}
			dieAnwesenheit = new Anwesenheit[arr.length];
			for(int i = 0; i < arr.length; i++) {
				dieAnwesenheit[i] = arr[i];
			}
			aAnzAnwesenheit--;
		}
	}

	public void setFehlzeit(String datum , String Zustand, int fach, int fehlzeitInMinuten, int stunde) {
		aAnzAnwesenheit = aAnzAnwesenheit+1;
		Anwesenheit[] saveAnwesenheit = dieAnwesenheit;
		dieAnwesenheit = new Anwesenheit[aAnzAnwesenheit];
		for(int i = 0; i < aAnzAnwesenheit; i++) {
			if(i == saveAnwesenheit.length) {
				dieAnwesenheit[i] = new Anwesenheit(fach, datum, stunde, fehlzeitInMinuten, Zustand);
				return;
			}
			else {
				dieAnwesenheit[i] = saveAnwesenheit[i];
			}
		}
	}
	
	private boolean checkMuendlicheNotenAnzahl(int fID) {
		int anzahlM = 0;
		for(int i = 0; i < aAnzNoten; i++) {
			if(dieNote[i].getFachID() == fID) {
				if(!dieNote[i].getIstSchriftlich()) {
					anzahlM++;
				}
			}
		}
		if(anzahlM > 5) {
			return false;
		}
		return true;
	}
	
	private boolean checkSchriftlicheNotenAnzahl(int fID) {
		int anzahlS = 0;
		for(int i = 0; i < aAnzNoten; i++) {
			if(dieNote[i].getFachID() == fID) {
				if(dieNote[i].getIstSchriftlich()) {
					anzahlS++;
				}
			}
		}
		if(anzahlS > 5) {
			return false;
		}
		return true;
	}
	
	public void setNote(int fID, int punkte, String datum, boolean schriftlich) {
		if(schriftlich) {
			if(!checkSchriftlicheNotenAnzahl(fID)) {
				return;
			}
			else {
				aAnzNoten = aAnzNoten+1;
				Note[] saveNoten = dieNote;
				dieNote = new Note[aAnzNoten];
				for(int i = 0; i < aAnzNoten; i++) {
					if(i == saveNoten.length) {
						dieNote[i] = new Note(fID, punkte, datum, schriftlich);
						return;
					}
					else {
						dieNote[i] = saveNoten[i];
					}
				}
			}
		}
		else {
			if(!checkMuendlicheNotenAnzahl(fID)) {
				return;
			}
			else {
				aAnzNoten = aAnzNoten+1;
				Note[] saveNoten = dieNote;
				dieNote = new Note[aAnzNoten];
				for(int i = 0; i < aAnzNoten; i++) {
					if(i == saveNoten.length) {
						dieNote[i] = new Note(fID, punkte, datum, schriftlich);
						return;
					}
					else {
						dieNote[i] = saveNoten[i];
					}
				}
			}
		}
		
	}
	
	public String[] getFaecher() {
		String[] faecher = new String[aAnzFaecher];
		for(int idF=0; idF < aAnzFaecher; idF++) {
			String fach = dasFach[idF].getName();
			faecher[idF] = fach;
		}
		return faecher;
	}

	public String getName() {
		return aName;
	}

	//Schaltjahrkontrolle
	private boolean checkIfLeapYear(int Jahr) {
		if(Jahr % 4 == 0 && Jahr % 100 != 0 || Jahr % 400 == 0) {
			return true;
		}
		return false;
	}

	//kontrolliert ob der Monat 31 Tage hat oder nicht
	private boolean isBigMonth(int month) {
		char[] bigMonths = {1, 3, 5, 7, 8, 10, 12};
		for(int i=0; i < bigMonths.length;i++) {
			if(bigMonths[i] == month) {
				return true;
			}
		}
		return false;
	}

	//Gültigkeit des Datums
	private boolean checkValidityOfDates(int vTag, int vMonat, int vJahr, int bTag, int bMonat, int bJahr) {
		String vonStatus = "invalid";
		String bisStatus = "invalid";

		if( vTag <= 31 && vTag > 0 && vMonat <= 12 && vMonat > 0 ) {
			vonStatus = "valid";
			if((vTag == 31 && !isBigMonth(vMonat))) {
				vonStatus = "invalid";
			}
			else if(vTag == 29 && vMonat == 2 && !checkIfLeapYear(vJahr)) {
				vonStatus = "invalid";
			}
		}

		if( bTag <= 31 && bTag > 0 && bMonat <= 12 && bMonat > 0 ) {
			bisStatus = "valid";
			if((bTag == 31 && !isBigMonth(bMonat))) {
				bisStatus = "invalid";
			}
			else if(bTag == 29 && bMonat == 2 && !checkIfLeapYear(bJahr)) {
				bisStatus = "invalid";
			}
		}

		if(vonStatus.equals("valid") && bisStatus.equals("valid")) {
			if( (vTag <= bTag && vMonat == bMonat && vJahr == bJahr) || (vMonat < bMonat && vJahr == bJahr) || (vJahr < bJahr)) {
				return true;
			}
		}
		return false;
	}

	public String[][] berechnenFehlzeiten(String pVon, String pBis) {

		ArrayList<String[]> fehlzeitenListe = new ArrayList<String[]>();
		
		String[][] arr = new String[0][0]; 
		char[] vonDatumInChar = pVon.toCharArray();
		char[] bisDatumInChar = pBis.toCharArray();
		int[] datenVon = new int[3];
		int[] datenBis = new int[3];
		
		datenVon[0] = Integer.parseInt(Character.toString(vonDatumInChar[0]) + Character.toString(vonDatumInChar[1]));
		datenVon[1] = Integer.parseInt(Character.toString(vonDatumInChar[2]) + Character.toString(vonDatumInChar[3]));
		datenVon[2] = Integer.parseInt(Character.toString(vonDatumInChar[4]) + Character.toString(vonDatumInChar[5]) + Character.toString(vonDatumInChar[6]) + Character.toString(vonDatumInChar[7]));
		datenBis[0] = Integer.parseInt(Character.toString(bisDatumInChar[0]) + Character.toString(bisDatumInChar[1]));
		datenBis[1] = Integer.parseInt(Character.toString(bisDatumInChar[2]) + Character.toString(bisDatumInChar[3]));
		datenBis[2] = Integer.parseInt(Character.toString(bisDatumInChar[4]) + Character.toString(bisDatumInChar[5]) + Character.toString(bisDatumInChar[6]) + Character.toString(bisDatumInChar[7]));

		if(!checkValidityOfDates(datenVon[0], datenVon[1], datenVon[2], datenBis[0], datenBis[1], datenBis[2])) {
			return arr;
		}
		else {
			for( int idA = 0; idA < aAnzAnwesenheit; idA++) {
				String datum = dieAnwesenheit[idA].getDatum();
				
				char[] fehlzeitDatumInChar = datum.toCharArray();
				int[] datenFehlzeit = new int[3];
				
				datenFehlzeit[0] = Integer.parseInt(Character.toString(fehlzeitDatumInChar[0]) + Character.toString(fehlzeitDatumInChar[1]));
				datenFehlzeit[1] = Integer.parseInt(Character.toString(fehlzeitDatumInChar[3]) + Character.toString(fehlzeitDatumInChar[4]));
				datenFehlzeit[2] = Integer.parseInt(Character.toString(fehlzeitDatumInChar[6]) + Character.toString(fehlzeitDatumInChar[7]) + Character.toString(fehlzeitDatumInChar[8]) + Character.toString(fehlzeitDatumInChar[9]));
				
				if((datenVon[0] <= datenFehlzeit[0] && datenVon[1] == datenFehlzeit[1] && datenVon[2] == datenFehlzeit[2]) || (datenVon[1] < datenFehlzeit[1] && datenVon[2] == datenFehlzeit[2]) || (datenVon[2] < datenFehlzeit[2])) {
					if((datenBis[0] >= datenFehlzeit[0] && datenBis[1] == datenFehlzeit[1] && datenBis[2] == datenFehlzeit[2]) || (datenBis[1] > datenFehlzeit[1] && datenBis[2] == datenFehlzeit[2]) || (datenBis[2] > datenFehlzeit[2])) {
						String[] data = {dieAnwesenheit[idA].getDatum(), Integer.toString(dieAnwesenheit[idA].getFehlzeitInMinuten()), fachIDtoName(dieAnwesenheit[idA].getFachID())};
						fehlzeitenListe.add(data);
					}
				}
			}
			String[][] array = new String[fehlzeitenListe.size()][];
			for(int i = 0; i < fehlzeitenListe.size(); i++) {
				String[] row = fehlzeitenListe.get(i);
				array[i] = row;
			}
		return array;
		}
	}

	public float berechnenDurchschnittMuendlich(String pFach) {
		int summe = 0;
		int anzahlNoten = 0;
		int fID = 0;
		float durchschnitt;
		boolean gefunden = false;
		while((fID < aAnzFaecher) && (gefunden == false)) {
			if(dasFach[fID].getName() == pFach) {
				gefunden = true;
			}
			else {
				fID++;
			}
		}
		if(gefunden) {
			for(int i = 0; i < aAnzNoten;i++) {
				if((fID == dieNote[i].getFachID())&&(dieNote[i].getIstSchriftlich() == false)) {
					summe = summe + dieNote[i].getPunkte();
					anzahlNoten++;
				}
			}
			if(anzahlNoten == 0) {
				durchschnitt = 0.0f;
			}
			else {
				durchschnitt = (float) summe / (float) anzahlNoten;
			}
		}
		else {
			durchschnitt = 0.0f;
		}
		return durchschnitt;
	}

	public double berechnenDurchschnittSchriftlich(String pFach) {
		int summe = 0;
		int anzahlNoten = 0;
		int fID = 0;
		float durchschnitt;
		boolean gefunden = false;
		while((fID < aAnzFaecher) && (gefunden == false)) {
			if(dasFach[fID].getName() == pFach) {
				gefunden = true;
			}
			else {
				fID++;
			}
		}
		if(gefunden) {
			for(int i = 0; i < aAnzNoten;i++) {
				if((fID == dieNote[i].getFachID())&&(dieNote[i].getIstSchriftlich() == true)) {
					summe = summe + dieNote[i].getPunkte();
					anzahlNoten++;
				}
			}
			if(anzahlNoten == 0) {
				durchschnitt = 0.0f;
			}
			else {
				durchschnitt = (float) summe / (float) anzahlNoten;
			}
		}
		else {
			durchschnitt = 0.0f;
		}
		return durchschnitt;
	}

	public void setAnwesenheit(String schueler, int minuten, int stunde, String[] datum, String zustand) {
		aAnzAnwesenheit++;
		Anwesenheit[] saveAnwesenheit = dieAnwesenheit;
		dieAnwesenheit = new Anwesenheit[aAnzAnwesenheit];
		for(int i = 0; i < aAnzAnwesenheit; i++) {
			if(i == saveAnwesenheit.length) {
				dieAnwesenheit[i] = new Anwesenheit(3, datum[0]+datum[1]+datum[2], stunde, minuten, zustand);
			}
			else {
				dieAnwesenheit[i] = saveAnwesenheit[i];
			}
		}
	}
	
	public String[][] getMNoten(String pFach) {

		ArrayList<String[]> NotenListe = new ArrayList<String[]>();
		for(int idF = 0; idF < aAnzFaecher;idF++) {
			if(pFach == dasFach[idF].getName()) {
				for(int idN = 0; idN < aAnzNoten; idN++) {
					if(dieNote[idN].getFachID() == dasFach[idF].getFachID() && !dieNote[idN].getIstSchriftlich()) {
						String[] data = {dieNote[idN].getDatum(), Integer.toString(dieNote[idN].getPunkte())};
						NotenListe.add(data);
					}
				}
			}
		}

		String[][] array = new String[NotenListe.size()][];
		for(int i = 0; i < NotenListe.size(); i++) {
			String[] row = NotenListe.get(i);
			array[i] = row;
		}
		return array;

	}

	public String[][] getSNoten(String pFach) {
		ArrayList<String[]> NotenListe = new ArrayList<String[]>();
		for(int idF = 0; idF < aAnzFaecher;idF++) {
			if(pFach == dasFach[idF].getName()) {
				for(int idN = 0; idN < aAnzNoten; idN++) {
					
					if(dieNote[idN].getFachID() == dasFach[idF].getFachID() && dieNote[idN].getIstSchriftlich()) {
						String[] data = {dieNote[idN].getDatum(), Integer.toString(dieNote[idN].getPunkte())};
						NotenListe.add(data);
					}
				}
			}
		}
		String[][] array = new String[NotenListe.size()][];
		for(int i = 0; i < NotenListe.size(); i++) {
			String[] row = NotenListe.get(i);
			array[i] = row;
		}
		return array;
	}
}
