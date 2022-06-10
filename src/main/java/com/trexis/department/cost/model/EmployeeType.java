package com.trexis.department.cost.model;

public enum EmployeeType {
    
    manager(10),
    srDeveloper(35),
    jrDeveloper(25),
    qaTester(14);

    Integer cost;

    EmployeeType(Integer cost){
        this.cost = cost;
    }
}