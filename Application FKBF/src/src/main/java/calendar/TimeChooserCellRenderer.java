package src.main.java.calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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