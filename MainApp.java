package School_Management_System;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Teacher emeka = new Teacher(1, "Emeka", 2000);
        Teacher oko = new Teacher(2, "Oko", 2500);
        Teacher iris = new Teacher(3, "Iris", 1800);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(emeka);
        teacherList.add(oko);
        teacherList.add(iris);

        Student sam = new Student(1, "Sammy", 3);
        Student lemon = new Student(2, "Lemon", 6);

        List<Student> studentList = new ArrayList<>();
        studentList.add(sam);
        studentList.add(lemon);

        School lagos = new School(teacherList, studentList);

        // student pay school fees
        sam.updateFeesPaid(3000);
        lemon.updateFeesPaid(4000);

        System.out.println("Lagos School earned: " + "\n"+ lagos.getTotalMoneyEarned()+ " Naira");

        // School pays salary
        System.out.println("\n------------- Lagos School Pays Salary to teachers --------");
        // teacher 1
        int eme = emeka.getSalary();
        emeka.receiveSalary(eme);
        System.out.println("\nLagos School paid " + emeka.getName()
                + " for the month "+ "and has " + lagos.getTotalMoneyEarned()
                + " Naira as balance");

        //teacher 2
        iris.receiveSalary(iris.getSalary());
        System.out.println("\nLagos School paid " + iris.getName()
                + " for the month "+ "and has " + lagos.getTotalMoneyEarned()
                + " Naira as balance");

        System.out.println(sam);



    }

}
