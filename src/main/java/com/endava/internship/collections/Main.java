package com.endava.internship.collections;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        StudentMap hashStudentMap = new StudentMap(1);
        StudentMap anotherStudentMap = new StudentMap(1);

        Student student1 = new Student("Grigore1 ", LocalDate.of(1999, 1, 23), "A young man");
        Student student2 = new Student("Kolea2 ", LocalDate.of(1934, 2, 3), "String man");
        Student student3 = new Student("Kate3 ", LocalDate.of(2019, 3, 6), "Teensdsafager");
        Student student4 = new Student("John4 ", LocalDate.of(2029, 4, 21), "Teenasfasager");
        Student student5 = new Student("Iron5 ", LocalDate.of(2039, 5, 7), "asasdf");
        Student student6 = new Student("ssIron6 ", LocalDate.of(2039, 5, 7), "a123sf");
        Student student7 = new Student("qqIron7 ", LocalDate.of(2039, 5, 7), "aasd12zcsf");
        Student student8 = new Student("qqIron8 ", LocalDate.of(2039, 5, 7), "asxfhdf");
        Student student9 = new Student("qqIron9 ", LocalDate.of(2039, 5, 7), "asdhcnf");
        Student student10 = new Student("qqIron10 ", LocalDate.of(2039, 5, 7), "asfhdf");
        Student student11 = new Student("qqIron11 ", LocalDate.of(2039, 5, 7), "asddgf");

        hashStudentMap.put(student1, 1);
//        hashStudentMap.put(student2, 2);
//        hashStudentMap.put(student3, 3);
//        hashStudentMap.put(student4, 4);
//        hashStudentMap.put(student5, 5);


        anotherStudentMap.put(student6, 6);
        anotherStudentMap.put(student7, 7);
        anotherStudentMap.put(student8, 8);
        anotherStudentMap.put(student9, 9);
        anotherStudentMap.put(student1, 10);

        System.out.println(hashStudentMap.remove(student1));


    }

}
