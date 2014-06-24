package main.java.classement;

import java.util.Comparator;

public class IntegerComparator
    implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2)
    {
        Integer i1;
        Integer i2;

        if(null == o1 || o1.equals(""))
        {
            i1 = 0;
        }
        else
        {
            i1 = new Integer(o1);
        }

        if(null == o2 || o2.equals(""))
        {
            i2 = 0;
        }
        else
        {
            i2 = new Integer(o2);
        }

        return i1.compareTo(i2);
    }
}