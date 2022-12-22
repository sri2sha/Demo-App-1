package com.example.dempapp1.recyclerview;

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
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


}
