package com.example.demoapp1.recyclerview;

public class EmployeeModelData {
    private String employeeId;
    private String employeeName;

    public EmployeeModelData() {
    }

    public EmployeeModelData(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}
