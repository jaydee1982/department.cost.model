package com.trexis.department.cost.model;

import java.util.ArrayList;

public class Manager extends Employee{
    
    ArrayList<Employee> directReports;
    
    Manager(String Name){
        super(Name, EmployeeType.manager);
    }

    boolean hasDevelopmentGroup(){
        if (directReports == null){
            return false;
        }
        for (Employee e : directReports){
            if ( e.getType() == EmployeeType.jrDeveloper || e.getType() == EmployeeType.srDeveloper || e.getType() == EmployeeType.qaTester )
            {
                return true;
            }
        }
        return false;
    }

    Integer numDirectManagerReports(){
        if (directReports == null){
            return 0;
        }
        Integer numManagers = 0;
        for (Employee e : directReports){
            if ( e.getType() == EmployeeType.manager ){
                numManagers += 1;
            }
        }
        return numManagers;
    }

    boolean hasEnoughResponsibility(){
        if (!this.hasDevelopmentGroup() && this.numDirectManagerReports() >= 2){
            return true;
        } else if (this.hasDevelopmentGroup()) {
            return true;
        } else {
            return false;
        }
    }

    boolean isDevelopmentGroupUnderstaffed(){
        if (!this.hasDevelopmentGroup()){
            return false;
        }

        Integer numSrDevelopers = 0;
        Integer numQaTesters = 0;
        for( Employee e : this.directReports){
            if(e.getType() == EmployeeType.srDeveloper){
                ++numSrDevelopers;
            }
            if(e.getType() == EmployeeType.qaTester){
                ++numQaTesters;
            }
        }
        if(numSrDevelopers >= 1 && numQaTesters >= 1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    Integer getCost(){
        if ( directReports == null ) return this.getType().cost;
        Integer totalCost = this.getType().cost;
        for ( Employee e : directReports ){
            totalCost += e.getCost();
        }
        return totalCost;
    }

    Boolean addEmployee(Employee employee){
                
        if(this.directReports == null){
            this.directReports = new ArrayList<Employee>();
        }
        
        if(employee.isUsed()){
            return false;
        }

        employee.setUsed(true);
        return this.directReports.add(employee);

    }
}