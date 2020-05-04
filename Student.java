package Student_Database_App;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 300;
    private static int id = 1000;

    public Student() {
        System.out.println("Enter Student's first name: ");
        Scanner in = new Scanner(System.in);
        this.firstName = in.nextLine();

        System.out.println("Enter Student's last name: ");
        this.lastName = in.nextLine();

        System.out.println("\n1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter Student's grade level: ");
        this.gradeYear = in.nextInt();

        setStudentId();
    }

    //Generate an ID
    private void setStudentId(){
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        // Getting inside a loop, user hits o

        do {
            System.out.print("Enter a course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance += costOfCourse;
            } else{break;}

        }while(true);
    }

    // View Balance

    public void viewBalance() {
        System.out.println("Your tuition balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status
    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudentID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
