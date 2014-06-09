package calendar;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SexeCellRenderer
    extends DefaultTableCellRenderer
{
    private Icon manImage;
    private Icon womanImage;

    public SexeCellRenderer()
    {
        super();
        manImage = new ImageIcon("images/M.jpg");
        womanImage = new ImageIcon("images/F.jpg");
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