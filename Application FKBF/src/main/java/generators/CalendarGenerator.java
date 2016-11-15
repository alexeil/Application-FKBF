package main.java.generators;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.java.calendar.CalendarUtils;
import main.java.calendar.EventDayKB;
import main.java.calendar.EventKB;
import main.java.calendar.ModeleModifiableCalendar;
import main.java.calendar.SexeCellRenderer;
import main.java.calendar.TimeChooserCellEditor;
import main.java.calendar.TimeChooserCellRenderer;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

import org.apache.log4j.Logger;

import com.google.gdata.util.ServiceException;

public class CalendarGenerator extends JFrame {

	private final static Logger LOGGER = Logger
			.getLogger(CalendarGenerator.class.getName());

	private String[] namesOfDays = { "dimanche", "lundi", "mardi", "mercredi",
			"jeudi", "vendredi", "samedi" };
	private String[] namesOfMonths = { "janvier", "février", "mars", "avril",
			"mai", "juin", "juillet", "août", "septembre", "octobre",
			"novembre", "décembre" };

	public static Map<String, String> nieme = new HashMap<String, String>();
	static {
		nieme.put("1ère", "première");
		nieme.put("2ème", "deuxième");
		nieme.put("3ème", "troisième");
		nieme.put("4ème", "quatrième");
		nieme.put("5ème", "cinquième");
		nieme.put("6ème", "sixième");
		nieme.put("7ème", "septième");
		nieme.put("8ème", "huitième");
		nieme.put("9ème", "neuvième");
		nieme.put("10ème", "dixième");
		nieme.put("11ème", "onzième");
		nieme.put("12ème", "douzième");
		nieme.put("13ème", "treizième");
		nieme.put("14ème", "quatorzième");
		nieme.put("15ème", "quinzième");
		nieme.put("16ème", "seizième");
		nieme.put("17ème", "dix-septième");
		nieme.put("18ème", "dix-huitième");
		nieme.put("19ème", "dix-neuvième");
		nieme.put("20ème", "vingtième");
		nieme.put("21ème", "vingt-et-unième");
		nieme.put("22ème", "vingt-deuxième");
		nieme.put("23ème", "vingt-troisième");
	}

	public static String RN = "\r\n";

	private static ModeleModifiableCalendar modele = new ModeleModifiableCalendar();
	private EventDayKB eventDayKB;
	private JTable tableau;
	private JDatePickerImpl dateJournee;
	private JTextField ville;
	private JTextField titre;
	private JTable table;
	private JButton loadTable;
	private JButton addEvent;
	private JButton deleteEvent;
	private JButton generateHtml;
	private JButton postToGoogle;

	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat day = new SimpleDateFormat("dd");
	SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
	private JButton generateAnnonce;
	private JDialog dialog;
	private JLabel lblNewLabel;
	private JTextField imageAnnonce;
	private JTextArea descriptionAnnonce;
	private JButton btnNewButton;

	private static String INIT_TEXT_AREA = "La <nieme> journée du championnat de France de Kin-Ball se déroulera le <jour> <numJour> <mois> <annee> à <ville>. \n\r  \n\r Les matchs auront lieu à <adresse>. Le premier match commencera à <heure>. Les horaires indiqués sont les horaires de début de match au plus tôt. \n\r  \n\r";

