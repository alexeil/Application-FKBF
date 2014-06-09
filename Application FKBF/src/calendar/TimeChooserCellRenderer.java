package calendar;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TimeChooserCellRenderer
    extends DefaultTableCellRenderer
{
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Long time = (Long) value;

        setText(timeformat.format(new Date(time)));

        return this;
    }
}