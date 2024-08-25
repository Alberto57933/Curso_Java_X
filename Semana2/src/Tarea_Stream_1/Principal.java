package Tarea_Stream_1;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;
public class Principal {

	public static void main(String[] args) {
		 List<Employee> employees = Arrays.asList(
		            new Employee("John", 60000, Optional.of(5000.0)),
		            new Employee("Jane", 75000, Optional.empty()),
		            new Employee("Jack", 80000, Optional.of(6000.0)),
		            new Employee("Jill", 50000, Optional.of(2000.0)),
		            new Employee("Jerry", 70000, Optional.empty())
		        );

		        List<String> eligibleEmployees = employees.stream()
		            .filter(emp -> emp.getBonus().isPresent())        
		            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())) 
		            .map(emp -> emp.getName() + " with bonus: $" + emp.getBonus().get()) 
		            .collect(Collectors.toList());                    

		        eligibleEmployees.forEach(System.out::println);
	}

}
