package main.java.calendar;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class SexeCellRenderer
    extends DefaultTableCellRenderer
{
    private Icon manImage;
    private Icon womanImage;

    public SexeCellRenderer()
    {
        super();
        manImage = new ImageIcon("E:\\dev\\src\\Application-FKBF\\Application FKBF\\src\\main\\resources\\images\\M.jpg");
        womanImage = new ImageIcon("E:\\dev\\src\\Application-FKBF\\Application FKBF\\src\\main\\resources\\images\\F.jpg");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Boolean homme = (Boolean) value;

        setText("");
        if(homme)
        {
            setIcon(manImage);
        }
        else
        {
            setIcon(womanImage);
        }

        return this;
    }
}