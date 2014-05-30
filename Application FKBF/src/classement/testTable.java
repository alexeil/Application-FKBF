package classement;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class testTable extends JPanel {
    private boolean DEBUG = true;

    public static String RN = "\r\n";
    private JTextField textField;
    private JTable table;
    
    
    public testTable() {
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
    	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	
    	JLabel lblPoule = new JLabel("Poule :");
    	GridBagConstraints gbc_lblPoule = new GridBagConstraints();
    	gbc_lblPoule.insets = new Insets(0, 0, 5, 5);
    	gbc_lblPoule.anchor = GridBagConstraints.EAST;
    	gbc_lblPoule.gridx = 1;
    	gbc_lblPoule.gridy = 0;
    	add(lblPoule, gbc_lblPoule);
    	
    	textField = new JTextField();
    	GridBagConstraints gbc_textField = new GridBagConstraints();
    	gbc_textField.insets = new Insets(0, 0, 5, 0);
    	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
    	gbc_textField.gridx = 2;
    	gbc_textField.gridy = 0;
    	add(textField, gbc_textField);
    	textField.setColumns(10);
    	
    	String[] columnNames = {"Classement","Equipe",
                "Points",
                "MJ",
                "Première place",
                "Deuxième place",
                "Troisième place",
                "Forfait",
                "Nb Périodes",
                "Esprit sportif"};

		Object[][] data = {
		{new Integer(1), "Angers 1", "18","1", "1","-","-","-","3","5"},
		
		};

    	table = new JTable(data, columnNames);
    	GridBagConstraints gbc_table = new GridBagConstraints();
    	gbc_table.gridwidth = 2;
    	gbc_table.insets = new Insets(0, 0, 5, 0);
    	gbc_table.fill = GridBagConstraints.BOTH;
    	gbc_table.gridx = 1;
    	gbc_table.gridy = 1;
    	add(table, gbc_table);
    	
    	JButton btnNewButton = new JButton("New button");
    	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
    	gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
    	gbc_btnNewButton.gridx = 2;
    	gbc_btnNewButton.gridy = 3;
    	add(btnNewButton, gbc_btnNewButton);

    	
        
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        testTable newContentPane = new testTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}