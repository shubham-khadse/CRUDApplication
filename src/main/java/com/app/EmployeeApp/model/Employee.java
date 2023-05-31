package com.app.EmployeeApp.model;

import jakarta.persistence.*;

@Entity // Database store
@Table(name = "Employee") // link with table
public class Employee {
    @Id //showing primary key attribute
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the value will be identical , never be same value
    private int emp_id;
    @Column(name = "emp_name") //mapping with database table column
    private String emp_name;
    @Column(name = "emp_salary")
    private float emp_salary;
    @Column(name = "emp_age")
    private int emp_age;
    @Column(name = "emp_city")
    private String emp_city;

    public int getEmp_id() {

        return emp_id;
    }

    public void setEmp_id(int emp_id) {

        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public float getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(float emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public Employee() {

    }

    public Employee(int emp_id, String emp_name, float emp_salary, int emp_age, String emp_city) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
        this.emp_age = emp_age;
        this.emp_city = emp_city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_salary=" + emp_salary +
                ", emp_age=" + emp_age +
                ", emp_city='" + emp_city + '\'' +
                '}';
    }
}
