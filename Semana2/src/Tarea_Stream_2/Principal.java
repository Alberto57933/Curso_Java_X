package Tarea_Stream_2;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) {
		 List<Analisis> products = Arrays.asList(
		            new Analisis("Laptop", "Electronics", Optional.of(200)),
		            new Analisis("TV", "Electronics", Optional.empty()),
		            new Analisis("Smartphone", "Electronics", Optional.of(500)),
		            new Analisis("Tablet", "Electronics", Optional.of(150)),
		            new Analisis("Blender", "Home Appliances", Optional.of(80)),
		            new Analisis("Vacuum Cleaner", "Home Appliances", Optional.of(100)),
		            new Analisis("Microwave", "Home Appliances", Optional.of(120)),
		            new Analisis("Oven", "Home Appliances", Optional.empty())
		        );

		        products.stream()
		            .filter(p -> p.getSales().isPresent())          
		            .collect(Collectors.groupingBy(Analisis::getCategory)) 
		            .forEach((category, prodList) -> {
		                System.out.println("Category: " + category);
		                prodList.stream()
		                    .sorted((p1, p2) -> p2.getSales().get() - p1.getSales().get())
		                    .limit(3)                                    
		                    .map(Analisis::getName)                       
		                    .forEach(System.out::println);               
		            });

	}

}
