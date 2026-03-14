package com.dto;

public class EmployeeDTO {

    private String username;
    private String password;
    private String fullname;
    private String address;
    private String department;
    private int salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String username, String password, String fullname, String address, String department, int salary) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.department = department;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
