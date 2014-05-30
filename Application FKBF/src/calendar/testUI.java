package calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextArea;

public class testUI {

	/**
	 * @param args
	 */
	static JDialog dialog;
	private static JLabel lblNewLabel;
	private static JTextField imageAnnonce;
	private static JTextArea descriptionAnnonce;
	
	public static void main(String[] args) {
		JButton generateAnnonce = new JButton("Generate anonce");
		dialog = new JDialog();
		dialog.setTitle("Generate your annonce");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		dialog.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		dialog.getContentPane().add(lblDescription, gbc_lblDescription);
		
		descriptionAnnonce = new JTextArea();
		descriptionAnnonce.setLineWrap(true);
		descriptionAnnonce.setText("La sixi\u00E8me journ\u00E9e du championnat de France de Kin-Ball se d\u00E9roulera le dimanche 15 d\u00E9cembre 2013 \u00E0 Berric. \\n\\r Les matchs auront lieu \u00E0 la Salle Omnisport de Berric. Le premier match commencera \u00E0 10h00. Les horaires indiqu\u00E9s sont les horaires de d\u00E9but de match au plus t\u00F4t. ");
		GridBagConstraints gbc_descriptionAnnonce = new GridBagConstraints();
		gbc_descriptionAnnonce.gridheight = 2;
		gbc_descriptionAnnonce.gridwidth = 3;
		gbc_descriptionAnnonce.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionAnnonce.fill = GridBagConstraints.BOTH;
		gbc_descriptionAnnonce.gridx = 1;
		gbc_descriptionAnnonce.gridy = 0;
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
		GridBagConstraints gbc_generateOK = new GridBagConstraints();
		gbc_generateOK.insets = new Insets(0, 0, 5, 5);
		gbc_generateOK.gridx = 1;
		gbc_generateOK.gridy = 3;
		dialog.getContentPane().add(generateOK, gbc_generateOK);
		
		generateAnnonce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.setVisible(true);
			}
		});

	}

}
