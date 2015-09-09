package com.tutorial.mapdemo;;
import java.util.Comparator;

public class GradeComparator implements Comparator {
    //@Override
    public int compare(Object o1,Object o2) {
        // descending order (ascending order would be:
        // o1.getGrade()-o2.getGrade())
        return ((Student)o2).getGrade() - ((Student)o1).getGrade();
    }
}
