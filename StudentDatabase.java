package Student_Database_App;

import java.util.Scanner;

public class StudentDatabase {
    public static void main(String[] args) {
        /**
         * A student database management system
         */

        //Ask for new Students
        System.out.println("Enter the number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];

        // n number of students
        for (int i = 0; i < numOfStudents; i++){
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            System.out.println(students[i].showInfo());
        }





    }
}
