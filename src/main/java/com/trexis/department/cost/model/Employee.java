package com.trexis.department.cost.model;

import org.springframework.util.Assert;

public class Employee {
    private String name;
    private EmployeeType type;
    private Boolean used = false;

    Employee(String name, EmployeeType type){
        Assert.notNull(name, "Employee must have a name.");
        Assert.notNull(type, "Employee must have a type.");
        
        this.name = name;
        this.type = type;
    }

    Boolean isUsed(){
        return used;
    }

    void setUsed(Boolean used){
        this.used = used;
    }
    
    Integer getCost(){
        return this.getType().cost;
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

    /**
     * @return EmployeeType return the type
     */
    public EmployeeType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EmployeeType type) {
        if (this.type == EmployeeType.manager){
            // JDTODO: Warning or Notice to re-run model.
        }
        this.type = type;
    }

}