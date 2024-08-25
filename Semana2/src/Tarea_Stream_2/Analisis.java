package Tarea_Stream_2;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analisis {
	String name;
    String category;
    Optional<Integer> sales;

   
    public Analisis(String name, String category, Optional<Integer> sales) {
		super();
		this.name = name;
		this.category = category;
		this.sales = sales;
	}


	public String getName() {
		return name;
	}


	public String getCategory() {
		return category;
	}


	public Optional<Integer> getSales() {
		return sales;
	}


}
