package calendar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class SexeCellEditor
    extends AbstractCellEditor
    implements TableCellEditor, ActionListener
{
    private boolean sexe;
    private JButton bouton;

    public SexeCellEditor()
    {
        super();

        bouton = new JButton();
        bouton.addActionListener(this);
        bouton.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        sexe ^= true;

        fireEditingStopped();
    }

    @Override
    public Object getCellEditorValue()
    {
        return sexe;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
        sexe = (Boolean) value;

        return bouton;
    }
}