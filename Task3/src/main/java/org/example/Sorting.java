package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Ankit",22,10000));
        emps.add(new Employee("Ashish", 23,20000));
        emps.add(new Employee("Shahil",24,30000));
        emps.add(new Employee("Gautam",40,12000));

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
        System.out.println("Employees sorted by salary in decreasing order:");
        for (Employee e : emps) {
            System.out.println(e);
        }

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName()); // Ascending
            }
        });

        System.out.println("\nEmployees sorted by name in ascending order: ");
        for (Employee e : emps) {
            System.out.println(e);
        }
    }
}