	// private SimpleDate Format dateformat = new
	// SimpleDateFormat("dd/MM/yyyy");
	public CalendarGenerator() {

		// initialise le canlendrier
		CalendarUtils.initCalendarUtils();

		this.setTitle("Calendrier");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblDate = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 0;
		getContentPane().add(lblDate, gbc_lblDate);

		dateJournee = new JDatePickerImpl(new JDatePanelImpl(
				new UtilCalendarModel()));
		GridBagConstraints gbc_dateJournee = new GridBagConstraints();
		gbc_dateJournee.gridwidth = 2;
		gbc_dateJournee.insets = new Insets(0, 0, 5, 5);
		gbc_dateJournee.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateJournee.gridx = 3;
		gbc_dateJournee.gridy = 0;
		getContentPane().add(dateJournee, gbc_dateJournee);

		loadTable = new JButton("Search for events");

		loadTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				reloadTable();
			}
		});

		GridBagConstraints gbc_loadTable = new GridBagConstraints();
		gbc_loadTable.insets = new Insets(0, 0, 5, 5);
		gbc_loadTable.gridx = 6;
		gbc_loadTable.gridy = 0;
		getContentPane().add(loadTable, gbc_loadTable);

		JLabel lblVille = new JLabel("Ville :");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.anchor = GridBagConstraints.EAST;
		gbc_lblVille.gridx = 1;
		gbc_lblVille.gridy = 1;
		getContentPane().add(lblVille, gbc_lblVille);

		ville = new JTextField();
		GridBagConstraints gbc_ville = new GridBagConstraints();
		gbc_ville.gridwidth = 2;
		gbc_ville.insets = new Insets(0, 0, 5, 5);
		gbc_ville.fill = GridBagConstraints.HORIZONTAL;
		gbc_ville.gridx = 3;
		gbc_ville.gridy = 1;
		getContentPane().add(ville, gbc_ville);
		ville.setColumns(10);

		JLabel lblTitreDeLa = new JLabel("Titre de la journ\u00E9e :");
		GridBagConstraints gbc_lblTitreDeLa = new GridBagConstraints();
		gbc_lblTitreDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitreDeLa.anchor = GridBagConstraints.EAST;
		gbc_lblTitreDeLa.gridx = 1;
		gbc_lblTitreDeLa.gridy = 2;
		getContentPane().add(lblTitreDeLa, gbc_lblTitreDeLa);

		titre = new JTextField();
		GridBagConstraints gbc_titre = new GridBagConstraints();
		gbc_titre.gridwidth = 5;
		gbc_titre.insets = new Insets(0, 0, 5, 5);
		gbc_titre.anchor = GridBagConstraints.NORTH;
		gbc_titre.fill = GridBagConstraints.HORIZONTAL;
		gbc_titre.gridx = 3;
		gbc_titre.gridy = 2;
		getContentPane().add(titre, gbc_titre);
		titre.setColumns(10);

		tableau = new JTable(modele);
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableau.setFillsViewportHeight(true);
		tableau.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableau.getColumnModel().getColumn(1).setPreferredWidth(85);
		tableau.getColumnModel().getColumn(2).setPreferredWidth(35);
		tableau.getColumnModel().getColumn(3).setPreferredWidth(35);

		for (int i = 0; i < tableau.getColumnModel().getColumnCount(); i++) {
			tableau.getColumnModel().getColumn(i).setResizable(false);
		}
		// JLabel lblTableau = new JLabel("New label");
		GridBagConstraints gbc_lblTableau = new GridBagConstraints();
		gbc_lblTableau.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTableau.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_lblTableau.insets = new Insets(0, 0, 5, 5);
		gbc_lblTableau.gridwidth = 6;
		gbc_lblTableau.gridx = 2;
		gbc_lblTableau.gridy = 3;
		JScrollPane scrollPane = new JScrollPane(tableau);
		getContentPane().add(scrollPane, gbc_lblTableau);

		// boutons.add(new JButton(new RemoveAction()));

		addEvent = new JButton(new AddAction());
		GridBagConstraints gbc_addEvent = new GridBagConstraints();
		gbc_addEvent.anchor = GridBagConstraints.EAST;
		gbc_addEvent.insets = new Insets(0, 0, 0, 5);
		gbc_addEvent.gridx = 1;
		gbc_addEvent.gridy = 4;
		getContentPane().add(addEvent, gbc_addEvent);

		deleteEvent = new JButton(new RemoveAction());
		GridBagConstraints gbc_deleteEvent = new GridBagConstraints();
		gbc_deleteEvent.insets = new Insets(0, 0, 0, 5);
		gbc_deleteEvent.gridx = 3;
		gbc_deleteEvent.gridy = 4;
		getContentPane().add(deleteEvent, gbc_deleteEvent);

		generateHtml = new JButton("Generate Html");
		generateHtml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateHTML();
			}
		});
		GridBagConstraints gbc_generateHtml = new GridBagConstraints();
		gbc_generateHtml.insets = new Insets(0, 0, 0, 5);
		gbc_generateHtml.gridx = 5;
		gbc_generateHtml.gridy = 4;
		getContentPane().add(generateHtml, gbc_generateHtml);

		postToGoogle = new JButton("Post to Google Calendar");
		postToGoogle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					postToGoogleCalendar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_postToGoogle = new GridBagConstraints();
		gbc_postToGoogle.insets = new Insets(0, 0, 0, 5);
		gbc_postToGoogle.gridx = 6;
		gbc_postToGoogle.gridy = 4;
		getContentPane().add(postToGoogle, gbc_postToGoogle);

		generateAnnonce = new JButton("Generate annonce");
		generateAnnonce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.setVisible(true);

				String description = INIT_TEXT_AREA.replace("<ville>",
						ville.getText());
				description = description.replace("<jour>", getDay());
				description = description.replace("<numJour>", getNumDay());
				description = description.replace("<mois>", getMonth());
				description = description.replace("<annee>", getYear());
				description = description.replace(
						"<heure>",
						timeformat
								.format(new Date(modele.getEventsKB().get(0)
										.getDebut())).replace(":", "h"));
				description = description.replace("<nieme>",
						nieme.get(titre.getText().split(" ")[0]));

				descriptionAnnonce.setText(description);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(generateAnnonce, gbc_btnNewButton);

		dialog = new JDialog();
		dialog.setTitle("Generate your annonce");
		dialog.setSize(450, 250);
		dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		dialog.setLocationRelativeTo(null);

		GridBagLayout gridBagLayout2 = new GridBagLayout();
		gridBagLayout2.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout2.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout2.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		dialog.getContentPane().setLayout(gridBagLayout2);

		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		dialog.getContentPane().add(lblDescription, gbc_lblDescription);

		descriptionAnnonce = new JTextArea();
		descriptionAnnonce.setLineWrap(true);
		descriptionAnnonce.setWrapStyleWord(true);
		descriptionAnnonce.setText(INIT_TEXT_AREA);

		GridBagConstraints gbc_descriptionAnnonce = new GridBagConstraints();
		gbc_descriptionAnnonce.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionAnnonce.fill = GridBagConstraints.BOTH;
		gbc_descriptionAnnonce.gridx = 1;
		gbc_descriptionAnnonce.gridy = 1;
		dialog.getContentPane().add(descriptionAnnonce, gbc_descriptionAnnonce);

		lblNewLabel = new JLabel("ImageName");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		dialog.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		imageAnnonce = new JTextField();
		GridBagConstraints gbc_imageAnnonce = new GridBagConstraints();
		gbc_imageAnnonce.insets = new Insets(0, 0, 5, 5);
		gbc_imageAnnonce.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageAnnonce.gridx = 1;
		gbc_imageAnnonce.gridy = 2;
		dialog.getContentPane().add(imageAnnonce, gbc_imageAnnonce);
		imageAnnonce.setColumns(10);

		JButton generateOK = new JButton("Generate");
		generateOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				generateAnnonceHTML();
				dialog.setVisible(false);
			}
		});

		GridBagConstraints gbc_generateOK = new GridBagConstraints();
		gbc_generateOK.insets = new Insets(0, 0, 5, 5);
		gbc_generateOK.gridx = 1;
		gbc_generateOK.gridy = 3;
		dialog.getContentPane().add(generateOK, gbc_generateOK);

		tableau.setDefaultRenderer(Boolean.class, new SexeCellRenderer());
		tableau.setDefaultRenderer(Long.class, new TimeChooserCellRenderer());
		tableau.setDefaultEditor(Long.class, new TimeChooserCellEditor());
	}

	public void reloadTable() {
		clearTable();
		long date = new Date(getDateLong()).getTime();
		long datePlusOne = new Date(date + (1000 * 60 * 60 * 24)).getTime();

		try {
			eventDayKB = CalendarUtils.dateRangeQuery(date, datePlusOne);

			ville.setText(eventDayKB.getVille());
			titre.setText(eventDayKB.getTitre());

			eventDayKB.toString();

			for (EventKB eventKB : eventDayKB.getEvents()) {
				modele.addEvent(eventKB);
			}

		} catch (Exception e) {
			LOGGER.error("Exeption lors du chargement du tableau", e);
		}
	}

	public static void main(String[] args) {
		/*File file= 	new File("C:\\resultats\\toto");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		new CalendarGenerator().setVisible(true);
	}

	private class AddAction extends AbstractAction {
		private AddAction() {
			super("Add Event");

		}

		public void actionPerformed(ActionEvent e) {
			EventKB eventKB = new EventKB();
			if (modele.getRowCount() > 0) {
				eventKB.setDebut(modele.getEventsKB()
						.get(modele.getRowCount() - 1).getFin());
				eventKB.setFin(modele.getEventsKB()
						.get(modele.getRowCount() - 1).getFin()
						+ (60 * 60 * 1000));
			}

			modele.addEvent(eventKB);

		}
	}

	private class RemoveAction extends AbstractAction {
		private RemoveAction() {
			super("Delete Event");
		}

		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();
			int[] modelIndexes = new int[selection.length];

			for (int i = 0; i < selection.length; i++) {
				modelIndexes[i] = tableau.getRowSorter()
						.convertRowIndexToModel(selection[i]);
			}

			Arrays.sort(modelIndexes);

			for (int i = modelIndexes.length - 1; i >= 0; i--) {
				modele.removeTeam(modelIndexes[i]);
			}
		}
	}

	private String getDateString() {

		return (dateJournee.getModel().getYear() + "-"
				+ (dateJournee.getModel().getMonth() + 1) + "-" + dateJournee
				.getModel().getDay());
	}

	private long getDateLong() {
		long date = 0;
		try {
			date = dateformat.parse(getDateString()).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	private void clearTable() {
		modele.removeEventDayKB();
	}

	public String getDay() {
		GregorianCalendar calendar = (GregorianCalendar) dateJournee.getModel()
				.getValue();
		return namesOfDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public String getNumDay() {
		GregorianCalendar calendar = (GregorianCalendar) dateJournee.getModel()
				.getValue();
		return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	}

	public String getMonth() {
		GregorianCalendar calendar = (GregorianCalendar) dateJournee.getModel()
				.getValue();
		return namesOfMonths[calendar.get(Calendar.MONTH)];
	}

	public String getYear() {
		GregorianCalendar calendar = (GregorianCalendar) dateJournee.getModel()
				.getValue();
		return String.valueOf(calendar.get(Calendar.YEAR));
	}

	public void generateHTML() {

		GregorianCalendar calendar = (GregorianCalendar) dateJournee.getModel()
				.getValue();

		StringBuilder html = new StringBuilder();

		html.append("<p class=\"date\">" + getDay() + " " + getNumDay() + " "
				+ getMonth() + " " + getYear() + " à" + ville.getText()
				+ "</p>");
		html.append(RN);

		html.append("<div class=\"championnat_masculin\">Championnat Masculin</div> "
				+ RN);
		html.append("<div class=\"championnat_feminin\">Championnat Féminin</div> "
				+ RN);
		html.append("<div style=\"clear:both;\"></div>" + RN);

		int index = 0;
		boolean precIsHomme = true;
		boolean firstTime = true;
		for (EventKB eventKB : modele.getEventsKB()) {

			if (firstTime || eventKB.isHomme() != precIsHomme) {
				if (eventKB.isHomme()) {
					html.append("<table class=\"tableau_match\" cellspacing=\"0\">"
							+ RN);
				} else {
					html.append("<table class=\"tableau_match_feminin\" cellspacing=\"0\">"
							+ RN);
				}
				html.append("	<tr> " + RN);
				html.append("		<td class=\"heure\">Heure</td>" + RN);
				html.append("		<td class=\"premiere_colonne\">Match</td> " + RN);
				html.append("		<td class=\"bleu\">Bleu</td> " + RN);
				html.append("		<td class=\"gris\">Gris</td> " + RN);
				html.append("		<td class=\"noir\">Noir</td>" + RN);
				html.append("	</tr> " + RN);
			}

			html.append("	<tr> " + RN);
			html.append("		<td> "
					+ timeformat.format(new Date(eventKB.getDebut())).replace(
							":", "h") + " </td>" + RN);
			html.append("		<td class=\"premiere_colonne\"> #"
					+ eventKB.getIdMatch() + " </td> " + RN);
			html.append("		<td> " + eventKB.getEquipeBleu() + " </td> " + RN);
			html.append("		<td> " + eventKB.getEquipeGris() + " </td> " + RN);
			html.append("		<td> " + eventKB.getEquipeNoir() + " </td> " + RN);
			html.append("	<tr> " + RN);

			if (modele.getEventsKB().size() != index + 1
					&& eventKB.isHomme() != modele.getEventsKB().get(index + 1)
							.isHomme()) {
				html.append("</table> " + RN);
			}

			precIsHomme = eventKB.isHomme();
			firstTime = false;
			index++;
		}
		html.append("</table> " + RN);
		writeToFile(eventDayKB.getTitre(), html);
		System.out.println(html.toString());
	}

	public void generateAnnonceHTML() {
		StringBuilder html = new StringBuilder();

		html.append("<p>" + RN);
		html.append("	<img src=\"http://www.kin-ball.fr/images/championnat1516/"
				+ imageAnnonce.getText()
				+ " \" align=\"left\" style=\"margin-right:20px;margin-bottom:20px;width:200px;\">"
				+ RN);
		html.append(descriptionAnnonce.getText().replace("\n\r", "</br >") + RN);
		html.append("	Voici les matchs :" + RN);
		html.append(" 	<table class=\"tableau_journee_avec_image\">" + RN);
		html.append(" 		<tr>" + RN);
		html.append(" 			<td class=\"championnat\">Championnat</td>" + RN);
		html.append(" 			<td class=\"bleu\">Bleu</td>" + RN);
		html.append(" 			<td class=\"gris\">Gris</td>" + RN);
		html.append("			<td class=\"noir\">Noir</td>" + RN);
		html.append(" 			<td class=\"horaire\">Horaire</td>" + RN);
		html.append(" 		</tr>" + RN);

		for (EventKB eventKB : modele.getEventsKB()) {
			html.append("		<tr>" + RN);
			if (eventKB.isHomme()) {
				html.append("			<td>Masculin</td>" + RN);
			} else {
				html.append("			<td>Féminin</td>" + RN);
			}
			html.append("		<td> " + eventKB.getEquipeBleu() + " </td> " + RN);
			html.append("		<td> " + eventKB.getEquipeGris() + " </td> " + RN);
			html.append("		<td> " + eventKB.getEquipeNoir() + " </td> " + RN);
			html.append("		<td> "
					+ timeformat.format(new Date(eventKB.getDebut())).replace(
							":", "h") + " </td>" + RN);

			html.append(" 		</tr>" + RN);

		}
		html.append("	</table> " + RN);
		html.append("</p> " + RN);
		writeToFile("Annonce-" + eventDayKB.getTitre(), html);

		System.out.println(html.toString());
	}

	private void writeToFile(String fileName, StringBuilder html) {
		FileOutputStream fop = null;
		File file;

		try {

			file = new File("C:\\resultats\\" + fileName + ".html");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = html.toString().getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void postToGoogleCalendar() throws ServiceException, IOException {

		if (null == eventDayKB) {
			eventDayKB = new EventDayKB();

		}

		eventDayKB.setEvents(modele.getEventsKB());
		eventDayKB.setDate(getDateLong());
		eventDayKB.setVille(ville.getText());
		eventDayKB.setTitre(titre.getText());

		if (null == eventDayKB.getCalendarEventEntry()) {
			eventDayKB.setCalendarEventEntry(CalendarUtils.createDayEvent(
					titre.getText(), "J", getDateLong(), ville.getText()));
		} else {

			eventDayKB.setCalendarEventEntry(CalendarUtils.updateDayEvent(
					eventDayKB.getCalendarEventEntry(), titre.getText(), "J",
					getDateLong(), ville.getText()));
		}

		for (EventKB eventKB : eventDayKB.getEvents()) {
			if (null == eventKB.getCalendarEventEntry()) {
				eventDayKB.setCalendarEventEntry(CalendarUtils.createEvent(
						eventKB, ville.getText(), getDateLong()));
			} else {
				CalendarUtils.updateEvent(eventKB, ville.getText(),
						getDateLong());
			}

		}
	}
}