package com.trexis.department.cost.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/runapitest")
	public String runapitest() {

		//////////////////////
		// Construct model.

		Department sydney = new Department("Sydney");

		Manager A = new Manager("A");
		Manager B = new Manager("B");
		Manager C = new Manager("C");
		Manager D = new Manager("D");
		Manager E = new Manager("E");
		Manager F = new Manager("F");

		Employee srDevA = new Employee("srDevA", EmployeeType.srDeveloper);
		Employee srDevB = new Employee("srDevB", EmployeeType.srDeveloper);

		Employee jrDevA = new Employee("jrDevA", EmployeeType.jrDeveloper);
		Employee jrDevB = new Employee("jrDevB", EmployeeType.jrDeveloper);

		Employee qaTesterA = new Employee("qaTesterA", EmployeeType.qaTester);
		Employee qaTesterB = new Employee("qaTesterB", EmployeeType.qaTester);
		Employee qaTesterC = new Employee("qaTesterC", EmployeeType.qaTester);

		sydney.addManager(A);
		sydney.addManager(C);
		
			A.addEmployee(jrDevA);
			A.addEmployee(qaTesterA);
			A.addEmployee(B);

				B.addEmployee(srDevA);
			
			C.addEmployee(D);
			C.addEmployee(E);

				D.addEmployee(srDevB);
				D.addEmployee(jrDevB);
				D.addEmployee(qaTesterB);

				E.addEmployee(F);
			
					F.addEmployee(qaTesterC);

		//////////////////////

		String htmlOutput = "";

		htmlOutput += "<p>Manager " + A.getName() + " has a cost of " + A.getCost() + "</p>";
		htmlOutput += "<p>Manager " + B.getName() + " has a cost of " + B.getCost() + "</p>";
		htmlOutput += "<p>Manager " + C.getName() + " has a cost of " + C.getCost() + "</p>";
		htmlOutput += "<p>Manager " + D.getName() + " has a cost of " + D.getCost() + "</p>";
		htmlOutput += "<p>Manager " + E.getName() + " has a cost of " + E.getCost() + "</p>";
		htmlOutput += "<p>Manager " + F.getName() + " has a cost of " + F.getCost() + "</p>";

		htmlOutput += "<p>Department " + sydney.getName() + " has a cost of " + sydney.getCost() + "</p>";

		if(A.hasEnoughResponsibility()){
			htmlOutput += "<p>Manager " + A.getName() + " has enough responsibility</p>";
		}else{
			htmlOutput += "<p>Manager " + A.getName() + " does not have enough responsibility</p>";
		}
		if(B.hasEnoughResponsibility()){
			htmlOutput += "<p>Manager " + B.getName() + " has enough responsibility</p>";
		}else{
			htmlOutput += "<p>Manager " + B.getName() + " does not have enough responsibility</p>";
		}
		if(C.hasEnoughResponsibility()){
			htmlOutput += "<p>Manager " + C.getName() + " has enough responsibility</p>";
		}else{
			htmlOutput += "<p>Manager " + C.getName() + " does not have enough responsibility</p>";
		}
		if(D.hasEnoughResponsibility()){
			htmlOutput += "<p>Manager " + D.getName() + " has enough responsibility</p>";
		}else{
			htmlOutput += "<p>Manager " + D.getName() + " does not have enough responsibility</p>";
		}
		if(E.hasEnoughResponsibility()){
			htmlOutput += "<p>Manager " + E.getName() + " has enough responsibility</p>";
		}else{
			htmlOutput += "<p>Manager " + E.getName() + " does not have enough responsibility</p>";
		}
		if(F.hasEnoughResponsibility()){
			htmlOutput += "<p>Manager " + F.getName() + " has enough responsibility</p>";
		}else{
			htmlOutput += "<p>Manager " + F.getName() + " does not have enough responsibility</p>";
		}

		if(A.isDevelopmentGroupUnderstaffed()){
			htmlOutput += "<p>Manager " + A.getName() + "'s development group is understaffed</p>";
		}
		if(B.isDevelopmentGroupUnderstaffed()){
			htmlOutput += "<p>Manager " + B.getName() + "'s development group is understaffed</p>";
		}
		if(C.isDevelopmentGroupUnderstaffed()){
			htmlOutput += "<p>Manager " + C.getName() + "'s development group is understaffed</p>";
		}
		if(D.isDevelopmentGroupUnderstaffed()){
			htmlOutput += "<p>Manager " + D.getName() + "'s development group is understaffed</p>";
		}
		if(E.isDevelopmentGroupUnderstaffed()){
			htmlOutput += "<p>Manager " + E.getName() + "'s development group is understaffed</p>";
		}
		if(F.isDevelopmentGroupUnderstaffed()){
			htmlOutput += "<p>Manager " + F.getName() + "'s development group is understaffed</p>";
		}

		return htmlOutput;
	}
}
