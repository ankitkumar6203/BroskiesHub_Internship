package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<Student> stu = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addStudent(){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();

        Student s = new Student(id, name, grade);
        stu.add(s);
        System.out.println("Student added successfully!\n");
    }

    public static void removeStudent(){
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        boolean removed = stu.removeIf(s->s.getId()==id);

        if(removed){
            System.out.println("Student removed successfully!\n");
        }else{
            System.out.println("Student with ID " + id + " not found.\n");
        }
    }

    public static void displayStudents(){
        if(stu.isEmpty()){
            System.out.println("No students to display.\n");
        }else{
            System.out.println("Student List:");
            for (Student s : stu) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> displayStudents();
                case 4 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice, try again.\n");
            }
        } while (choice != 4);
    }


}