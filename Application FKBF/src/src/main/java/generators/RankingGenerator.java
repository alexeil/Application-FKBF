package src.main.java.generators;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import org.apache.log4j.Logger;
import src.main.java.classement.*;
import src.main.java.dao.FactoryDAO;
import src.main.java.metier.DivisionListeElement;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankingGenerator
    extends JFrame
{

    private final static Logger LOGGER = Logger.getLogger(RankingGenerator.class.getName());
    public static String RN = "\r\n";
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static int FIRST = 10;
    private static int SECOND = 6;
    private static int THIRD = 2;
    private static int FORFEIT = 0;
    private static ModeleModifiable modele = new ModeleModifiable();
    private static JTextField division;
    private static JTextArea textAreaErrors;
    private JTable tableau;
    private JCheckBox isHomme;
    private JComboBox<DivisionListeElement> divisionListe;

    private JDatePickerImpl dateJournee;

    public RankingGenerator()
    {
        super();
        setTitle("Classement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableau = new JTable(modele);

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableau.getModel());
        sorter.setComparator(0, new IntegerComparator());
        sorter.setComparator(3, new IntegerComparator());
        sorter.setComparator(4, new IntegerComparator());
        sorter.setComparator(5, new IntegerComparator());
        sorter.setComparator(6, new IntegerComparator());
        sorter.setComparator(7, new IntegerComparator());
        sorter.setComparator(8, new IntegerComparator());
        sorter.setComparator(9, new IntegerComparator());
        sorter.setComparator(10, new IntegerComparator());

        tableau.setRowSorter(sorter);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();
        GridBagLayout gbl_boutons = new GridBagLayout();
        gbl_boutons.columnWidths = new int[] { 0, 0, 0, 0, 0, 170, 211, 0 };
        gbl_boutons.rowHeights = new int[] { 0, 0, 0, 135, 0 };
        gbl_boutons.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_boutons.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        boutons.setLayout(gbl_boutons);

        JLabel lblNewLabel = new JLabel("Division :");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        boutons.add(lblNewLabel, gbc_lblNewLabel);

        division = new JTextField();
        GridBagConstraints gbc_division = new GridBagConstraints();
        gbc_division.gridwidth = 2;
        gbc_division.insets = new Insets(0, 0, 5, 5);
        gbc_division.fill = GridBagConstraints.HORIZONTAL;
        gbc_division.gridx = 1;
        gbc_division.gridy = 0;
        boutons.add(division, gbc_division);
        division.setColumns(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 5, 5);
        gbc.gridx = 3;
        gbc.gridy = 0;
        JButton button = new JButton(new AddAction());
        boutons.add(button, gbc);
        GridBagConstraints gbc_1 = new GridBagConstraints();
        gbc_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_1.insets = new Insets(0, 0, 5, 5);
        gbc_1.gridx = 4;
        gbc_1.gridy = 0;
        JButton button_1 = new JButton(new RemoveAction());
        boutons.add(button_1, gbc_1);

        JButton clearAll = new JButton("clearAll");
        clearAll.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clearTable();
            }
        });
        GridBagConstraints gbc_clearAll = new GridBagConstraints();
        gbc_clearAll.anchor = GridBagConstraints.WEST;
        gbc_clearAll.insets = new Insets(0, 0, 5, 5);
        gbc_clearAll.gridx = 5;
        gbc_clearAll.gridy = 0;
        boutons.add(clearAll, gbc_clearAll);

        JButton btnSaveDb = new JButton("Save DB");
        btnSaveDb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                saveTableDB();
            }
        });
        GridBagConstraints gbc_btnSaveDb = new GridBagConstraints();
        gbc_btnSaveDb.insets = new Insets(0, 0, 5, 0);
        gbc_btnSaveDb.gridx = 6;
        gbc_btnSaveDb.gridy = 0;
        boutons.add(btnSaveDb, gbc_btnSaveDb);

        JLabel lblDate = new JLabel("Date :");
        GridBagConstraints gbc_lblDate = new GridBagConstraints();
        gbc_lblDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblDate.gridx = 0;
        gbc_lblDate.gridy = 1;
        boutons.add(lblDate, gbc_lblDate);

        dateJournee = new JDatePickerImpl(new JDatePanelImpl(new UtilCalendarModel()));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        boutons.add(dateJournee, gbc_lblNewLabel_1);

        JButton btnLoadDb = new JButton("Load DB");
        btnLoadDb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                reloadTableDB();
            }
        });
        GridBagConstraints gbc_btnLoadDb = new GridBagConstraints();
        gbc_btnLoadDb.insets = new Insets(0, 0, 5, 0);
        gbc_btnLoadDb.gridx = 6;
        gbc_btnLoadDb.gridy = 1;
        boutons.add(btnLoadDb, gbc_btnLoadDb);

        JLabel lblSexe = new JLabel("Sexe :");
        GridBagConstraints gbc_lblSexe = new GridBagConstraints();
        gbc_lblSexe.insets = new Insets(0, 0, 5, 5);
        gbc_lblSexe.gridx = 0;
        gbc_lblSexe.gridy = 2;
        boutons.add(lblSexe, gbc_lblSexe);

        isHomme = new JCheckBox("Homme ?");
        GridBagConstraints gbc_isHomme = new GridBagConstraints();
        gbc_isHomme.insets = new Insets(0, 0, 5, 5);
        gbc_isHomme.gridx = 1;
        gbc_isHomme.gridy = 2;
        boutons.add(isHomme, gbc_isHomme);

        divisionListe = new JComboBox<DivisionListeElement>();
        GridBagConstraints gbc_divisionListe = new GridBagConstraints();
        gbc_divisionListe.insets = new Insets(0, 0, 5, 0);
        gbc_divisionListe.fill = GridBagConstraints.HORIZONTAL;
        gbc_divisionListe.gridx = 6;
        gbc_divisionListe.gridy = 2;
        boutons.add(divisionListe, gbc_divisionListe);

        textAreaErrors = new JTextArea();
        textAreaErrors.setRows(10);
        GridBagConstraints gbc_textAreaErrors = new GridBagConstraints();
        gbc_textAreaErrors.gridwidth = 4;
        gbc_textAreaErrors.insets = new Insets(0, 0, 0, 5);
        gbc_textAreaErrors.fill = GridBagConstraints.BOTH;
        gbc_textAreaErrors.gridx = 0;
        gbc_textAreaErrors.gridy = 3;
        boutons.add(textAreaErrors, gbc_textAreaErrors);

        getContentPane().add(boutons, BorderLayout.SOUTH);

        JButton generateHTML = new JButton("generateHTML");
        generateHTML.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                generateHTML();
            }
        });

        JButton btnCheckAll = new JButton("Check All");
        btnCheckAll.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                checkAll();
            }
        });
        GridBagConstraints gbc_btnCheckAll = new GridBagConstraints();
        gbc_btnCheckAll.insets = new Insets(0, 0, 0, 5);
        gbc_btnCheckAll.gridx = 4;
        gbc_btnCheckAll.gridy = 3;
        boutons.add(btnCheckAll, gbc_btnCheckAll);
        GridBagConstraints gbc_generateHTML = new GridBagConstraints();
        gbc_generateHTML.insets = new Insets(0, 0, 0, 5);
        gbc_generateHTML.gridx = 5;
        gbc_generateHTML.gridy = 3;
        boutons.add(generateHTML, gbc_generateHTML);

        GridBagConstraints gbc_2 = new GridBagConstraints();
        gbc_2.fill = GridBagConstraints.BOTH;
        gbc_2.gridx = 6;
        gbc_2.gridy = 3;
        FileChooser fileChooser = new FileChooser();
        boutons.add(fileChooser, gbc_2);

        try
        {
            FactoryDAO.getClassementDAO();
            loadDivisionListe();
        }
        catch(Exception e)
        {
            LOGGER.error("Pas de connection");
        }

        pack();
    }

    public static void main(String[] args)
    {
        new RankingGenerator().setVisible(true);
    }

    public static void reloadTable(String url)
    {
        clearTable();

        Classement classement = ReadAndPrintXMLFile.getClassementFromXML(url);

        ArrayList<Team> teams = new ArrayList<Team>();
        teams = (ArrayList<Team>) classement.getTeams();

        for(Team team : teams)
        {
            modele.addTeam(team);
        }

        division.setText(classement.getPoule());
        textAreaErrors.setText("");
    }

    private static void clearTable()
    {
        int size = modele.getRowCount();
        for(int i = 0; i < size; i++)
        {
            modele.removeTeam(0);
        }

        division.setText("");
    }

    public static void saveTable(String url)
    {
        modele.orderTeams();
        Classement classement = new Classement(division.getText(), modele.getTeams());
        ReadAndPrintXMLFile.getXMLFromClassement(classement, url);
    }

    private void loadDivisionListe()
    {
        for(DivisionListeElement divisionListeElement : FactoryDAO.getClassementDAO().getAllDivision())
        {
            divisionListe.addItem(divisionListeElement);
        }
    }

    public void reloadTableDB()
    {
        clearTable();

        Classement classement =
            FactoryDAO.getClassementDAO().selectAllClassement(getDateLong(), isHomme.isSelected() ? "M" : "F",
                ((DivisionListeElement) divisionListe.getSelectedItem()).getDivision());

        ArrayList<Team> teams = new ArrayList<Team>();
        teams = (ArrayList<Team>) classement.getTeams();

        for(Team team : teams)
        {
            modele.addTeam(team);
        }

        textAreaErrors.setText("");
    }

    public void saveTableDB()
    {
        modele.orderTeams();
        Classement classement =
            new Classement(division.getText(), modele.getTeams(), getDateLong(), isHomme.isSelected());
        FactoryDAO.getClassementDAO().deleteClassement(classement);
        FactoryDAO.getClassementDAO().insertClassement(classement);
        FactoryDAO.getClassementHtmlDAO().deleteClassementHtml(classement);
        FactoryDAO.getClassementHtmlDAO().insertClassement(classement, createHtml(classement));
    }

    private String getDateString()
    {

        return (dateJournee.getModel().getYear() + "-" + (dateJournee.getModel().getMonth() + 1) + "-" + dateJournee
            .getModel().getDay());
    }

    private long getDateLong()
    {
        long date = 0;
        try
        {
            date = DATE_FORMAT.parse(getDateString()).getTime();
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    private void checkAll()
    {
        modele.orderTeams();

        StringBuilder errors = new StringBuilder();
        boolean error = false;
        int sumPoints = 0;
        int sumMatchs = 0;

        int first = 0;
        int second = 0;
        int third = 0;
        int forfeit = 0;
        int nbPeriode = 0;
        int espritSportif = 0;

        List<Team> teams = modele.getTeams();

        for(Team team : teams)
        {

            first = Integer.parseInt(team.getFirst().replace("-", "0"));
            second = Integer.parseInt(team.getSecond().replace("-", "0"));
            third = Integer.parseInt(team.getThird().replace("-", "0"));
            forfeit = Integer.parseInt(team.getForfeit().replace("-", "0"));
            nbPeriode = Integer.parseInt(team.getNbPeriodes().replace("-", "0"));
            espritSportif = Integer.parseInt(team.getFairPlay().replace("-", "0"));

            sumPoints = first * FIRST + second * SECOND + third * THIRD + forfeit * FORFEIT + nbPeriode + espritSportif;

            sumMatchs = first + second + third + forfeit;

            if(sumPoints != Integer.parseInt(team.getPoints().replace("-", "0")))
            {
                errors.append(team.getTeam() + " : " + team.getPoints() + " diff�rent de " + sumPoints + RN);
                error = true;
            }

            if(sumMatchs != Integer.parseInt(team.getMj().replace("-", "0")))
            {
                errors.append(team.getTeam() + " : " + team.getMj() + " diff�rent de " + sumMatchs + RN);
                error = true;
            }

            if(!error)
            {
                errors.append(team.getTeam() + " : OK ! " + RN);
            }

            error = false;
            sumMatchs = 0;
            sumPoints = 0;
            first = 0;
            second = 0;
            third = 0;
            forfeit = 0;
            nbPeriode = 0;
            espritSportif = 0;
        }

        textAreaErrors.setText(errors.toString());
    }

    public void generateHTML()
    {
        modele.orderTeams();
        Classement classement = new Classement(division.getText(), modele.getTeams());
        StringBuilder html = createHtml(classement);

        writeToFile(classement.getPoule() + "_" + System.currentTimeMillis(), html);
        System.out.println(html.toString());
    }

    private StringBuilder createHtml(Classement classement)
    {
        StringBuilder html = new StringBuilder();

        html.append("<table class=\"tableau_classement_poule\" cellspacing=\"0\">" + RN);
        html.append("	<tr class=\"premiere_ligne\">" + RN);
        html.append("		<td colspan=\"11\">" + classement.getPoule() + "</td>" + RN);
        html.append("	</tr>" + RN);

        html.append("	<tr class=\"premiere_ligne\">" + RN);
        html.append("		<td colspan=\"3\">Classement</td>" + RN);
        html.append("		<td>Points</td>" + RN);
        html.append("		<td>MJ</td>" + RN);
        html.append("		<td>Premi�re place</td>" + RN);
        html.append("		<td>Deuxi�me place</td>" + RN);
        html.append("		<td>Troisi�me place</td>" + RN);
        html.append("		<td>Forfait</td>" + RN);
        html.append("		<td>Nb p�riodes</td>" + RN);
        html.append("		<td>Esprit sportif</td>" + RN);
        html.append("	</tr>" + RN);

        for(Team team : classement.getTeams())
        {
            html.append("	<tr>" + RN);
            html.append("		<td class=\"rang\">" + team.getRank() + "</td>" + RN);
            html.append(
                "		<td class=\"drapeau\"><img src=\"http://www.kin-ball.fr/images/clubs/logo_" + team.getLogo()
                    + "_mini.png\" border=\"0\"/></td>" + RN);
            html.append("		<td class=\"equipe\">" + team.getTeam() + "</td>" + RN);
            html.append("		<td class=\"points\">" + team.getPoints() + "</td>" + RN);
            html.append("		<td class=\"mj\">" + team.getMj() + "</td>" + RN);
            html.append("		<td class=\"1erep\">" + team.getFirst() + "</td>" + RN);
            html.append("		<td class=\"2emep\">" + team.getSecond() + "</td>" + RN);
            html.append("		<td class=\"3emep\">" + team.getThird() + "</td>" + RN);
            html.append("		<td class=\"forfait\">" + team.getForfeit() + "</td>" + RN);
            html.append("		<td class=\"periodes\">" + team.getNbPeriodes() + "</td>" + RN);
            html.append("		<td class=\"fairplay\">" + team.getFairPlay() + "</td>" + RN);
            html.append("	</tr>" + RN);
        }

        html.append("</table>" + RN);
        return html;
    }

    private void writeToFile(String fileName, StringBuilder html)
    {
        FileOutputStream fop = null;
        File file;

        try
        {

            file = new File("c:/resultats/" + fileName + ".html");
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if(!file.exists())
            {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = html.toString().getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(fop != null)
                {
                    fop.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private class AddAction
        extends AbstractAction
    {
        private AddAction()
        {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e)
        {
            modele.addTeam(new Team("", "", "", "", "", "", "", "", "", "", ""));
        }
    }

    private class RemoveAction
        extends AbstractAction
    {
        private RemoveAction()
        {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e)
        {
            int[] selection = tableau.getSelectedRows();
            int[] modelIndexes = new int[selection.length];

            for(int i = 0; i < selection.length; i++)
            {
                modelIndexes[i] = tableau.getRowSorter().convertRowIndexToModel(selection[i]);
            }

            Arrays.sort(modelIndexes);

            for(int i = modelIndexes.length - 1; i >= 0; i--)
            {
                modele.removeTeam(modelIndexes[i]);
            }
        }
    }
}