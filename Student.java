package org.redischool.coursebookingsystem;

class Student {
    String name;
    int age;
    String country;

    Student(int studentId, String name, int age, String country){
        this.name = name;
        this.age = age;
        this.country = country;
    }


    public String toString(){
        return ("Student " + this.name
                + " is " + this.age
                + " years old and comes from " + this.country);
    }
}