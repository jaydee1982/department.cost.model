package com.trexis.department.cost.model;

import java.util.ArrayList;

import org.springframework.util.Assert;

public class Department {
    private String name;
    private ArrayList<Employee> managers;

    Department(String name){
        this.name = name;
    }

    Boolean addManager(Employee employee){
        
        Assert.state(employee.getType() == EmployeeType.manager, "Employee must be a manager.");
        
        if(this.managers == null){
            this.managers = new ArrayList<Employee>();
        }
        
        if(employee.isUsed()){
            return false;
        }

        employee.setUsed(true);
        return this.managers.add(employee);
    }

    void removeManager(){
        //TODO: Beyond scope of POC.
        return;
    }

    Integer getCost(){        
        if ( managers == null ) return 0;

        Integer totalCost = 0;
        for ( Employee e : managers ){
            totalCost += e.getCost();
        }
        return totalCost;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}