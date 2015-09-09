package com.tutorial.mapdemo;
import java.util.Arrays;
public class MainComparatorExample {
    public static void main(String args[]) {
		float y = 0.56f;
	System.out.println("Y is " + y);
	
	int nk =10;
	int n = nk++%5;
	int z = ++nk%5;
	System.out.println("n is + " + n + ", z is " + z);

        Student student[] = new Student[3];
        student[0] = new Student();
        student[0].setName("Nick");
        student[0].setGrade(19);
        student[1] = new Student();
        student[1].setName("Helen");
        student[1].setGrade(12);
        student[2] = new Student();
        student[2].setName("Ross");
        student[2].setGrade(16);
        System.out.println("Order of students before sorting is: ");
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t"
                    + student[i].getGrade());
        }
        Arrays.sort(student, new GradeComparator());
        System.out
                .println("Order of students after sorting by student grade is");
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t"
                    + student[i].getGrade());
        }
        Arrays.sort(student, new NameComparator());
        System.out
                .println("Order of students after sorting by student name is");
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t"
                    + student[i].getGrade());
        }
    }
}
