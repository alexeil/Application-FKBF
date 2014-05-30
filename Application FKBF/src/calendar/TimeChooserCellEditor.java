package calendar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import lu.tudor.santec.jtimechooser.JTimeChooser;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TimeChooserCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
	SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");

	private long time;
	private JButton bouton;
	private JTimeChooser jTimeChooser;
	private JPanel panel;
	private JDialog dialog;

	JTable table;
	Object value;
	boolean isSelected;
	int row;
	int column;

	public TimeChooserCellEditor() {
		super();

		panel = new JPanel();
		// bouton.setBorderPainted(false);

		jTimeChooser = new JTimeChooser();
		
		// JLabel label = new JLabel("Choose a time !");
		// label.setVisible(true);

		dialog = new JDialog();
		dialog.setTitle("Choose a time !");

		bouton = new JButton();
		bouton.setActionCommand("change");
		bouton.addActionListener(this);
		bouton.setBorderPainted(false);

		dialog.setSize(175, 64);
		dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		dialog.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		dialog.getContentPane().setLayout(gridBagLayout);

		JButton ok = new JButton("OK");
		ok.addActionListener(this);

		GridBagConstraints gbc_ok = new GridBagConstraints();
		gbc_ok.gridwidth = 4;
		gbc_ok.gridx = 1;
		gbc_ok.gridy = 0;
		dialog.getContentPane().add(ok, gbc_ok);

		GridBagConstraints gbc_jTimeChooser = new GridBagConstraints();
		gbc_jTimeChooser.insets = new Insets(0, 0, 0, 5);
		gbc_jTimeChooser.gridx = 0;
		gbc_jTimeChooser.gridy = 0;
		dialog.getContentPane().add(jTimeChooser, gbc_jTimeChooser);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("change".equals(e.getActionCommand())) {
			bouton.setText(timeformat.format(new Date(time)));
			jTimeChooser.setTime(new Date(time));
			dialog.setVisible(true);
			// fireEditingStopped();

		} else {
			try {
				time = timeformat.parse((String) jTimeChooser.getTimeField().getValue()).getTime();
				bouton.setText(timeformat.format(new Date(time)));
				dialog.setVisible(false);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Object getCellEditorValue() {
		return timeformat.format(new Date(time));
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if(0 == (Long)value){
			try{
				time = timeformat.parse("10:30:00").getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}else{
		time = (Long) value;
		}
		return bouton;
	}
}