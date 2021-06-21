
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{

	private JPanel contentPane = new JPanel();
	private Steuerung dieSteuerung;
	private JLabel Title;
	private JComboBox<String> faecherListe;
	private ActionListener comboBoxListener;
	private JLabel schuelerLbl;
	private String aktuelleSeite = "Log-In";
	private JButton backButton;
	private String schueler;
	private String vonDatum;
	private String bisDatum;
	
	

	// ----- ANMELDE FENSTER -----
	private JLabel logInNameLbl;
	private JLabel logInPinLbl;
	private JTextField logInNameFeld;
	private JTextField logInPinFeld;
	private JButton logInButton;

	// ------ HAUPTMENUE ------
	private JButton muendlicheNotenBtn;
	private JButton schriftlicheNotenBtn;
	private JButton fehlzeitenBtn;

	// ------- Mündliche Noten -------
	private JButton zeigeMuendlicheNotenBtn;
	private JButton durchschnittMuendlicheNotenBtn;
	private JLabel muendlicheNotenSchnittLbl;
	private JTable muendlicheNotenTabelle;
	private String[] headerMuendlicheNoten = {"Datum", "Note"};

	// --------- Schriftliche Noten ---------
	private JButton zeigeSchriftlicheNotenBtn;
	private JButton durchschnittSchriftlicheNotenBtn;
	private JLabel schriftlicheNotenSchnittLbl;
	private JTable schriftlicheNotenTabelle;
	private String[] headerSchriftlicheNoten = {"Datum", "Note"};

	// --------- Fehlzeiten --------------
	private JButton zeigeFehlzeitenBtn;
	private JLabel fehlzeitenLbl;
	private JTable fehlzeitenTabelle;
	private JScrollPane scroll;
	private JTextField[] vonDatumFeld = {new JTextField(), new JTextField(), new JTextField()};
	private JTextField[] bisDatumFeld = {new JTextField(), new JTextField(), new JTextField()};
	private String[] headerFehlzeiten = {"Datum", "Fehlzeit In Minuten", "Fach"};
	private JLabel vonLbl;
	private JLabel bisLbl;
	private JLabel DatumLbl;

	// ---------Lehrer-Menue-----------
	private JComboBox<String> schuelerListe; //Liste mit allen Schülern
	private JButton addNoteBtn;
	private String ausgewaehlterSchueler;
	private JButton deleteNoteBtn;
	private JButton addFehlzeitBtn;
	private JButton deleteFehlzeitBtn;
		
	//-------------deleteNoteBtn---------
	private JComboBox<String> notenListe;
	private JButton deleteBtn;

		//----------Add-Note-----------
	private JLabel ausgewaehlterSchuelerLbl;
	private JLabel notenPunkteLbl;
	private JTextField notenPunkteFeld;
	private JTextField[] notenDatumFeld = {new JTextField(), new JTextField(), new JTextField()};
	private JLabel notenDatumLbl;
	private JCheckBox istSchriftlichCheckBox;
	private JButton machNoteRein;
	
	//----------addFehlzeit----------------
	private JButton addFZBtn;
	private JTextField[] fzDatum = {new JTextField(), new JTextField(), new JTextField()};
	private JLabel datumFZ;
	private JTextField stundeFeld;
	private JLabel stundeLbl;
	private JTextField fzMinutenFeld;
	private JLabel fzMinutenLbl;
	private JTextField fzZustandFeld;
	private JLabel fzZustandLbl;
	private JTextField fzFachFeld;
	private JLabel fzFachLbl;
	
	//-----------deleteFehlzeit
	private JButton deleteFZBtn;
	private JComboBox<String> fzListe;
	
	public GUI(Steuerung ctrl) {
		super("Noten & Fehlzeiten Programm");

		this.setTitle("Noten & Fehlzeiten Programm");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.dieSteuerung = ctrl;

		initComponents();
		initListener();
		zeigeLogIn();
		reloadFrame();
	}

	private void initComponents() {

		String[][] a = new String[0][0];
		String[] b = new String[0];
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Title = new JLabel("Anmelde-Formular");
		Title.setFont(new Font(("Times New Roman"), Font.PLAIN, 18));
		Title.setBounds(177, 35, 200, 14);

		logInNameLbl = new JLabel("Name");
		logInNameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		logInNameLbl.setBounds(136, 74, 46, 14);

		logInPinLbl = new JLabel("PIN");
		logInPinLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		logInPinLbl.setBounds(148, 116, 26, 14);

		logInNameFeld = new JTextField();
		logInNameFeld.setBounds(177, 72, 164, 20);

		logInPinFeld = new JTextField();
		logInPinFeld.setBounds(177, 114, 68, 20);

		logInButton = new JButton("Anmelden");
		logInButton.setBounds(165, 147, 100, 23);

		muendlicheNotenBtn = new JButton("Mündliche Noten");
		muendlicheNotenBtn.setBounds(140, 80, 150, 23);

		schriftlicheNotenBtn = new JButton("Schriftliche Noten");
		schriftlicheNotenBtn.setBounds(140, 110, 150,23);

		fehlzeitenBtn = new JButton("Fehlzeiten");
		fehlzeitenBtn.setBounds(140, 140, 150,23);

		fehlzeitenLbl = new JLabel();
		fehlzeitenLbl.setBounds(220, 200, 400, 20);

		zeigeMuendlicheNotenBtn = new JButton("Mündliche Noten anzeigen");
		zeigeMuendlicheNotenBtn.setBounds(200, 50, 200, 23);

		durchschnittMuendlicheNotenBtn = new JButton("Durchschnitt mündliche Noten");
		durchschnittMuendlicheNotenBtn.setBounds(20, 200, 215, 23);

		muendlicheNotenSchnittLbl = new JLabel();
		muendlicheNotenSchnittLbl.setBounds(280, 200, 89, 23);

		zeigeSchriftlicheNotenBtn = new JButton("Schriftliche Noten anzeigen");
		zeigeSchriftlicheNotenBtn.setBounds(200, 50, 200, 23);

		durchschnittSchriftlicheNotenBtn = new JButton("Durchschnitt Schriftliche Noten");
		durchschnittSchriftlicheNotenBtn.setBounds(20, 200, 215, 23);

		schriftlicheNotenSchnittLbl = new JLabel();
		schriftlicheNotenSchnittLbl.setBounds(280, 200, 89, 23);
		
		fehlzeitenTabelle = new JTable(a, b);
		muendlicheNotenTabelle = new JTable(a, b);
		schriftlicheNotenTabelle = new JTable(a, b);
		
		addFZBtn = new JButton("Adde Fehlzeit");
		addFZBtn.setBounds(140, 200, 150,23);
		
		datumFZ = new JLabel("Datum");
		datumFZ.setBounds(115, 120, 80, 20);
		
		fzDatum[0].setBounds(200, 120, 40, 20);
		fzDatum[1].setBounds(250, 120, 40, 20);
		fzDatum[2].setBounds(300, 120, 40, 20);
		
		stundeLbl = new JLabel("Stunde");
		stundeLbl.setBounds(115, 94, 80, 20);
		
		stundeFeld = new JTextField();
		stundeFeld.setBounds(200, 94, 40, 20);
		
		fzMinutenLbl = new JLabel("Minuten");
		fzMinutenLbl.setBounds(115, 144, 80, 20);
		
		fzMinutenFeld = new JTextField();
		fzMinutenFeld.setBounds(200, 144, 80, 20);
		
		fzZustandLbl = new JLabel("Zustand");
		fzZustandLbl.setBounds(115, 168, 80, 20);
		
		fzZustandFeld = new JTextField();
		fzZustandFeld.setBounds(200, 168, 80, 20); 
		
		fzFachFeld = new JTextField();
		fzFachFeld.setBounds(0,0,80, 20);
		
		fzFachLbl = new JLabel("Fach");
		fzFachLbl.setBounds(0,0,80, 20);
		
		addFehlzeitBtn = new JButton("Add Fehlzeit");
		addFehlzeitBtn.setBounds(140, 170, 150,23);
		
		deleteFehlzeitBtn = new  JButton("Delete Fehlzeit");
		deleteFehlzeitBtn.setBounds(140, 200, 150,23);
		
		deleteNoteBtn = new JButton("Delete Note");
		deleteNoteBtn.setBounds(140, 140, 150,23);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(140, 200, 150,23);
		
		schuelerLbl = new JLabel(schueler);
		schuelerLbl.setBounds(0,0,0,0);

		zeigeFehlzeitenBtn = new JButton("Fehlzeiten anzeigen");
		zeigeFehlzeitenBtn.setBounds(200, 50, 200, 23);

		backButton = new JButton("Ausloggen");
		backButton.setBounds(280, 230, 150, 23);
		
		deleteFZBtn = new JButton("Löschen");
		deleteFZBtn.setBounds(140, 200, 150,23);

		vonDatumFeld[0].setBounds(40, 120, 50, 20);
		vonDatumFeld[1].setBounds(100, 120, 50, 20);
		vonDatumFeld[2].setBounds(160, 120, 50, 20);

		bisDatumFeld[0].setBounds( 40, 180,50,20);
		bisDatumFeld[1].setBounds(100, 180, 50, 20);
		bisDatumFeld[2].setBounds(160, 180, 50, 20);

		vonLbl = new JLabel("Von");
		vonLbl.setBounds(10, 120, 50, 20);

		bisLbl = new JLabel("Bis");
		bisLbl.setBounds(10, 180, 50, 20);

		DatumLbl = new JLabel("Tag              Monat        Jahr");
		DatumLbl.setBounds(40, 150, 200, 20);

		addNoteBtn = new JButton("Füge Note hinzu");
		addNoteBtn.setBounds(140, 110, 150,23);

		ausgewaehlterSchuelerLbl = new JLabel();
		ausgewaehlterSchuelerLbl.setBounds(0, 0, 0, 0);

		notenPunkteLbl = new JLabel("Notenpunkte");
		notenPunkteLbl.setBounds(115, 116, 80, 20);

		notenPunkteFeld = new JTextField();
		notenPunkteFeld.setBounds(200, 116, 40, 20);

		notenDatumLbl = new JLabel("Datum");
		notenDatumLbl.setBounds(115, 140, 80, 20);

		notenDatumFeld[0].setBounds(200, 140, 40, 20);
		notenDatumFeld[1].setBounds(250, 140, 40, 20);
		notenDatumFeld[2].setBounds(300, 140, 40, 20);

		istSchriftlichCheckBox = new JCheckBox("Schriftlich", false);
		istSchriftlichCheckBox.setBounds(200, 160, 100, 20);
		
		machNoteRein = new JButton("Note adden");
		machNoteRein.setBounds(140, 200, 150,23);
	}

	private void initListener() {
		comboBoxListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(aktuelleSeite == "Muendlich") {
					contentPane.remove(muendlicheNotenSchnittLbl);
					contentPane.remove(muendlicheNotenTabelle);
				}
				else if(aktuelleSeite == "Schriftlich") {
					contentPane.remove(schriftlicheNotenSchnittLbl);
					contentPane.remove(schriftlicheNotenTabelle);
				}
				reloadFrame();
			}
		};

		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();

				if(btn == logInButton) {
					if(!logInNameFeld.getText().isEmpty() && !logInPinFeld.getText().isEmpty()) {
						clickLogInBtn(logInNameFeld.getText().trim(), logInPinFeld.getText().trim());
					}
				}
				else if(btn == schriftlicheNotenBtn) {
					schließeEingeloggt();
					zeigeSchriftlicheNotenSeite();
				}
				else if(btn == fehlzeitenBtn) {
					schließeEingeloggt();
					zeigeFehlzeitenSeite();
				}
				else if(btn == muendlicheNotenBtn) {
					schließeEingeloggt();
					zeigeMuendlicheNotenSeite();
				}
				else if(btn == zeigeMuendlicheNotenBtn) {
					clickMNoten(faecherListe.getSelectedItem().toString(), schueler);
				}
				else if(btn == zeigeSchriftlicheNotenBtn) {
					clickSNoten(faecherListe.getSelectedItem().toString(), schueler);
				}
				else if(btn == zeigeFehlzeitenBtn) {
					if(vonDatumFeld[0].getText().equals("") || vonDatumFeld[1].getText().equals("") ||vonDatumFeld[2].getText().equals("") || bisDatumFeld[0].getText().equals("") || bisDatumFeld[1].getText().equals("") || bisDatumFeld[2].getText().equals("")) {
						return;
					}
					else {
						String vT = checkDatumInput(vonDatumFeld[0].getText());
						String vM = checkDatumInput(vonDatumFeld[1].getText());
						String vJ = checkDatumInput(vonDatumFeld[2].getText());
						String bT = checkDatumInput(bisDatumFeld[0].getText());
						String bM = checkDatumInput(bisDatumFeld[1].getText());
						String bJ = checkDatumInput(bisDatumFeld[2].getText());
						if( vT == null|| vM == null || vJ == null || bT == null || bM == null || bJ == null) {
							contentPane.remove(fehlzeitenLbl);
							return;
						}
						else {
							vonDatum = vT + vM + vJ;
							bisDatum = bT + bM + bJ;
							clickFehlzeiten(vonDatum, bisDatum, schueler);
						}
					}
				}
				else if(btn == backButton) {
					switch(aktuelleSeite) {
					case "Log-In":
						break;
					case "Hauptmenue":
						aktuelleSeite = "Log-In";
						contentPane.remove(backButton);
						schließeEingeloggt();
						Title.setFont(new Font(("Times New Roman"), Font.PLAIN, 18));
						Title.setBounds(177, 35, 134, 14);
						contentPane.add(logInButton);
						zeigeLogIn();
						reloadFrame();
						break;
					case "Fehlzeiten":
						aktuelleSeite = "Hauptmenue";
						schließeFehlzeitenSeite();
						zeigeEingeloggt();
						reloadFrame();
						break;
					case "Muendlich":
						aktuelleSeite = "Hauptmenue";
						schließeMuendlicheNotenSeite();
						zeigeEingeloggt();
						reloadFrame();
						break;
					case "Schriftlich":
						aktuelleSeite = "Hauptmenue";
						schließeSchriftlicheNotenSeite();
						zeigeEingeloggt();
						reloadFrame();
						break;
					case "Lehrer":
						aktuelleSeite = "Log-In";
						schließeLehrerMenue();
						zeigeLogIn();
						reloadFrame();
						break;
					case "AddNote":
						aktuelleSeite = "Lehrer";
						schließeAddNote();
						zeigeLehrerMenue();
						reloadFrame();
						break;
					case "DeleteNote":
						aktuelleSeite = "Lehrer";
						schließeDeleteNoten();
						zeigeLehrerMenue();
						reloadFrame();
						break;
					case "AddFehlzeit":
						aktuelleSeite = "Lehrer";
						schließeAddFehlzeit();
						zeigeLehrerMenue();
						reloadFrame();
						break;
					case "DeleteFehlzeit":
						aktuelleSeite = "Lehrer";
						schließeDeleteFehlzeit();
						zeigeLehrerMenue();
						reloadFrame();
						break;
					}
				}
				else if(btn == durchschnittMuendlicheNotenBtn) {
					clickMNotenSchnitt(faecherListe.getSelectedItem().toString(), schueler);
				}
				else if(btn == durchschnittSchriftlicheNotenBtn) {
					clickSNotenSchnitt(faecherListe.getSelectedItem().toString(), schueler);
				}
				else if(btn == addNoteBtn) {
					ausgewaehlterSchueler = schuelerListe.getSelectedItem().toString();
					faecherListe = new JComboBox<String>(dieSteuerung.getFaecherListe(ausgewaehlterSchueler));
					faecherListe.setBounds(116, 80, 150, 25);
					faecherListe.addActionListener(comboBoxListener);
					clickAddNote();
				}
				else if(btn == machNoteRein) {
					
					clickNoteHinzufuegen();
				}
				else if(btn == deleteNoteBtn) {
					ausgewaehlterSchueler = schuelerListe.getSelectedItem().toString();
					schließeLehrerMenue();
					zeigeDeleteNoten();
					reloadFrame();
				}
				else if(btn == deleteBtn) {
					clickDeleteNote();
				}
				else if(btn == addFZBtn) {
					clickAddFehlzeit();
					reloadFrame();
				}
				else if(btn == addFehlzeitBtn) {
					ausgewaehlterSchueler = schuelerListe.getSelectedItem().toString();
					schließeLehrerMenue();
					zeigeAddFehlzeit();
					reloadFrame();
				}
				else if(btn == deleteFehlzeitBtn) {
					ausgewaehlterSchueler = schuelerListe.getSelectedItem().toString();
					schließeLehrerMenue();
					zeigeDeleteFehlzeit();
					reloadFrame();
				}
				else if(btn == deleteFZBtn) {
					schließeDeleteFehlzeit();
					zeigeLehrerMenue();
					clickDeleteFehlzeit();
					reloadFrame();
				}
				reloadFrame();
			}
		};

		KeyAdapter KeyListener = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField tf = (JTextField) e.getSource();
				int border = 0;
				if(tf == vonDatumFeld[0] || tf == vonDatumFeld[1] || tf == bisDatumFeld[0] || tf == bisDatumFeld[1] || tf == notenPunkteFeld || tf == notenDatumFeld[0] || tf == notenDatumFeld[1]) {
					border = 2;
				}
				else if(tf == vonDatumFeld[2] || tf == bisDatumFeld[2]|| tf == notenDatumFeld[2]) {
					border = 4;
				}
				else if(tf == logInPinFeld) {
					border = 8;
				}

				if(tf.getText().length() >= border) {
					e.consume();
				}
			}
		};

		logInButton.addActionListener(actionListener);
		schriftlicheNotenBtn.addActionListener(actionListener);
		fehlzeitenBtn.addActionListener(actionListener);
		muendlicheNotenBtn.addActionListener(actionListener);
		zeigeFehlzeitenBtn.addActionListener(actionListener);
		zeigeMuendlicheNotenBtn.addActionListener(actionListener);
		zeigeSchriftlicheNotenBtn.addActionListener(actionListener);
		backButton.addActionListener(actionListener);
		durchschnittMuendlicheNotenBtn.addActionListener(actionListener);
		durchschnittSchriftlicheNotenBtn.addActionListener(actionListener);
		addNoteBtn.addActionListener(actionListener);
		notenPunkteFeld.addKeyListener(KeyListener);
		machNoteRein.addActionListener(actionListener);
		deleteNoteBtn.addActionListener(actionListener);
		deleteBtn.addActionListener(actionListener);
		addFehlzeitBtn.addActionListener(actionListener);
		deleteFehlzeitBtn.addActionListener(actionListener);
		deleteFZBtn.addActionListener(actionListener);
		addFZBtn.addActionListener(actionListener);
		

		for(int i = 0; i < 3; i++) {
			vonDatumFeld[i].addKeyListener(KeyListener);
			bisDatumFeld[i].addKeyListener(KeyListener);
			notenDatumFeld[i].addKeyListener(KeyListener);
		}
		logInPinFeld.addKeyListener(KeyListener);
	}

	private void zeigeLehrerMenue() {
		aktuelleSeite = "Lehrer";
		schuelerListe = new JComboBox<String>(dieSteuerung.getSchuelerListe());
		schuelerListe.setBounds(140, 70, 150, 25);

		Title.setText("LEHRER");
		contentPane.add(schuelerListe);
		contentPane.add(addNoteBtn);
		backButton.setText("Ausloggen");
		contentPane.add(deleteNoteBtn);
		contentPane.add(backButton);
		contentPane.add(addFehlzeitBtn);
		contentPane.add(deleteFehlzeitBtn);
	}

	private void schließeLehrerMenue() {
		contentPane.remove(schuelerListe);
		contentPane.remove(addNoteBtn);
		contentPane.remove(deleteNoteBtn);
		contentPane.remove(addFehlzeitBtn);
		contentPane.remove(deleteFehlzeitBtn);
	}

	private void zeigeAddNote() {
		aktuelleSeite = "AddNote";
		Title.setText("Schüler: " + ausgewaehlterSchueler);
		
		contentPane.add(ausgewaehlterSchuelerLbl);
		contentPane.add(notenPunkteLbl);
		contentPane.add(notenPunkteFeld);
		for(int i = 0; i < 3; i++) {
			contentPane.add(notenDatumFeld[i]);
		}
		contentPane.add(machNoteRein);
		faecherListe = new JComboBox<String>(dieSteuerung.getFaecherListe(ausgewaehlterSchueler));
		faecherListe.setBounds(116, 80, 150, 25);
		contentPane.add(faecherListe);
		contentPane.add(notenDatumLbl);
		contentPane.add(istSchriftlichCheckBox);
		backButton.setText("Zurück");
		contentPane.add(backButton);
		
	}

	private void schließeAddNote() {
		contentPane.remove(ausgewaehlterSchuelerLbl);
		contentPane.remove(notenPunkteLbl);
		contentPane.remove(notenPunkteFeld);
		for(int i = 0; i < 3; i++) {
			contentPane.remove(notenDatumFeld[i]);
		}
		contentPane.remove(faecherListe);
		contentPane.remove(notenDatumLbl);
		contentPane.remove(istSchriftlichCheckBox);
		contentPane.remove(machNoteRein);
	}

	private String checkDatumInput(String datum) {
		if(datum.length() == 2 || datum.length() == 4) {
			char[] datumArray = datum.toCharArray();
			int letter = 0;
			for(int i = 0; i < datumArray.length; i++) {
				if(!Character.isDigit(datumArray[i])) {
					letter++;
				}
			}
			if(letter == 0) {
				return datum;
			}
			return null;
		}
		else if(datum.length() == 1) {
			char[] datumArray = datum.toCharArray();
			int letter = 0;
			for(int i = 0; i < datumArray.length; i++) {
				if(!Character.isDigit(datumArray[i])) {
					letter++;
				}
			}
			if(letter == 0) {
				return "0" + datum;
			}
			return null;
		}
		else {
			return null;
		}
	}

	private void reloadFrame() {
		contentPane.revalidate();
		contentPane.repaint();
	}

	private void zeigeLogIn() {

		contentPane.add(Title);
		contentPane.add(logInNameLbl);
		contentPane.add(logInPinLbl);
		contentPane.add(logInNameFeld);
		contentPane.add(logInButton);
		logInNameFeld.setText("");
		contentPane.add(logInPinFeld);
		logInPinFeld.setText("");
		Title.setText("ANMELDUNG");

	}

	private boolean checkIfValidInput(String name, String pin) {
		char[] nameInChar = name.toCharArray();
		char[] pinInChar = pin.toCharArray();
		int nums = 0;
		int letters = 0;
		for(int i = 0; i < nameInChar.length;i++) {
			if(Character.isDigit(nameInChar[i])) {nums++;}
		}
		for(int i = 0; i < pinInChar.length;i++) {
			if(!Character.isDigit(pinInChar[i])) {letters++;}
		}
		if(nums != 0 || letters != 0) {
			return false;
		}
		return true;
	}

	private void clickLogInBtn(String name, String pin) {
		if(!checkIfValidInput(name, pin)){
			return;
		}
		if(dieSteuerung.pruefeLogIn(name, Integer.parseInt(pin))) {
			contentPane.remove(logInButton);
			schließeLogInMenue();
			zeigeEingeloggt();
			reloadFrame();
		}
		else{
			if(name.equals("root") && pin.equals("42")){
				contentPane.remove(logInButton);
				schließeLogInMenue();
				zeigeLehrerMenue();
				reloadFrame();
			}
		}
	}

	private void schließeLogInMenue() {
		contentPane.remove(logInNameLbl);
		contentPane.remove(logInPinLbl);
		contentPane.remove(logInNameFeld);
		contentPane.remove(logInPinFeld);
	}

	private void zeigeEingeloggt() {
		schueler = logInNameFeld.getText();
		faecherListe = new JComboBox<String>(dieSteuerung.getFaecherListe(schueler));
		faecherListe.setBounds(20, 50, 150, 25);
		faecherListe.addActionListener(comboBoxListener);

		Title.setFont(new Font(("Times New Roman"), Font.PLAIN, 15));
		Title.setBounds(140, 35, 300, 14);
		Title.setText("Schueler: " + schueler);

		contentPane.add(muendlicheNotenBtn);
		contentPane.add(schriftlicheNotenBtn);
		contentPane.add(fehlzeitenBtn);
		contentPane.add(backButton);
		backButton.setText("Ausloggen");

		aktuelleSeite = "Hauptmenue";
	}

	private void schließeEingeloggt() {
		contentPane.remove(muendlicheNotenBtn);
		contentPane.remove(schriftlicheNotenBtn);
		contentPane.remove(fehlzeitenBtn);
		contentPane.remove(backButton);

	}

	private void zeigeMuendlicheNotenSeite() {
		Title.setText("Mündliche Noten");


		contentPane.add(faecherListe);
		contentPane.add(zeigeMuendlicheNotenBtn);
		contentPane.add(schuelerLbl);
		contentPane.add(durchschnittMuendlicheNotenBtn);
		contentPane.add(backButton);
		backButton.setText("Zurück");
		aktuelleSeite = "Muendlich";
	}

	private void schließeMuendlicheNotenSeite() {
		contentPane.remove(faecherListe);
		contentPane.remove(zeigeMuendlicheNotenBtn);
		contentPane.remove(schuelerLbl);
		contentPane.remove(durchschnittMuendlicheNotenBtn);
		contentPane.remove(backButton);
		contentPane.remove(muendlicheNotenTabelle);
		contentPane.remove(muendlicheNotenSchnittLbl);
		aktuelleSeite = "Hauptmenue";
	}

	private void zeigeSchriftlicheNotenSeite() {
		Title.setText("Schriftliche Noten");

		contentPane.add(faecherListe);
		contentPane.add(zeigeSchriftlicheNotenBtn);
		contentPane.add(schuelerLbl);
		contentPane.add(durchschnittSchriftlicheNotenBtn);
		contentPane.add(backButton);
		backButton.setText("Zurück");
		aktuelleSeite = "Schriftlich";
	}

	private void schließeSchriftlicheNotenSeite() {
		contentPane.remove(faecherListe);
		contentPane.remove(zeigeSchriftlicheNotenBtn);
		contentPane.remove(schuelerLbl);
		contentPane.remove(durchschnittSchriftlicheNotenBtn);
		contentPane.remove(backButton);
		contentPane.remove(schriftlicheNotenSchnittLbl);
		contentPane.remove(schriftlicheNotenTabelle);
		aktuelleSeite = "Hauptmenue";
	}

	private void zeigeFehlzeitenSeite() {
		Title.setText("Fehlzeiten");
		Title.setBounds(80, 50, 134, 14);
		Title.setFont(new Font(("Times New Roman"), Font.PLAIN, 18));

		contentPane.add(schuelerLbl);
		contentPane.add(zeigeFehlzeitenBtn);
		contentPane.add(backButton);

		for(int i= 0; i < 3;i++) {
			contentPane.add(vonDatumFeld[i]);
			contentPane.add(bisDatumFeld[i]);
		}

		contentPane.add(vonLbl);
		contentPane.add(bisLbl);
		contentPane.add(DatumLbl);

		backButton.setText("Zurück");
		aktuelleSeite = "Fehlzeiten";
	}

	private void schließeFehlzeitenSeite() {
		contentPane.remove(schuelerLbl);
		contentPane.remove(zeigeFehlzeitenBtn);

		for(int i= 0; i < 3;i++) {
			vonDatumFeld[i].setText("");
			bisDatumFeld[i].setText("");
			contentPane.remove(vonDatumFeld[i]);
			contentPane.remove(bisDatumFeld[i]);
		}
		
		contentPane.remove(fehlzeitenTabelle);
		
		contentPane.remove(vonLbl);
		contentPane.remove(bisLbl);
		contentPane.remove(DatumLbl);
		contentPane.remove(fehlzeitenLbl);
		aktuelleSeite = "Hauptmenue";
	}

	private void clickMNoten(String fach, String schueler) {
		dieSteuerung.anzeigenMNoten(fach, schueler);
	}

	private void clickMNotenSchnitt(String fach, String schueler) {
		dieSteuerung.anzeigenMNotenSchnitt(fach, schueler);
	}

	public void anzeigenMNotenSchnitt(double schnitt) {
		muendlicheNotenSchnittLbl.setText(Double.toString(schnitt));
		contentPane.add(muendlicheNotenSchnittLbl);
	}

	public void anzeigenMNoten(String[][] listeMNoten) {
		contentPane.remove(muendlicheNotenTabelle);
		muendlicheNotenTabelle = new JTable(listeMNoten, headerMuendlicheNoten) ;
		int lines = listeMNoten.length;
		muendlicheNotenTabelle.setBounds(50, 100, 200, lines * 16);
		contentPane.add(muendlicheNotenTabelle);
		reloadFrame();
	}

	private void clickSNotenSchnitt(String fach, String schueler) {
		dieSteuerung.anzeigenSNotenSchnitt(fach, schueler);
	}

	private void clickSNoten(String fach, String schueler) {
		dieSteuerung.anzeigenSNoten(fach, schueler);
	}

	public void anzeigenSNoten(String [][] listeSNoten) {
		contentPane.remove(schriftlicheNotenTabelle);
		schriftlicheNotenTabelle = new JTable(listeSNoten, headerSchriftlicheNoten);
		int lines = listeSNoten.length;
		schriftlicheNotenTabelle.setBounds(50, 100, 200, lines * 16);
		contentPane.add(schriftlicheNotenTabelle);
		reloadFrame();

	}

	public void anzeigenSNotenSchnitt(double schnitt) {
		schriftlicheNotenSchnittLbl.setText(Double.toString(schnitt));
		contentPane.add(schriftlicheNotenSchnittLbl);
	}

	private void clickFehlzeiten(String von, String bis, String schueler) {
		dieSteuerung.anzeigenFehlzeiten(von, bis, schueler);
	}

	public void anzeigenFehlzeiten(String[][] listeFehlzeiten) {
		contentPane.remove(fehlzeitenTabelle);
		
		fehlzeitenTabelle = new JTable(listeFehlzeiten, headerFehlzeiten) ;
		int lines = listeFehlzeiten.length;
		fehlzeitenTabelle.setBounds(225, 100, 200, lines * 16);
		contentPane.add(fehlzeitenTabelle);
		int summeFehlzeit = 0;
			
		for(int id = 0; id < listeFehlzeiten.length; id++) {
			summeFehlzeit = summeFehlzeit + Integer.parseInt(listeFehlzeiten[id][1]);
		}
		if(summeFehlzeit == 0) {
			fehlzeitenLbl.setText("KEINE FEHLZEITEN GEFUNDEN");
		}
		else {
			fehlzeitenLbl.setText("Gesamte Fehlzeit in Minuten: " + Integer.toString(summeFehlzeit));
		}
			
		contentPane.add(fehlzeitenLbl);
		
		reloadFrame();
	}

	private void clickAddNote() {
		schließeLehrerMenue();
		zeigeAddNote();
		aktuelleSeite = "AddNote";
	}
	
	private void clickNoteHinzufuegen() {
		
		if(checkIfValidInput("aaa", notenPunkteFeld.getText().trim())) {
			String t = checkDatumInput(notenDatumFeld[0].getText().trim());
			String m = checkDatumInput(notenDatumFeld[1].getText().trim());
			String j = checkDatumInput(notenDatumFeld[2].getText().trim());
			boolean checked = istSchriftlichCheckBox.isSelected();
			dieSteuerung.setNote(ausgewaehlterSchueler, faecherListe.getSelectedItem().toString(), t+"-"+m+"-"+j , Integer.parseInt(notenPunkteFeld.getText().trim()), checked);
			notenDatumFeld[0].setText("");
			notenDatumFeld[1].setText("");
			notenDatumFeld[2].setText("");
			notenPunkteFeld.setText("");
			istSchriftlichCheckBox.setSelected(false);
		}
	}
	
	private void clickDeleteNote() {
		
		dieSteuerung.deleteNote(notenListe.getSelectedIndex(), ausgewaehlterSchueler);
		schließeDeleteNoten();
		zeigeLehrerMenue();
		reloadFrame();
	}
	
	private void zeigeDeleteNoten() {
		aktuelleSeite="DeleteNote";
		notenListe = new JComboBox<String>(dieSteuerung.getNotenListe(ausgewaehlterSchueler));
		notenListe.setBounds(116, 80, 250, 25);
		contentPane.add(notenListe);
		contentPane.add(deleteBtn);
		contentPane.add(backButton);
	}
	
	private void schließeDeleteNoten() {
		contentPane.remove(notenListe);
		contentPane.remove(deleteBtn);
	}
	
	private void zeigeAddFehlzeit() {
		aktuelleSeite = "AddFehlzeit";
		contentPane.add(addFZBtn);
		contentPane.add(datumFZ);
		for(int i = 0; i < 3; i++) {
			contentPane.add(fzDatum[i]);
		}
		contentPane.add(stundeFeld);
		faecherListe = new JComboBox<String>(dieSteuerung.getFaecherListe(ausgewaehlterSchueler));
		faecherListe.setBounds(116, 60, 150, 25);
		contentPane.add(faecherListe);
		contentPane.add(stundeLbl);
		contentPane.add(fzMinutenFeld);
		contentPane.add(fzMinutenLbl);
		contentPane.add(fzZustandLbl);
		contentPane.add(fzZustandFeld);
	}
	
	private void schließeAddFehlzeit() {
		contentPane.remove(addFZBtn);
		contentPane.remove(datumFZ);
		for(int i = 0; i < 3; i++) {
			contentPane.remove(fzDatum[i]);
		}
		contentPane.remove(stundeFeld);
		contentPane.remove(faecherListe);
		contentPane.remove(stundeLbl);
		contentPane.remove(fzMinutenFeld);
		contentPane.remove(fzMinutenLbl);
		contentPane.remove(fzZustandLbl);
		contentPane.remove(fzZustandFeld);
		stundeFeld.setText("");
		fzMinutenFeld.setText("");
		fzZustandFeld.setText("");
		fzDatum[0].setText("");
		fzDatum[1].setText("");
		fzDatum[2].setText("");
	}
	
	private void zeigeDeleteFehlzeit() {
		aktuelleSeite = "DeleteFehlzeit";
		contentPane.add(deleteFZBtn);
		fzListe = new JComboBox<String>(dieSteuerung.getFehlzeitenListe(ausgewaehlterSchueler));
		fzListe.setBounds(116, 80, 250, 25);
		contentPane.add(fzListe);
		
	}
	
	private void schließeDeleteFehlzeit() {
		contentPane.remove(deleteFZBtn);
		contentPane.remove(fzListe);
	}
	
	private void clickAddFehlzeit() {
		String datum = checkDatumInput(fzDatum[0].getText().trim()) + "-" +checkDatumInput(fzDatum[1].getText().trim()) + "-" +checkDatumInput(fzDatum[2].getText().trim());
		String zustand = fzZustandFeld.getText().trim();
		String fehlzeit = fzMinutenFeld.getText().trim();
		String fach = faecherListe.getSelectedItem().toString();
		int stunde = Integer.parseInt(stundeFeld.getText().trim());
		dieSteuerung.setFehlzeit(datum, zustand, fach, schueler, Integer.parseInt(fehlzeit), stunde);
		schließeAddFehlzeit();
		zeigeLehrerMenue();
	}
	
	private void clickDeleteFehlzeit() {
		dieSteuerung.deleteFehlzeit(ausgewaehlterSchueler, fzListe.getSelectedIndex());
	}
	
}


