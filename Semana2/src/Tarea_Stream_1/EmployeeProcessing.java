package Tarea_Stream_1;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class EmployeeProcessing {
	
}
	class Employee {
        String name;
        double salary;
        Optional<Double> bonus;

        Employee(String name, double salary, Optional<Double> bonus) {
            this.name = name;
            this.salary = salary;
            this.bonus = bonus;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public Optional<Double> getBonus() {
            return bonus;
        }

}
