package generators;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import metier.Equipe;
import metier.Match;
import dao.MatchDAO;

public class FeuilleDeMatchGenerator
    extends JFrame
{

    private static final long serialVersionUID = 1L;

    public static String RN = "\r\n";

    public static String PLUS_SRC = "http://www.kin-ball.fr/images/plus.jpg";
    public static String MOINS_SRC = "http://www.kin-ball.fr/images/moins.jpg";

    private JTextField equipeGris;
    private JTextField EquipeNoir;
    private JTextField equipeBleu;
    private JTextField match;
    private JTextField txtPriode;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTextField textField_21;
    private JTextField textField_22;
    private JTextField textField_23;
    private JTextField textField_24;
    private JTextField textField_25;
    private JTextField txtPointage;
    private JTextField txtProlongation;
    private JTextField txtPriodesGagns;
    private JTextField txtEspritSportif;
    private JTextField txtPointsChampionnats;
    private JTextField P1B;
    private JTextField P2B;
    private JTextField P3B;
    private JTextField P4B;
    private JTextField P5B;
    private JTextField P6B;
    private JTextField P7B;
    private JTextField prol1B;
    private JTextField prol2B;
    private JTextField prol3B;
    private JTextField prol4B;
    private JTextField prol5B;
    private JTextField prol6B;
    private JTextField prol7B;
    private JTextField prol1N;
    private JTextField P1N;
    private JTextField P2N;
    private JTextField prol2N;
    private JTextField P3N;
    private JTextField prol3N;
    private JTextField P4N;
    private JTextField prol4N;
    private JTextField P5N;
    private JTextField prol5N;
    private JTextField P6N;
    private JTextField prol6N;
    private JTextField P7N;
    private JTextField prol7N;
    private JTextField P1G;
    private JTextField prol1G;
    private JTextField P2G;
    private JTextField prol2G;
    private JTextField P3G;
    private JTextField prol3G;
    private JTextField P4G;
    private JTextField prol4G;
    private JTextField P5G;
    private JTextField prol5G;
    private JTextField P6G;
    private JTextField prol6G;
    private JTextField P7G;
    private JTextField prol7G;
    private JTextField prol22B;
    private JTextField periodeGagneeBleu;
    private JTextField espritSportifBleu;
    private JTextField pointBleu;
    private JTextField prol22N;
    private JTextField periodeGagneeNoir;
    private JTextField espritSportifNoir;
    private JTextField pointNoir;
    private JTextField prol22G;
    private JTextField periodeGagneeGris;
    private JTextField espritSportifGris;
    private JTextField pointGris;
    private JButton btnNewButton;
    private GridBagLayout gridBagLayout;

    private JTextField Prolong2emePlace;
    private JTextField idMatch;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JTextField arbitreAdjoint;
    private JTextField arbitreChef;
    private JLabel lblArbitreAdjoint;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton clearAll;
    private JLabel lblForfait;
    private JCheckBox forfaitBleu;
    private JCheckBox forfaitGris;
    private JCheckBox forfaitNoir;
    private JButton btnSaveDb;
    private JButton btnLoadDb;

    public FeuilleDeMatchGenerator()
    {
        this.setTitle("Tableau de match");
        this.setSize(1010, 371);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights =
            new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
                1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights =
            new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);

        lblNewLabel = new JLabel("Identifiant");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 3;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel.gridx = 17;
        gbc_lblNewLabel.gridy = 0;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        idMatch = new JTextField();
        GridBagConstraints gbc_idMatch = new GridBagConstraints();
        gbc_idMatch.gridwidth = 2;
        gbc_idMatch.insets = new Insets(0, 0, 5, 0);
        gbc_idMatch.fill = GridBagConstraints.HORIZONTAL;
        gbc_idMatch.gridx = 20;
        gbc_idMatch.gridy = 0;
        getContentPane().add(idMatch, gbc_idMatch);
        idMatch.setColumns(10);

        lblForfait = new JLabel("Forfait ?");
        GridBagConstraints gbc_lblForfait = new GridBagConstraints();
        gbc_lblForfait.insets = new Insets(0, 0, 5, 5);
        gbc_lblForfait.gridx = 0;
        gbc_lblForfait.gridy = 1;
        getContentPane().add(lblForfait, gbc_lblForfait);

        forfaitBleu = new JCheckBox("Forfait bleu ?");
        GridBagConstraints gbc_forfaitBleu = new GridBagConstraints();
        gbc_forfaitBleu.gridwidth = 6;
        gbc_forfaitBleu.insets = new Insets(0, 0, 5, 5);
        gbc_forfaitBleu.gridx = 2;
        gbc_forfaitBleu.gridy = 1;
        getContentPane().add(forfaitBleu, gbc_forfaitBleu);

        forfaitGris = new JCheckBox("forfait gris ?");
        GridBagConstraints gbc_forfaitGris = new GridBagConstraints();
        gbc_forfaitGris.gridwidth = 6;
        gbc_forfaitGris.insets = new Insets(0, 0, 5, 5);
        gbc_forfaitGris.gridx = 9;
        gbc_forfaitGris.gridy = 1;
        getContentPane().add(forfaitGris, gbc_forfaitGris);

        forfaitNoir = new JCheckBox("forfait noir ?");
        GridBagConstraints gbc_forfaitNoir = new GridBagConstraints();
        gbc_forfaitNoir.gridwidth = 6;
        gbc_forfaitNoir.insets = new Insets(0, 0, 5, 0);
        gbc_forfaitNoir.gridx = 16;
        gbc_forfaitNoir.gridy = 1;
        getContentPane().add(forfaitNoir, gbc_forfaitNoir);

        match = new JTextField();
        match.setText("Match");
        GridBagConstraints gbc_match = new GridBagConstraints();
        gbc_match.insets = new Insets(0, 0, 5, 5);
        gbc_match.fill = GridBagConstraints.HORIZONTAL;
        gbc_match.gridx = 0;
        gbc_match.gridy = 2;
        getContentPane().add(match, gbc_match);
        match.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBackground(Color.BLUE);
        textField_2.setForeground(Color.BLACK);
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 2;
        getContentPane().add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);

        equipeBleu = new JTextField();
        // FIXME COLOR
        equipeBleu.setBackground(Color.WHITE);
        // equipeBleu.setText("Equipe Bleu ");
        equipeBleu.setText("");
        GridBagConstraints gbc_equipeBleu = new GridBagConstraints();
        gbc_equipeBleu.gridwidth = 6;
        gbc_equipeBleu.insets = new Insets(0, 0, 5, 5);
        gbc_equipeBleu.fill = GridBagConstraints.HORIZONTAL;
        gbc_equipeBleu.gridx = 2;
        gbc_equipeBleu.gridy = 2;
        getContentPane().add(equipeBleu, gbc_equipeBleu);
        equipeBleu.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBackground(Color.GRAY);
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 8;
        gbc_textField_3.gridy = 2;
        getContentPane().add(textField_3, gbc_textField_3);
        textField_3.setColumns(10);

        equipeGris = new JTextField();
        // FIXME COLOR
        equipeGris.setBackground(Color.WHITE);
        // equipeGris.setText("Equipe Gris");
        equipeGris.setText("");
        GridBagConstraints gbc_equipeGris = new GridBagConstraints();
        gbc_equipeGris.gridwidth = 6;
        gbc_equipeGris.insets = new Insets(0, 0, 5, 5);
        gbc_equipeGris.fill = GridBagConstraints.HORIZONTAL;
        gbc_equipeGris.gridx = 9;
        gbc_equipeGris.gridy = 2;
        getContentPane().add(equipeGris, gbc_equipeGris);
        equipeGris.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBackground(Color.BLACK);
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 15;
        gbc_textField_4.gridy = 2;
        getContentPane().add(textField_4, gbc_textField_4);
        textField_4.setColumns(10);

        EquipeNoir = new JTextField();
        // FIXME COLOR
        EquipeNoir.setBackground(Color.WHITE);
        // EquipeNoir.setText("Equipe Noir");
        EquipeNoir.setText("");
        GridBagConstraints gbc_EquipeNoir = new GridBagConstraints();
        gbc_EquipeNoir.gridwidth = 6;
        gbc_EquipeNoir.insets = new Insets(0, 0, 5, 0);
        gbc_EquipeNoir.fill = GridBagConstraints.HORIZONTAL;
        gbc_EquipeNoir.gridx = 16;
        gbc_EquipeNoir.gridy = 2;
        getContentPane().add(EquipeNoir, gbc_EquipeNoir);
        EquipeNoir.setColumns(10);

        txtPriode = new JTextField();
        txtPriode.setText("P\u00E9riode");
        GridBagConstraints gbc_txtPriode = new GridBagConstraints();
        gbc_txtPriode.weightx = 5.0;
        gbc_txtPriode.insets = new Insets(0, 0, 5, 5);
        gbc_txtPriode.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPriode.gridx = 0;
        gbc_txtPriode.gridy = 3;
        getContentPane().add(txtPriode, gbc_txtPriode);
        txtPriode.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setText("1");
        GridBagConstraints gbc_textField_6 = new GridBagConstraints();
        gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_6.insets = new Insets(0, 0, 5, 5);
        gbc_textField_6.gridx = 1;
        gbc_textField_6.gridy = 3;
        getContentPane().add(textField_6, gbc_textField_6);
        textField_6.setColumns(10);

        textField_11 = new JTextField();
        textField_11.setText("2");
        GridBagConstraints gbc_textField_11 = new GridBagConstraints();
        gbc_textField_11.insets = new Insets(0, 0, 5, 5);
        gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_11.gridx = 2;
        gbc_textField_11.gridy = 3;
        getContentPane().add(textField_11, gbc_textField_11);
        textField_11.setColumns(10);

        textField_10 = new JTextField();
        textField_10.setText("3");
        GridBagConstraints gbc_textField_10 = new GridBagConstraints();
        gbc_textField_10.insets = new Insets(0, 0, 5, 5);
        gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_10.gridx = 3;
        gbc_textField_10.gridy = 3;
        getContentPane().add(textField_10, gbc_textField_10);
        textField_10.setColumns(10);

        textField_9 = new JTextField();
        textField_9.setText("4");
        GridBagConstraints gbc_textField_9 = new GridBagConstraints();
        gbc_textField_9.insets = new Insets(0, 0, 5, 5);
        gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_9.gridx = 4;
        gbc_textField_9.gridy = 3;
        getContentPane().add(textField_9, gbc_textField_9);
        textField_9.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setText("5");
        GridBagConstraints gbc_textField_8 = new GridBagConstraints();
        gbc_textField_8.insets = new Insets(0, 0, 5, 5);
        gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_8.gridx = 5;
        gbc_textField_8.gridy = 3;
        getContentPane().add(textField_8, gbc_textField_8);
        textField_8.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setText("6");
        GridBagConstraints gbc_textField_7 = new GridBagConstraints();
        gbc_textField_7.insets = new Insets(0, 0, 5, 5);
        gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_7.gridx = 6;
        gbc_textField_7.gridy = 3;
        getContentPane().add(textField_7, gbc_textField_7);
        textField_7.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setText("7");
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.insets = new Insets(0, 0, 5, 5);
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.gridx = 7;
        gbc_textField_5.gridy = 3;
        getContentPane().add(textField_5, gbc_textField_5);
        textField_5.setColumns(10);

        textField_12 = new JTextField();
        textField_12.setText("1");
        GridBagConstraints gbc_textField_12 = new GridBagConstraints();
        gbc_textField_12.insets = new Insets(0, 0, 5, 5);
        gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_12.gridx = 8;
        gbc_textField_12.gridy = 3;
        getContentPane().add(textField_12, gbc_textField_12);
        textField_12.setColumns(10);

        textField_13 = new JTextField();
        textField_13.setText("2");
        GridBagConstraints gbc_textField_13 = new GridBagConstraints();
        gbc_textField_13.insets = new Insets(0, 0, 5, 5);
        gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_13.gridx = 9;
        gbc_textField_13.gridy = 3;
        getContentPane().add(textField_13, gbc_textField_13);
        textField_13.setColumns(10);

        textField_14 = new JTextField();
        textField_14.setText("3");
        GridBagConstraints gbc_textField_14 = new GridBagConstraints();
        gbc_textField_14.insets = new Insets(0, 0, 5, 5);
        gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_14.gridx = 10;
        gbc_textField_14.gridy = 3;
        getContentPane().add(textField_14, gbc_textField_14);
        textField_14.setColumns(10);

        textField_15 = new JTextField();
        textField_15.setText("4");
        GridBagConstraints gbc_textField_15 = new GridBagConstraints();
        gbc_textField_15.insets = new Insets(0, 0, 5, 5);
        gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_15.gridx = 11;
        gbc_textField_15.gridy = 3;
        getContentPane().add(textField_15, gbc_textField_15);
        textField_15.setColumns(10);

        textField_16 = new JTextField();
        textField_16.setText("5");
        GridBagConstraints gbc_textField_16 = new GridBagConstraints();
        gbc_textField_16.insets = new Insets(0, 0, 5, 5);
        gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_16.gridx = 12;
        gbc_textField_16.gridy = 3;
        getContentPane().add(textField_16, gbc_textField_16);
        textField_16.setColumns(10);

        textField_17 = new JTextField();
        textField_17.setText("6");
        GridBagConstraints gbc_textField_17 = new GridBagConstraints();
        gbc_textField_17.insets = new Insets(0, 0, 5, 5);
        gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_17.gridx = 13;
        gbc_textField_17.gridy = 3;
        getContentPane().add(textField_17, gbc_textField_17);
        textField_17.setColumns(10);

        textField_18 = new JTextField();
        textField_18.setText("7");
        GridBagConstraints gbc_textField_18 = new GridBagConstraints();
        gbc_textField_18.insets = new Insets(0, 0, 5, 5);
        gbc_textField_18.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_18.gridx = 14;
        gbc_textField_18.gridy = 3;
        getContentPane().add(textField_18, gbc_textField_18);
        textField_18.setColumns(10);

        textField_20 = new JTextField();
        textField_20.setText("1");
        GridBagConstraints gbc_textField_20 = new GridBagConstraints();
        gbc_textField_20.insets = new Insets(0, 0, 5, 5);
        gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_20.gridx = 15;
        gbc_textField_20.gridy = 3;
        getContentPane().add(textField_20, gbc_textField_20);
        textField_20.setColumns(10);

        textField_21 = new JTextField();
        textField_21.setText("2");
        GridBagConstraints gbc_textField_21 = new GridBagConstraints();
        gbc_textField_21.insets = new Insets(0, 0, 5, 5);
        gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_21.gridx = 16;
        gbc_textField_21.gridy = 3;
        getContentPane().add(textField_21, gbc_textField_21);
        textField_21.setColumns(10);

        textField_22 = new JTextField();
        textField_22.setText("3");
        GridBagConstraints gbc_textField_22 = new GridBagConstraints();
        gbc_textField_22.insets = new Insets(0, 0, 5, 5);
        gbc_textField_22.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_22.gridx = 17;
        gbc_textField_22.gridy = 3;
        getContentPane().add(textField_22, gbc_textField_22);
        textField_22.setColumns(10);

        textField_23 = new JTextField();
        textField_23.setText("4");
        GridBagConstraints gbc_textField_23 = new GridBagConstraints();
        gbc_textField_23.insets = new Insets(0, 0, 5, 5);
        gbc_textField_23.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_23.gridx = 18;
        gbc_textField_23.gridy = 3;
        getContentPane().add(textField_23, gbc_textField_23);
        textField_23.setColumns(10);

        textField_24 = new JTextField();
        textField_24.setText("5");
        GridBagConstraints gbc_textField_24 = new GridBagConstraints();
        gbc_textField_24.insets = new Insets(0, 0, 5, 5);
        gbc_textField_24.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_24.gridx = 19;
        gbc_textField_24.gridy = 3;
        getContentPane().add(textField_24, gbc_textField_24);
        textField_24.setColumns(10);

        textField_25 = new JTextField();
        textField_25.setText("6");
        GridBagConstraints gbc_textField_25 = new GridBagConstraints();
        gbc_textField_25.insets = new Insets(0, 0, 5, 5);
        gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_25.gridx = 20;
        gbc_textField_25.gridy = 3;
        getContentPane().add(textField_25, gbc_textField_25);
        textField_25.setColumns(10);

        textField_19 = new JTextField();
        textField_19.setText("7");
        GridBagConstraints gbc_textField_19 = new GridBagConstraints();
        gbc_textField_19.insets = new Insets(0, 0, 5, 0);
        gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_19.gridx = 21;
        gbc_textField_19.gridy = 3;
        getContentPane().add(textField_19, gbc_textField_19);
        textField_19.setColumns(10);

        txtPointage = new JTextField();
        txtPointage.setText("Pointage");
        txtPointage.setColumns(10);
        GridBagConstraints gbc_txtPointage = new GridBagConstraints();
        gbc_txtPointage.insets = new Insets(0, 0, 5, 5);
        gbc_txtPointage.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPointage.gridx = 0;
        gbc_txtPointage.gridy = 4;
        getContentPane().add(txtPointage, gbc_txtPointage);

        P1B = new JTextField();
        P1B.setColumns(10);
        GridBagConstraints gbc_P1B = new GridBagConstraints();
        gbc_P1B.insets = new Insets(0, 0, 5, 5);
        gbc_P1B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P1B.gridx = 1;
        gbc_P1B.gridy = 4;
        getContentPane().add(P1B, gbc_P1B);

        P2B = new JTextField();
        P2B.setColumns(10);
        GridBagConstraints gbc_P2B = new GridBagConstraints();
        gbc_P2B.insets = new Insets(0, 0, 5, 5);
        gbc_P2B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P2B.gridx = 2;
        gbc_P2B.gridy = 4;
        getContentPane().add(P2B, gbc_P2B);

        P3B = new JTextField();
        P3B.setColumns(10);
        GridBagConstraints gbc_P3B = new GridBagConstraints();
        gbc_P3B.insets = new Insets(0, 0, 5, 5);
        gbc_P3B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P3B.gridx = 3;
        gbc_P3B.gridy = 4;
        getContentPane().add(P3B, gbc_P3B);

        P4B = new JTextField();
        P4B.setColumns(10);
        GridBagConstraints gbc_P4B = new GridBagConstraints();
        gbc_P4B.insets = new Insets(0, 0, 5, 5);
        gbc_P4B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P4B.gridx = 4;
        gbc_P4B.gridy = 4;
        getContentPane().add(P4B, gbc_P4B);

        P5B = new JTextField();
        P5B.setColumns(10);
        GridBagConstraints gbc_P5B = new GridBagConstraints();
        gbc_P5B.insets = new Insets(0, 0, 5, 5);
        gbc_P5B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P5B.gridx = 5;
        gbc_P5B.gridy = 4;
        getContentPane().add(P5B, gbc_P5B);

        P6B = new JTextField();
        P6B.setColumns(10);
        GridBagConstraints gbc_P6B = new GridBagConstraints();
        gbc_P6B.insets = new Insets(0, 0, 5, 5);
        gbc_P6B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P6B.gridx = 6;
        gbc_P6B.gridy = 4;
        getContentPane().add(P6B, gbc_P6B);

        P7B = new JTextField();
        P7B.setColumns(10);
        GridBagConstraints gbc_P7B = new GridBagConstraints();
        gbc_P7B.insets = new Insets(0, 0, 5, 5);
        gbc_P7B.fill = GridBagConstraints.HORIZONTAL;
        gbc_P7B.gridx = 7;
        gbc_P7B.gridy = 4;
        getContentPane().add(P7B, gbc_P7B);

        P1G = new JTextField();
        P1G.setColumns(10);
        GridBagConstraints gbc_P1G = new GridBagConstraints();
        gbc_P1G.insets = new Insets(0, 0, 5, 5);
        gbc_P1G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P1G.gridx = 8;
        gbc_P1G.gridy = 4;
        getContentPane().add(P1G, gbc_P1G);

        P2G = new JTextField();
        P2G.setColumns(10);
        GridBagConstraints gbc_P2G = new GridBagConstraints();
        gbc_P2G.insets = new Insets(0, 0, 5, 5);
        gbc_P2G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P2G.gridx = 9;
        gbc_P2G.gridy = 4;
        getContentPane().add(P2G, gbc_P2G);

        P3G = new JTextField();
        P3G.setColumns(10);
        GridBagConstraints gbc_P3G = new GridBagConstraints();
        gbc_P3G.insets = new Insets(0, 0, 5, 5);
        gbc_P3G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P3G.gridx = 10;
        gbc_P3G.gridy = 4;
        getContentPane().add(P3G, gbc_P3G);

        P4G = new JTextField();
        P4G.setColumns(10);
        GridBagConstraints gbc_P4G = new GridBagConstraints();
        gbc_P4G.insets = new Insets(0, 0, 5, 5);
        gbc_P4G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P4G.gridx = 11;
        gbc_P4G.gridy = 4;
        getContentPane().add(P4G, gbc_P4G);

        P5G = new JTextField();
        P5G.setColumns(10);
        GridBagConstraints gbc_P5G = new GridBagConstraints();
        gbc_P5G.insets = new Insets(0, 0, 5, 5);
        gbc_P5G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P5G.gridx = 12;
        gbc_P5G.gridy = 4;
        getContentPane().add(P5G, gbc_P5G);

        P6G = new JTextField();
        P6G.setColumns(10);
        GridBagConstraints gbc_P6G = new GridBagConstraints();
        gbc_P6G.insets = new Insets(0, 0, 5, 5);
        gbc_P6G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P6G.gridx = 13;
        gbc_P6G.gridy = 4;
        getContentPane().add(P6G, gbc_P6G);

        P7G = new JTextField();
        P7G.setColumns(10);
        GridBagConstraints gbc_P7G = new GridBagConstraints();
        gbc_P7G.insets = new Insets(0, 0, 5, 5);
        gbc_P7G.fill = GridBagConstraints.HORIZONTAL;
        gbc_P7G.gridx = 14;
        gbc_P7G.gridy = 4;
        getContentPane().add(P7G, gbc_P7G);

        P1N = new JTextField();
        P1N.setColumns(10);
        GridBagConstraints gbc_P1N = new GridBagConstraints();
        gbc_P1N.insets = new Insets(0, 0, 5, 5);
        gbc_P1N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P1N.gridx = 15;
        gbc_P1N.gridy = 4;
        getContentPane().add(P1N, gbc_P1N);

        P2N = new JTextField();
        P2N.setColumns(10);
        GridBagConstraints gbc_P2N = new GridBagConstraints();
        gbc_P2N.insets = new Insets(0, 0, 5, 5);
        gbc_P2N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P2N.gridx = 16;
        gbc_P2N.gridy = 4;
        getContentPane().add(P2N, gbc_P2N);

        P3N = new JTextField();
        P3N.setColumns(10);
        GridBagConstraints gbc_P3N = new GridBagConstraints();
        gbc_P3N.insets = new Insets(0, 0, 5, 5);
        gbc_P3N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P3N.gridx = 17;
        gbc_P3N.gridy = 4;
        getContentPane().add(P3N, gbc_P3N);

        P4N = new JTextField();
        P4N.setColumns(10);
        GridBagConstraints gbc_P4N = new GridBagConstraints();
        gbc_P4N.insets = new Insets(0, 0, 5, 5);
        gbc_P4N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P4N.gridx = 18;
        gbc_P4N.gridy = 4;
        getContentPane().add(P4N, gbc_P4N);

        P5N = new JTextField();
        P5N.setColumns(10);
        GridBagConstraints gbc_P5N = new GridBagConstraints();
        gbc_P5N.insets = new Insets(0, 0, 5, 5);
        gbc_P5N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P5N.gridx = 19;
        gbc_P5N.gridy = 4;
        getContentPane().add(P5N, gbc_P5N);

        P6N = new JTextField();
        P6N.setColumns(10);
        GridBagConstraints gbc_P6N = new GridBagConstraints();
        gbc_P6N.insets = new Insets(0, 0, 5, 5);
        gbc_P6N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P6N.gridx = 20;
        gbc_P6N.gridy = 4;
        getContentPane().add(P6N, gbc_P6N);

        P7N = new JTextField();
        P7N.setColumns(10);
        GridBagConstraints gbc_P7N = new GridBagConstraints();
        gbc_P7N.insets = new Insets(0, 0, 5, 0);
        gbc_P7N.fill = GridBagConstraints.HORIZONTAL;
        gbc_P7N.gridx = 21;
        gbc_P7N.gridy = 4;
        getContentPane().add(P7N, gbc_P7N);

        txtProlongation = new JTextField();
        txtProlongation.setText("Prolongation 1");
        txtProlongation.setColumns(10);
        GridBagConstraints gbc_txtProlongation = new GridBagConstraints();
        gbc_txtProlongation.insets = new Insets(0, 0, 5, 5);
        gbc_txtProlongation.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtProlongation.gridx = 0;
        gbc_txtProlongation.gridy = 5;
        getContentPane().add(txtProlongation, gbc_txtProlongation);

        prol1B = new JTextField();
        prol1B.setColumns(10);
        GridBagConstraints gbc_prol1B = new GridBagConstraints();
        gbc_prol1B.insets = new Insets(0, 0, 5, 5);
        gbc_prol1B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol1B.gridx = 1;
        gbc_prol1B.gridy = 5;
        getContentPane().add(prol1B, gbc_prol1B);

        prol2B = new JTextField();
        prol2B.setColumns(10);
        GridBagConstraints gbc_prol2B = new GridBagConstraints();
        gbc_prol2B.insets = new Insets(0, 0, 5, 5);
        gbc_prol2B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol2B.gridx = 2;
        gbc_prol2B.gridy = 5;
        getContentPane().add(prol2B, gbc_prol2B);

        prol3B = new JTextField();
        prol3B.setColumns(10);
        GridBagConstraints gbc_prol3B = new GridBagConstraints();
        gbc_prol3B.insets = new Insets(0, 0, 5, 5);
        gbc_prol3B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol3B.gridx = 3;
        gbc_prol3B.gridy = 5;
        getContentPane().add(prol3B, gbc_prol3B);

        prol4B = new JTextField();
        prol4B.setColumns(10);
        GridBagConstraints gbc_prol4B = new GridBagConstraints();
        gbc_prol4B.insets = new Insets(0, 0, 5, 5);
        gbc_prol4B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol4B.gridx = 4;
        gbc_prol4B.gridy = 5;
        getContentPane().add(prol4B, gbc_prol4B);

        prol5B = new JTextField();
        prol5B.setColumns(10);
        GridBagConstraints gbc_prol5B = new GridBagConstraints();
        gbc_prol5B.insets = new Insets(0, 0, 5, 5);
        gbc_prol5B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol5B.gridx = 5;
        gbc_prol5B.gridy = 5;
        getContentPane().add(prol5B, gbc_prol5B);

        prol6B = new JTextField();
        prol6B.setColumns(10);
        GridBagConstraints gbc_prol6B = new GridBagConstraints();
        gbc_prol6B.insets = new Insets(0, 0, 5, 5);
        gbc_prol6B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol6B.gridx = 6;
        gbc_prol6B.gridy = 5;
        getContentPane().add(prol6B, gbc_prol6B);

        prol7B = new JTextField();
        prol7B.setColumns(10);
        GridBagConstraints gbc_prol7B = new GridBagConstraints();
        gbc_prol7B.insets = new Insets(0, 0, 5, 5);
        gbc_prol7B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol7B.gridx = 7;
        gbc_prol7B.gridy = 5;
        getContentPane().add(prol7B, gbc_prol7B);

        prol1G = new JTextField();
        prol1G.setColumns(10);
        GridBagConstraints gbc_prol1G = new GridBagConstraints();
        gbc_prol1G.insets = new Insets(0, 0, 5, 5);
        gbc_prol1G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol1G.gridx = 8;
        gbc_prol1G.gridy = 5;
        getContentPane().add(prol1G, gbc_prol1G);

        prol2G = new JTextField();
        prol2G.setColumns(10);
        GridBagConstraints gbc_prol2G = new GridBagConstraints();
        gbc_prol2G.insets = new Insets(0, 0, 5, 5);
        gbc_prol2G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol2G.gridx = 9;
        gbc_prol2G.gridy = 5;
        getContentPane().add(prol2G, gbc_prol2G);

        prol3G = new JTextField();
        prol3G.setColumns(10);
        GridBagConstraints gbc_prol3G = new GridBagConstraints();
        gbc_prol3G.insets = new Insets(0, 0, 5, 5);
        gbc_prol3G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol3G.gridx = 10;
        gbc_prol3G.gridy = 5;
        getContentPane().add(prol3G, gbc_prol3G);

        prol4G = new JTextField();
        prol4G.setColumns(10);
        GridBagConstraints gbc_prol4G = new GridBagConstraints();
        gbc_prol4G.insets = new Insets(0, 0, 5, 5);
        gbc_prol4G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol4G.gridx = 11;
        gbc_prol4G.gridy = 5;
        getContentPane().add(prol4G, gbc_prol4G);

        prol5G = new JTextField();
        prol5G.setColumns(10);
        GridBagConstraints gbc_prol5G = new GridBagConstraints();
        gbc_prol5G.insets = new Insets(0, 0, 5, 5);
        gbc_prol5G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol5G.gridx = 12;
        gbc_prol5G.gridy = 5;
        getContentPane().add(prol5G, gbc_prol5G);

        prol6G = new JTextField();
        prol6G.setColumns(10);
        GridBagConstraints gbc_prol6G = new GridBagConstraints();
        gbc_prol6G.insets = new Insets(0, 0, 5, 5);
        gbc_prol6G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol6G.gridx = 13;
        gbc_prol6G.gridy = 5;
        getContentPane().add(prol6G, gbc_prol6G);

        prol7G = new JTextField();
        prol7G.setColumns(10);
        GridBagConstraints gbc_prol7G = new GridBagConstraints();
        gbc_prol7G.insets = new Insets(0, 0, 5, 5);
        gbc_prol7G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol7G.gridx = 14;
        gbc_prol7G.gridy = 5;
        getContentPane().add(prol7G, gbc_prol7G);

        prol1N = new JTextField();
        prol1N.setColumns(10);
        GridBagConstraints gbc_prol1N = new GridBagConstraints();
        gbc_prol1N.insets = new Insets(0, 0, 5, 5);
        gbc_prol1N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol1N.gridx = 15;
        gbc_prol1N.gridy = 5;
        getContentPane().add(prol1N, gbc_prol1N);

        prol2N = new JTextField();
        prol2N.setColumns(10);
        GridBagConstraints gbc_prol2N = new GridBagConstraints();
        gbc_prol2N.insets = new Insets(0, 0, 5, 5);
        gbc_prol2N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol2N.gridx = 16;
        gbc_prol2N.gridy = 5;
        getContentPane().add(prol2N, gbc_prol2N);

        prol3N = new JTextField();
        prol3N.setColumns(10);
        GridBagConstraints gbc_prol3N = new GridBagConstraints();
        gbc_prol3N.insets = new Insets(0, 0, 5, 5);
        gbc_prol3N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol3N.gridx = 17;
        gbc_prol3N.gridy = 5;
        getContentPane().add(prol3N, gbc_prol3N);

        prol4N = new JTextField();
        prol4N.setColumns(10);
        GridBagConstraints gbc_prol4N = new GridBagConstraints();
        gbc_prol4N.insets = new Insets(0, 0, 5, 5);
        gbc_prol4N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol4N.gridx = 18;
        gbc_prol4N.gridy = 5;
        getContentPane().add(prol4N, gbc_prol4N);

        prol5N = new JTextField();
        prol5N.setColumns(10);
        GridBagConstraints gbc_prol5N = new GridBagConstraints();
        gbc_prol5N.insets = new Insets(0, 0, 5, 5);
        gbc_prol5N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol5N.gridx = 19;
        gbc_prol5N.gridy = 5;
        getContentPane().add(prol5N, gbc_prol5N);

        prol6N = new JTextField();
        prol6N.setColumns(10);
        GridBagConstraints gbc_prol6N = new GridBagConstraints();
        gbc_prol6N.insets = new Insets(0, 0, 5, 5);
        gbc_prol6N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol6N.gridx = 20;
        gbc_prol6N.gridy = 5;
        getContentPane().add(prol6N, gbc_prol6N);

        prol7N = new JTextField();
        prol7N.setColumns(10);
        GridBagConstraints gbc_prol7N = new GridBagConstraints();
        gbc_prol7N.insets = new Insets(0, 0, 5, 0);
        gbc_prol7N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol7N.gridx = 21;
        gbc_prol7N.gridy = 5;
        getContentPane().add(prol7N, gbc_prol7N);

        txtPriodesGagns = new JTextField();
        txtPriodesGagns.setText("P\u00E9riodes gagn\u00E9es");
        txtPriodesGagns.setColumns(10);
        GridBagConstraints gbc_txtPriodesGagns = new GridBagConstraints();
        gbc_txtPriodesGagns.insets = new Insets(0, 0, 5, 5);
        gbc_txtPriodesGagns.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPriodesGagns.gridx = 0;
        gbc_txtPriodesGagns.gridy = 6;
        getContentPane().add(txtPriodesGagns, gbc_txtPriodesGagns);

        periodeGagneeBleu = new JTextField();
        periodeGagneeBleu.setColumns(10);
        GridBagConstraints gbc_periodeGagneeBleu = new GridBagConstraints();
        gbc_periodeGagneeBleu.gridwidth = 7;
        gbc_periodeGagneeBleu.insets = new Insets(0, 0, 5, 5);
        gbc_periodeGagneeBleu.fill = GridBagConstraints.HORIZONTAL;
        gbc_periodeGagneeBleu.gridx = 1;
        gbc_periodeGagneeBleu.gridy = 6;
        getContentPane().add(periodeGagneeBleu, gbc_periodeGagneeBleu);

        periodeGagneeGris = new JTextField();
        periodeGagneeGris.setColumns(10);
        GridBagConstraints gbc_periodeGagneeGris = new GridBagConstraints();
        gbc_periodeGagneeGris.gridwidth = 7;
        gbc_periodeGagneeGris.insets = new Insets(0, 0, 5, 5);
        gbc_periodeGagneeGris.fill = GridBagConstraints.HORIZONTAL;
        gbc_periodeGagneeGris.gridx = 8;
        gbc_periodeGagneeGris.gridy = 6;
        getContentPane().add(periodeGagneeGris, gbc_periodeGagneeGris);

        periodeGagneeNoir = new JTextField();
        periodeGagneeNoir.setColumns(10);
        GridBagConstraints gbc_periodeGagneeNoir = new GridBagConstraints();
        gbc_periodeGagneeNoir.gridwidth = 7;
        gbc_periodeGagneeNoir.insets = new Insets(0, 0, 5, 0);
        gbc_periodeGagneeNoir.fill = GridBagConstraints.HORIZONTAL;
        gbc_periodeGagneeNoir.gridx = 15;
        gbc_periodeGagneeNoir.gridy = 6;
        getContentPane().add(periodeGagneeNoir, gbc_periodeGagneeNoir);

        Prolong2emePlace = new JTextField();
        Prolong2emePlace.setText("Prolongation 2\u00E8me place");
        Prolong2emePlace.setColumns(10);
        GridBagConstraints gbc_Prolong2emePlace = new GridBagConstraints();
        gbc_Prolong2emePlace.insets = new Insets(0, 0, 5, 5);
        gbc_Prolong2emePlace.fill = GridBagConstraints.HORIZONTAL;
        gbc_Prolong2emePlace.gridx = 0;
        gbc_Prolong2emePlace.gridy = 7;
        getContentPane().add(Prolong2emePlace, gbc_Prolong2emePlace);

        prol22B = new JTextField();
        prol22B.setColumns(10);
        GridBagConstraints gbc_prol22B = new GridBagConstraints();
        gbc_prol22B.gridwidth = 7;
        gbc_prol22B.insets = new Insets(0, 0, 5, 5);
        gbc_prol22B.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol22B.gridx = 1;
        gbc_prol22B.gridy = 7;
        getContentPane().add(prol22B, gbc_prol22B);

        prol22G = new JTextField();
        prol22G.setColumns(10);
        GridBagConstraints gbc_prol22G = new GridBagConstraints();
        gbc_prol22G.gridwidth = 7;
        gbc_prol22G.insets = new Insets(0, 0, 5, 5);
        gbc_prol22G.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol22G.gridx = 8;
        gbc_prol22G.gridy = 7;
        getContentPane().add(prol22G, gbc_prol22G);

        prol22N = new JTextField();
        prol22N.setColumns(10);
        GridBagConstraints gbc_prol22N = new GridBagConstraints();
        gbc_prol22N.gridwidth = 7;
        gbc_prol22N.insets = new Insets(0, 0, 5, 0);
        gbc_prol22N.fill = GridBagConstraints.HORIZONTAL;
        gbc_prol22N.gridx = 15;
        gbc_prol22N.gridy = 7;
        getContentPane().add(prol22N, gbc_prol22N);

        txtEspritSportif = new JTextField();
        txtEspritSportif.setText("Esprit sportif");
        GridBagConstraints gbc_txtEspritSportif = new GridBagConstraints();
        gbc_txtEspritSportif.insets = new Insets(0, 0, 5, 5);
        gbc_txtEspritSportif.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEspritSportif.gridx = 0;
        gbc_txtEspritSportif.gridy = 8;
        getContentPane().add(txtEspritSportif, gbc_txtEspritSportif);
        txtEspritSportif.setColumns(10);

        espritSportifBleu = new JTextField();
        espritSportifBleu.setText("5");
        espritSportifBleu.setColumns(10);
        GridBagConstraints gbc_espritSportifBleu = new GridBagConstraints();
        gbc_espritSportifBleu.gridwidth = 7;
        gbc_espritSportifBleu.insets = new Insets(0, 0, 5, 5);
        gbc_espritSportifBleu.fill = GridBagConstraints.HORIZONTAL;
        gbc_espritSportifBleu.gridx = 1;
        gbc_espritSportifBleu.gridy = 8;
        getContentPane().add(espritSportifBleu, gbc_espritSportifBleu);

        espritSportifGris = new JTextField();
        espritSportifGris.setText("5");
        espritSportifGris.setColumns(10);
        GridBagConstraints gbc_espritSportifGris = new GridBagConstraints();
        gbc_espritSportifGris.gridwidth = 7;
        gbc_espritSportifGris.insets = new Insets(0, 0, 5, 5);
        gbc_espritSportifGris.fill = GridBagConstraints.HORIZONTAL;
        gbc_espritSportifGris.gridx = 8;
        gbc_espritSportifGris.gridy = 8;
        getContentPane().add(espritSportifGris, gbc_espritSportifGris);

        espritSportifNoir = new JTextField();
        espritSportifNoir.setText("5");
        espritSportifNoir.setColumns(10);
        GridBagConstraints gbc_espritSportifNoir = new GridBagConstraints();
        gbc_espritSportifNoir.gridwidth = 7;
        gbc_espritSportifNoir.insets = new Insets(0, 0, 5, 0);
        gbc_espritSportifNoir.fill = GridBagConstraints.HORIZONTAL;
        gbc_espritSportifNoir.gridx = 15;
        gbc_espritSportifNoir.gridy = 8;
        getContentPane().add(espritSportifNoir, gbc_espritSportifNoir);

        txtPointsChampionnats = new JTextField();
        txtPointsChampionnats.setText("Points championnats");
        GridBagConstraints gbc_txtPointsChampionnats = new GridBagConstraints();
        gbc_txtPointsChampionnats.insets = new Insets(0, 0, 5, 5);
        gbc_txtPointsChampionnats.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPointsChampionnats.gridx = 0;
        gbc_txtPointsChampionnats.gridy = 9;
        getContentPane().add(txtPointsChampionnats, gbc_txtPointsChampionnats);
        txtPointsChampionnats.setColumns(10);

        pointBleu = new JTextField();
        pointBleu.setColumns(10);
        GridBagConstraints gbc_pointBleu = new GridBagConstraints();
        gbc_pointBleu.gridwidth = 7;
        gbc_pointBleu.insets = new Insets(0, 0, 5, 5);
        gbc_pointBleu.fill = GridBagConstraints.HORIZONTAL;
        gbc_pointBleu.gridx = 1;
        gbc_pointBleu.gridy = 9;
        getContentPane().add(pointBleu, gbc_pointBleu);

        pointGris = new JTextField();
        pointGris.setColumns(10);
        GridBagConstraints gbc_pointGris = new GridBagConstraints();
        gbc_pointGris.insets = new Insets(0, 0, 5, 5);
        gbc_pointGris.gridwidth = 7;
        gbc_pointGris.fill = GridBagConstraints.HORIZONTAL;
        gbc_pointGris.gridx = 8;
        gbc_pointGris.gridy = 9;
        getContentPane().add(pointGris, gbc_pointGris);

        pointNoir = new JTextField();
        pointNoir.setColumns(10);
        GridBagConstraints gbc_pointNoir = new GridBagConstraints();
        gbc_pointNoir.gridwidth = 7;
        gbc_pointNoir.insets = new Insets(0, 0, 5, 0);
        gbc_pointNoir.fill = GridBagConstraints.HORIZONTAL;
        gbc_pointNoir.gridx = 15;
        gbc_pointNoir.gridy = 9;
        getContentPane().add(pointNoir, gbc_pointNoir);

        lblNewLabel_1 = new JLabel("Arbitre en Chef");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 10;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

        arbitreChef = new JTextField();
        arbitreChef.setColumns(10);
        GridBagConstraints gbc_arbitreChef = new GridBagConstraints();
        gbc_arbitreChef.gridwidth = 6;
        gbc_arbitreChef.insets = new Insets(0, 0, 5, 5);
        gbc_arbitreChef.fill = GridBagConstraints.HORIZONTAL;
        gbc_arbitreChef.gridx = 1;
        gbc_arbitreChef.gridy = 10;
        getContentPane().add(arbitreChef, gbc_arbitreChef);

        lblArbitreAdjoint = new JLabel("Arbitre adjoint");
        GridBagConstraints gbc_lblArbitreAdjoint = new GridBagConstraints();
        gbc_lblArbitreAdjoint.insets = new Insets(0, 0, 5, 5);
        gbc_lblArbitreAdjoint.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblArbitreAdjoint.gridx = 0;
        gbc_lblArbitreAdjoint.gridy = 11;
        getContentPane().add(lblArbitreAdjoint, gbc_lblArbitreAdjoint);

        arbitreAdjoint = new JTextField();
        GridBagConstraints gbc_arbitreAdjoint = new GridBagConstraints();
        gbc_arbitreAdjoint.gridwidth = 6;
        gbc_arbitreAdjoint.anchor = GridBagConstraints.NORTH;
        gbc_arbitreAdjoint.insets = new Insets(0, 0, 5, 5);
        gbc_arbitreAdjoint.fill = GridBagConstraints.HORIZONTAL;
        gbc_arbitreAdjoint.gridx = 1;
        gbc_arbitreAdjoint.gridy = 11;
        getContentPane().add(arbitreAdjoint, gbc_arbitreAdjoint);
        arbitreAdjoint.setColumns(10);

        btnLoadDb = new JButton("Load DB");
        GridBagConstraints gbc_btnLoadDb = new GridBagConstraints();
        gbc_btnLoadDb.anchor = GridBagConstraints.EAST;
        gbc_btnLoadDb.gridwidth = 5;
        gbc_btnLoadDb.insets = new Insets(0, 0, 5, 5);
        gbc_btnLoadDb.gridx = 8;
        gbc_btnLoadDb.gridy = 11;
        getContentPane().add(btnLoadDb, gbc_btnLoadDb);

        btnSaveDb = new JButton("Save DB");
        btnSaveDb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                saveDB();
            }
        });
        GridBagConstraints gbc_btnSaveDb = new GridBagConstraints();
        gbc_btnSaveDb.anchor = GridBagConstraints.WEST;
        gbc_btnSaveDb.gridwidth = 6;
        gbc_btnSaveDb.insets = new Insets(0, 0, 5, 5);
        gbc_btnSaveDb.gridx = 15;
        gbc_btnSaveDb.gridy = 11;
        getContentPane().add(btnSaveDb, gbc_btnSaveDb);

        btnNewButton = new JButton("Generate HTML");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridwidth = 8;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 7;
        gbc_btnNewButton.gridy = 12;
        getContentPane().add(btnNewButton, gbc_btnNewButton);

        clearAll = new JButton("Clear all");
        GridBagConstraints gbc_clearAll = new GridBagConstraints();
        gbc_clearAll.gridwidth = 5;
        gbc_clearAll.insets = new Insets(0, 0, 0, 5);
        gbc_clearAll.gridx = 15;
        gbc_clearAll.gridy = 12;
        getContentPane().add(clearAll, gbc_clearAll);
        this.setVisible(true);

        btnNewButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                if(idMatch.getText().equals(""))
                {

                    System.out.println("id match is missing");
                }
                else
                {
                    generateHTML();
                }

            }
        });

        clearAll.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                clearAll();
            }
        });

        // listeTxtFields =
        // {P1B,P2B,P3B,P4B,P5B,P6B,P7B,P1N,P2N,P3N,P4N,P5N,P6N,P7N,P1G,P2G,P3G,P4G,P5G,P6G,P7G};
    }

    public void generateHTML()
    {
        StringBuilder html = new StringBuilder();

        html.append("<input id=\"buttonMatch" + idMatch.getText() + "\" src=\" " + PLUS_SRC
            + "\" type=\"image\" onclick=\"toggleVisibility('Match" + idMatch.getText() + "');\">" + RN);

        html.append("<div id=\"Match" + idMatch.getText() + "Plus\" style=\"visibility: visible; display: block;\">"
            + RN);
        html.append("Détail du match<br><br>" + RN);
        html.append("<table class=\"tableau_match\" cellspacing=\"0\">" + RN);
        html.append("<tbody><tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Match #" + idMatch.getText() + "</td>" + RN);

        html.append("<td colspan=\"7\" class=\"bleu\">" + equipeBleu.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"gris\">" + equipeGris.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"noir\">" + EquipeNoir.getText() + "</td>" + RN);
        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Périodes gagnées</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeBleu.getText() + "</td>" + RN);
        }
        else
        {
            html.append("<td colspan=\"7\"> Forfait </td>" + RN);
        }

        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeGris.getText() + "</td>" + RN);
        }
        else
        {
            html.append("<td colspan=\"7\"> Forfait </td>" + RN);
        }

        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeNoir.getText() + "</td>" + RN);
        }
        else
        {
            html.append("<td colspan=\"7\"> Forfait </td>" + RN);
        }
        html.append("</tr>" + RN);
        html.append("</tbody></table>" + RN);
        html.append("</div>" + RN);

        html.append("<div id=\"Match" + idMatch.getText() + "Moins\" style=\"display: none;\">" + RN);
        // html.append("<input src=\" " + MOINS_SRC +
        // "\" type=\"image\" onclick=\"toggleVisibility('match" +
        // idMatch.getText() + "');\">" + RN);
        html.append("Réduire le détail du match" + RN);
        html.append("<br><br>" + RN);

        html.append("<table class=\"tableau_match\" cellspacing=\"0\">" + RN);
        html.append("<tbody><tr>" + RN);
        html.append("<td class=\"premiere_colonne\">" + match.getText() + " #" + idMatch.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"bleu\">" + equipeBleu.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"gris\">" + equipeGris.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"noir\">" + EquipeNoir.getText() + "</td>" + RN);
        html.append("</tr> " + RN);
        html.append("<tr> " + RN);
        html.append("<td class=\"premiere_colonne\">Période</td>" + RN);

        if(forfaitBleu.isSelected())
        {
            html.append("<td class=\"p1\" rowspan=\"7\" colspan=\"7\">Forfait</td>" + RN);
        }
        else
        {
            html.append("<td>1</td>" + RN);
            html.append("<td>2</td>" + RN);
            html.append("<td>3</td>" + RN);
            html.append("<td>4</td>" + RN);
            html.append("<td>5</td>" + RN);
            html.append("<td>6</td>" + RN);
            html.append("<td>7</td>" + RN);
        }

        if(forfaitGris.isSelected())
        {
            html.append("<td class=\"p1\" rowspan=\"7\" colspan=\"7\">Forfait</td>" + RN);
        }
        else
        {
            html.append("<td>1</td>" + RN);
            html.append("<td>2</td>" + RN);
            html.append("<td>3</td>" + RN);
            html.append("<td>4</td>" + RN);
            html.append("<td>5</td>" + RN);
            html.append("<td>6</td>" + RN);
            html.append("<td>7</td>" + RN);
        }

        if(forfaitNoir.isSelected())
        {
            html.append("<td class=\"p1\" rowspan=\"7\" colspan=\"7\">Forfait</td>" + RN);
        }
        else
        {
            html.append("<td>1</td>" + RN);
            html.append("<td>2</td>" + RN);
            html.append("<td>3</td>" + RN);
            html.append("<td>4</td>" + RN);
            html.append("<td>5</td>" + RN);
            html.append("<td>6</td>" + RN);
            html.append("<td>7</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);

        html.append("<td class=\"premiere_colonne\">Pointage</td>" + RN);

        // périodes Bleu
        if(!forfaitBleu.isSelected())
        {
            html.append("<td>" + P1B.getText() + "</td>" + RN);
            html.append("<td>" + P2B.getText() + "</td>" + RN);
            html.append("<td>" + P3B.getText() + "</td>" + RN);
            html.append("<td>" + P4B.getText() + "</td>" + RN);
            html.append("<td>" + P5B.getText() + "</td>" + RN);
            html.append("<td>" + P6B.getText() + "</td>" + RN);
            html.append("<td>" + P7B.getText() + "</td>" + RN);
        }

        // Période Gris
        if(!forfaitGris.isSelected())
        {
            html.append("<td>" + P1G.getText() + "</td>" + RN);
            html.append("<td>" + P2G.getText() + "</td>" + RN);
            html.append("<td>" + P3G.getText() + "</td>" + RN);
            html.append("<td>" + P4G.getText() + "</td>" + RN);
            html.append("<td>" + P5G.getText() + "</td>" + RN);
            html.append("<td>" + P6G.getText() + "</td>" + RN);
            html.append("<td>" + P7G.getText() + "</td>" + RN);
        }

        // Période noir
        if(!forfaitNoir.isSelected())
        {
            html.append("<td>" + P1N.getText() + "</td>" + RN);
            html.append("<td>" + P2N.getText() + "</td>" + RN);
            html.append("<td>" + P3N.getText() + "</td>" + RN);
            html.append("<td>" + P4N.getText() + "</td>" + RN);
            html.append("<td>" + P5N.getText() + "</td>" + RN);
            html.append("<td>" + P6N.getText() + "</td>" + RN);
            html.append("<td>" + P7N.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Prolongation 1</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td>" + prol1B.getText() + "</td>" + RN);
            html.append("<td>" + prol2B.getText() + "</td>" + RN);
            html.append("<td>" + prol3B.getText() + "</td>" + RN);
            html.append("<td>" + prol4B.getText() + "</td>" + RN);
            html.append("<td>" + prol5B.getText() + "</td>" + RN);
            html.append("<td>" + prol6B.getText() + "</td>" + RN);
            html.append("<td>" + prol7B.getText() + "</td>" + RN);
        }

        if(!forfaitGris.isSelected())
        {
            html.append("<td>" + prol1G.getText() + "</td>" + RN);
            html.append("<td>" + prol2G.getText() + "</td>" + RN);
            html.append("<td>" + prol3G.getText() + "</td>" + RN);
            html.append("<td>" + prol4G.getText() + "</td>" + RN);
            html.append("<td>" + prol5G.getText() + "</td>" + RN);
            html.append("<td>" + prol6G.getText() + "</td>" + RN);
            html.append("<td>" + prol7G.getText() + "</td>" + RN);
        }

        if(!forfaitNoir.isSelected())
        {
            html.append("<td>" + prol1N.getText() + "</td>" + RN);
            html.append("<td>" + prol2N.getText() + "</td>" + RN);
            html.append("<td>" + prol3N.getText() + "</td>" + RN);
            html.append("<td>" + prol4N.getText() + "</td>" + RN);
            html.append("<td>" + prol5N.getText() + "</td>" + RN);
            html.append("<td>" + prol6N.getText() + "</td>" + RN);
            html.append("<td>" + prol7N.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Périodes gagnées</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeBleu.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeGris.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeNoir.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Prolongation 2ème position</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + prol22B.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + prol22G.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + prol22N.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Esprit sportif</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + espritSportifBleu.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + espritSportifGris.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + espritSportifNoir.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Points championnats</td>" + RN);
        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + pointBleu.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + pointGris.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + pointNoir.getText() + "</td>" + RN);
        }

        html.append(" </tr>" + RN);
        html.append("</tbody>" + RN);
        html.append("</table>" + RN);

        html.append("<strong>Arbitres</strong> : " + arbitreChef.getText() + " & " + arbitreAdjoint.getText() + RN);

        html.append("</div>" + RN);

        System.out.println(html);

        writeToFile(idMatch.getText(), html);

    }

    private void writeToFile(String idMatch, StringBuilder html)
    {
        FileOutputStream fop = null;
        File file;

        try
        {

            file = new File("c:/resultats/" + idMatch + ".html");
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

    private void clearAll()
    {
        P1B.setText("");
        P2B.setText("");
        P3B.setText("");
        P4B.setText("");
        P5B.setText("");
        P6B.setText("");
        P7B.setText("");
        prol1B.setText("");
        prol2B.setText("");
        prol3B.setText("");
        prol4B.setText("");
        prol5B.setText("");
        prol6B.setText("");
        prol7B.setText("");
        prol1N.setText("");
        P1N.setText("");
        P2N.setText("");
        prol2N.setText("");
        P3N.setText("");
        prol3N.setText("");
        P4N.setText("");
        prol4N.setText("");
        P5N.setText("");
        prol5N.setText("");
        P6N.setText("");
        prol6N.setText("");
        P7N.setText("");
        prol7N.setText("");
        P1G.setText("");
        prol1G.setText("");
        P2G.setText("");
        prol2G.setText("");
        P3G.setText("");
        prol3G.setText("");
        P4G.setText("");
        prol4G.setText("");
        P5G.setText("");
        prol5G.setText("");
        P6G.setText("");
        prol6G.setText("");
        P7G.setText("");
        prol7G.setText("");
        prol22B.setText("");
        periodeGagneeBleu.setText("");
        espritSportifBleu.setText("5");
        pointBleu.setText("");
        prol22N.setText("");
        periodeGagneeNoir.setText("");
        espritSportifNoir.setText("5");
        pointNoir.setText("");
        prol22G.setText("");
        periodeGagneeGris.setText("");
        espritSportifGris.setText("5");
        pointGris.setText("");
        idMatch.setText("");
        arbitreAdjoint.setText("");
        arbitreChef.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");

        equipeBleu.setText("");
        equipeGris.setText("");
        EquipeNoir.setText("");

        forfaitBleu.setSelected(false);
        forfaitGris.setSelected(false);
        forfaitNoir.setSelected(false);
    }

    public static void main(String[] args)
    {
        new FeuilleDeMatchGenerator();
    }

    private void saveDB()
    {

        Equipe bleu =
            new Equipe("bleu", equipeBleu.getText(), forfaitBleu.isSelected(), P1B.getText(), P2B.getText(),
                P3B.getText(), P4B.getText(), P5B.getText(), P6B.getText(), P7B.getText(), prol1B.getText(),
                prol2B.getText(), prol3B.getText(), prol4B.getText(), prol5B.getText(), prol6B.getText(),
                prol7B.getText(), prol22B.getText(), periodeGagneeBleu.getText(), espritSportifBleu.getText(),
                pointBleu.getText());

        Equipe noir =
            new Equipe("noir", EquipeNoir.getText(), forfaitNoir.isSelected(), P1N.getText(), P2N.getText(),
                P3N.getText(), P4N.getText(), P5N.getText(), P6N.getText(), P7N.getText(), prol1N.getText(),
                prol2N.getText(), prol3N.getText(), prol4N.getText(), prol5N.getText(), prol6N.getText(),
                prol7N.getText(), prol22N.getText(), periodeGagneeNoir.getText(), espritSportifNoir.getText(),
                pointNoir.getText());

        Equipe gris =
            new Equipe("gris", equipeGris.getText(), forfaitGris.isSelected(), P1G.getText(), P2G.getText(),
                P3G.getText(), P4G.getText(), P5G.getText(), P6G.getText(), P7G.getText(), prol1G.getText(),
                prol2G.getText(), prol3G.getText(), prol4G.getText(), prol5G.getText(), prol6G.getText(),
                prol7G.getText(), prol22G.getText(), periodeGagneeGris.getText(), espritSportifGris.getText(),
                pointGris.getText());

        Match match = new Match(idMatch.getText(), bleu, gris, noir, arbitreChef.getText(), arbitreAdjoint.getText());

        new MatchDAO().save(match, this.createHtml(match));
    }

    // FIXME Peut etre ds bug comparer avec le generateHTML
    private StringBuilder createHtml(Match match)
    {

        Equipe bleu = match.getBleu();
        Equipe gris = match.getGris();
        Equipe noir = match.getNoir();

        StringBuilder html = new StringBuilder();

        html.append("<input id=\"buttonMatch" + match.getIdMatch() + "\" src=\" " + PLUS_SRC
            + "\" type=\"image\" onclick=\"toggleVisibility('Match" + match.getIdMatch() + "');\">" + RN);

        html.append("<div id=\"Match" + match.getIdMatch() + "Plus\" style=\"visibility: visible; display: block;\">"
            + RN);
        html.append("Détail du match<br><br>" + RN);
        html.append("<table class=\"tableau_match\" cellspacing=\"0\">" + RN);
        html.append("<tbody><tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Match #" + match.getIdMatch() + "</td>" + RN);

        html.append("<td colspan=\"7\" class=\"bleu\">" + bleu.getNomEquipe() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"gris\">" + gris.getNomEquipe() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"noir\">" + noir.getNomEquipe() + "</td>" + RN);
        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Périodes gagnées</td>" + RN);

        if(!bleu.isForfait())
        {
            html.append("<td colspan=\"7\">" + bleu.getNb_periode() + "</td>" + RN);
        }
        else
        {
            html.append("<td colspan=\"7\"> Forfait </td>" + RN);
        }

        if(!gris.isForfait())
        {
            html.append("<td colspan=\"7\">" + gris.getNb_periode() + "</td>" + RN);
        }
        else
        {
            html.append("<td colspan=\"7\"> Forfait </td>" + RN);
        }

        if(!noir.isForfait())
        {
            html.append("<td colspan=\"7\">" + noir.getNb_periode() + "</td>" + RN);
        }
        else
        {
            html.append("<td colspan=\"7\"> Forfait </td>" + RN);
        }
        html.append("</tr>" + RN);
        html.append("</tbody></table>" + RN);
        html.append("</div>" + RN);

        html.append("<div id=\"Match" + match.getIdMatch() + "Moins\" style=\"display: none;\">" + RN);

        html.append("Réduire le détail du match" + RN);
        html.append("<br><br>" + RN);

        html.append("<table class=\"tableau_match\" cellspacing=\"0\">" + RN);
        html.append("<tbody><tr>" + RN);
        html.append("<td class=\"premiere_colonne\"> Match #" + idMatch.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"bleu\">" + equipeBleu.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"gris\">" + equipeGris.getText() + "</td>" + RN);
        html.append("<td colspan=\"7\" class=\"noir\">" + EquipeNoir.getText() + "</td>" + RN);
        html.append("</tr> " + RN);
        html.append("<tr> " + RN);
        html.append("<td class=\"premiere_colonne\">Période</td>" + RN);

        if(forfaitBleu.isSelected())
        {
            html.append("<td class=\"p1\" rowspan=\"7\" colspan=\"7\">Forfait</td>" + RN);
        }

        if(forfaitGris.isSelected())
        {
            html.append("<td class=\"p1\" rowspan=\"7\" colspan=\"7\">Forfait</td>" + RN);
        }

        if(forfaitNoir.isSelected())
        {
            html.append("<td class=\"p1\" rowspan=\"7\" colspan=\"7\">Forfait</td>" + RN);
        }

        if(!forfaitBleu.isSelected())
        {
            html.append("<td>1</td>" + RN);
            html.append("<td>2</td>" + RN);
            html.append("<td>3</td>" + RN);
            html.append("<td>4</td>" + RN);
            html.append("<td>5</td>" + RN);
            html.append("<td>6</td>" + RN);
            html.append("<td>7</td>" + RN);
        }

        if(!forfaitGris.isSelected())
        {
            html.append("<td>1</td>" + RN);
            html.append("<td>2</td>" + RN);
            html.append("<td>3</td>" + RN);
            html.append("<td>4</td>" + RN);
            html.append("<td>5</td>" + RN);
            html.append("<td>6</td>" + RN);
            html.append("<td>7</td>" + RN);
        }

        if(!forfaitNoir.isSelected())
        {
            html.append("<td>1</td>" + RN);
            html.append("<td>2</td>" + RN);
            html.append("<td>3</td>" + RN);
            html.append("<td>4</td>" + RN);
            html.append("<td>5</td>" + RN);
            html.append("<td>6</td>" + RN);
            html.append("<td>7</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);

        html.append("<td class=\"premiere_colonne\">Pointage</td>" + RN);

        // périodes Bleu
        if(!forfaitBleu.isSelected())
        {
            html.append("<td>" + P1B.getText() + "</td>" + RN);
            html.append("<td>" + P2B.getText() + "</td>" + RN);
            html.append("<td>" + P3B.getText() + "</td>" + RN);
            html.append("<td>" + P4B.getText() + "</td>" + RN);
            html.append("<td>" + P5B.getText() + "</td>" + RN);
            html.append("<td>" + P6B.getText() + "</td>" + RN);
            html.append("<td>" + P7B.getText() + "</td>" + RN);
        }

        // Période Gris
        if(!forfaitGris.isSelected())
        {
            html.append("<td>" + P1G.getText() + "</td>" + RN);
            html.append("<td>" + P2G.getText() + "</td>" + RN);
            html.append("<td>" + P3G.getText() + "</td>" + RN);
            html.append("<td>" + P4G.getText() + "</td>" + RN);
            html.append("<td>" + P5G.getText() + "</td>" + RN);
            html.append("<td>" + P6G.getText() + "</td>" + RN);
            html.append("<td>" + P7G.getText() + "</td>" + RN);
        }

        // Période noir
        if(!forfaitNoir.isSelected())
        {
            html.append("<td>" + P1N.getText() + "</td>" + RN);
            html.append("<td>" + P2N.getText() + "</td>" + RN);
            html.append("<td>" + P3N.getText() + "</td>" + RN);
            html.append("<td>" + P4N.getText() + "</td>" + RN);
            html.append("<td>" + P5N.getText() + "</td>" + RN);
            html.append("<td>" + P6N.getText() + "</td>" + RN);
            html.append("<td>" + P7N.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Prolongation 1</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td>" + prol1B.getText() + "</td>" + RN);
            html.append("<td>" + prol2B.getText() + "</td>" + RN);
            html.append("<td>" + prol3B.getText() + "</td>" + RN);
            html.append("<td>" + prol4B.getText() + "</td>" + RN);
            html.append("<td>" + prol5B.getText() + "</td>" + RN);
            html.append("<td>" + prol6B.getText() + "</td>" + RN);
            html.append("<td>" + prol7B.getText() + "</td>" + RN);
        }

        if(!forfaitGris.isSelected())
        {
            html.append("<td>" + prol1G.getText() + "</td>" + RN);
            html.append("<td>" + prol2G.getText() + "</td>" + RN);
            html.append("<td>" + prol3G.getText() + "</td>" + RN);
            html.append("<td>" + prol4G.getText() + "</td>" + RN);
            html.append("<td>" + prol5G.getText() + "</td>" + RN);
            html.append("<td>" + prol6G.getText() + "</td>" + RN);
            html.append("<td>" + prol7G.getText() + "</td>" + RN);
        }

        if(!forfaitNoir.isSelected())
        {
            html.append("<td>" + prol1N.getText() + "</td>" + RN);
            html.append("<td>" + prol2N.getText() + "</td>" + RN);
            html.append("<td>" + prol3N.getText() + "</td>" + RN);
            html.append("<td>" + prol4N.getText() + "</td>" + RN);
            html.append("<td>" + prol5N.getText() + "</td>" + RN);
            html.append("<td>" + prol6N.getText() + "</td>" + RN);
            html.append("<td>" + prol7N.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Périodes gagnées</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeBleu.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeGris.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + periodeGagneeNoir.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Prolongation 2ème position</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + prol22B.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + prol22G.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + prol22N.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Esprit sportif</td>" + RN);

        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + espritSportifBleu.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + espritSportifGris.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + espritSportifNoir.getText() + "</td>" + RN);
        }

        html.append("</tr>" + RN);
        html.append("<tr>" + RN);
        html.append("<td class=\"premiere_colonne\">Points championnats</td>" + RN);
        if(!forfaitBleu.isSelected())
        {
            html.append("<td colspan=\"7\">" + pointBleu.getText() + "</td>" + RN);
        }
        if(!forfaitGris.isSelected())
        {
            html.append("<td colspan=\"7\">" + pointGris.getText() + "</td>" + RN);
        }
        if(!forfaitNoir.isSelected())
        {
            html.append("<td colspan=\"7\">" + pointNoir.getText() + "</td>" + RN);
        }

        html.append(" </tr>" + RN);
        html.append("</tbody>" + RN);
        html.append("</table>" + RN);

        html.append("<strong>Arbitres</strong> : " + arbitreChef.getText() + " & " + arbitreAdjoint.getText() + RN);

        return html.append("</div>" + RN);
    }
}
