package com.tutorial.mapdemo;
import java.util.Comparator;

public class NameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String name1 = ((Student)o1).getName();
        String name2 = ((Student)o2).getName();

        // ascending order (descending order would be: name2.compareTo(name1))
        return name1.compareTo(name2);
    }
}
