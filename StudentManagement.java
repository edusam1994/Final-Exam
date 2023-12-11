package com.example.finalexam;

import java.util.Arrays;
import java.util.List;

public class StudentManagement {

    public static void main(String[] args) {

        List<Student> students = createSampleStudents();


        displayAllStudents(students);

        String courseToSearch = "Computer Science";
        displayStudentsByCourse(students, courseToSearch);

        String studentIDToUpdate = "SCS2";
        int newAge = 24;
        updateStudentAge(students, studentIDToUpdate, newAge);

        System.out.println("\nStudents after updating age:");
        displayAllStudents(students);

        double averageAge = calculateAverageAge(students);
        System.out.println("\nAverage age of all students: " + averageAge);
    }

    private static List<Student> createSampleStudents() {
        Student student1 = new Student("SCS1", "KEVIN SEMPERTEGUI", 30);
        student1.addCourse("Computer Science");
        student1.addCourse("Mathematics");

        Student student2 = new Student("SCS2", "EDUARDO VEGA", 28);
        student2.addCourse("Physics");
        student2.addCourse("Chemistry");

        Student student3 = new Student("SCS3", "KEVIN VEGA", 21);
        student3.addCourse("History");
        student3.addCourse("Literature");

        return Arrays.asList(student1, student2, student3);
    }

    private static void displayAllStudents(List<Student> students) {
        System.out.println("Details of all students:");
        students.forEach(System.out::println);
    }

    //  Implement a method using streams to find and display the students who are enrolled in a specific course.
    private static void displayStudentsByCourse(List<Student> students, String course) {
        System.out.println("\nStudents enrolled in " + course + ":");
        students.stream()
                .filter(student -> student.getCourses().contains(course))
                .forEach(System.out::println);
    }

    private static void updateStudentAge(List<Student> students, String studentID, int newAge) {
        students.stream()
                .filter(student -> student.getStudentID().equals(studentID))
                .findFirst()
                .ifPresent(student -> student.updateAge(newAge));
    }

    private static double calculateAverageAge(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }
}
