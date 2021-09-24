package com.techelevator;

public class Employee {

    //variables
    private int employeeId;

    private String firstName;
    private String lastName;
    private String department;

    private double annualSalary;

    // constructor
    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    // getters & setters

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    // setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }

    public String getDepartment() {
        return this.department;
    }

    // setter
    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    // Methods
    public void raiseSalary(double percent) {
        double salary = annualSalary;
        double salaryIncrease = salary * (percent / 100);
        annualSalary = salary + salaryIncrease;
    }


}
