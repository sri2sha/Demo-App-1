package com.example.dempapp1.recyclerview;

public class EmployeeModelData {
    private String employeeName;
    private String employeeId;

    public EmployeeModelData(String employeeName, String employeeId){
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }
}
