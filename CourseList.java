package org.redischool.coursebookingsystem;

class CourseList {
    Course[] courseArray = new Course[10];

    void initCourseList(){
        Course course = new Course(1,"Java-1", 3);
        courseArray[0] = course;
        course = new Course(2,"Java-2", 3);
        courseArray[1] = course;
        course = new Course(3,"Python", 3);
        courseArray[2] = course;
        course = new Course(4,"Python for Data Science", 3);
        courseArray[3] = course;
    }

    public String toString(){
        String courseListString = "";
        for (Course course:courseArray){
            if (course!=null) {
                courseListString = courseListString + course.toString() + "\n";
            }
        }
        return courseListString;
    }

    Course selectCourse(int selectedCourseId){
        for (Course course:courseArray){
            if (course!=null &&
                    course.courseId == selectedCourseId &&
                    course.openSpaces > 0){
                return course;
            }
        };
        return null;
    };
}
