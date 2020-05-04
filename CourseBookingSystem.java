package org.redischool.coursebookingsystem;

import java.util.Scanner;

public class CourseBookingSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to our course booking system!");

        CourseList courseList = new CourseList();
        courseList.initCourseList();

        System.out.println("We offer the following courses: ");
        System.out.println(courseList.toString());

        System.out.println("Do you want to book a course (y/n)?");
        Scanner scanner = new Scanner(System.in);
        String wantBooking = scanner.next();

        while (wantBooking.equals("y")) {
            System.out.println("Please select a course by entering its course id: ");
            int selectedCourseId = scanner.nextInt();
            Course selectedCourse = courseList.selectCourse(selectedCourseId);

            if (selectedCourse == null) {
                System.out.println("Sorry, the course you selected is not available.");
                continue;
            }

            System.out.println("You selected the following course:");
            System.out.println(selectedCourse.toString());

            System.out.println("To book this course, please enter your personal data.");
            System.out.println("Please enter your name: ");
            String name = scanner.next();
            System.out.println("Please enter your age: ");
            int age = scanner.nextInt();
            System.out.println("Please enter your home country: ");
            String country = scanner.next();
            Student student = new Student(1, name, age, country);

            if (selectedCourse.book(student)) {
                System.out.println("You are booked for the following course:");
                System.out.println(selectedCourse.toString());
                System.out.println("List of participants:");
                System.out.println(selectedCourse.createParticipantList());
            } else {
                System.out.println("Sorry, course booking was not successful :-(");
            }

            System.out.println("Do you want to book another course (y/n)?");
            wantBooking = scanner.next();
        }
        System.out.println("Thanks for visiting our booking system! Bye bye!");
    }
}