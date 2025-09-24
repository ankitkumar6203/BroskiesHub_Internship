package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    public String toString(){
        return "Employee{name= "+name+", age= "+age+", salary="+salary+"}";
    }

    public double getSalary() {
        return salary;
    }
    public String getName(){
        return name;
    }
}

