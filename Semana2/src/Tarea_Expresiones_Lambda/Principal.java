package Tarea_Expresiones_Lambda;
import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Principal {

	public static void main(String[] args) {
		//Supplier
		System.out.println("Lambdas Supplier");
		System.out.println("*************************");
		//Supplier random number
		Supplier<Double> randomSupplier = ()-> Math.random();
		System.out.println("Random number Supplier: "+randomSupplier.get());
		
		//Message Supplier
		Supplier<String> messageSupplier = ()->"Hello Supplier";
		System.out.println("Message Supplier: "+messageSupplier.get());
		
		//StringBuilder Supplier
		Supplier<StringBuilder> stringSupplier = () -> new StringBuilder("Hello StringBuilder");
		System.out.println("String Builder: "+stringSupplier.get());
		
		//Supplier Date
		Supplier<Long> timeSupplier = () -> System.currentTimeMillis();
		System.out.println("Time Supplier: "+timeSupplier.get());
		
		//Consumer
		System.out.println("*************************");
		System.out.println("Lambdas Consumer");
		System.out.println("*************************");
		
		//Consumer Double Number
		Consumer<Integer> consumerDouble = dnumber -> System.out.println("The double is: "+(dnumber*2));
		consumerDouble.accept(5);
		
		//Consumer Concatenate
		Consumer<String> consumerConcat = ConcaMessage -> System.out.println("Hi: "+ConcaMessage);
		consumerConcat.accept("World");
		
		//Consumer List
		List<String>list = new ArrayList<>();
		Consumer<String> consumerList = item ->{
			list.add(item);
			System.out.println("List: "+ list);
		};
		consumerList.accept("Cheese");
		consumerList.accept("Bread");
		
		//Consumer Capital
		Consumer<String> consumerCap = CapMessage -> System.out.println(CapMessage.toUpperCase());
		consumerCap.accept("hello uper");
		
		//BiConsumer
		System.out.println("*************************");
		System.out.println("Lambdas BiConsumer");
		System.out.println("*************************");
		
		//BiConsumer Add
		BiConsumer<Integer,Integer> biconsumernum = (num1,num2) ->System.out.println("Num1 + Num2: "+(num1+num2));
		biconsumernum.accept(5, 10);
		
		//BiConsumer concat
		BiConsumer<String,String> biconsumerConcat = (m1,m2) ->System.out.println(m1+m2);
		biconsumerConcat.accept("Hello ", "Biconsumer");
		
		//BiConsumer area
		BiConsumer<Integer,Integer> biConsumerArea = (b,h)-> System.out.println("Area of a Rectangle: "+(b*h));
		biConsumerArea.accept(10, 7);
		
		//BiConsumer Map
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> mapBiConsumer = map::put;
		mapBiConsumer.accept("Juan", 25);
		mapBiConsumer.accept("Mike", 12);
		System.out.println("Mapa: "+map);
		
		//Predicate
		System.out.println("*************************");
		System.out.println("Lambdas Predicate");
		System.out.println("*************************");
		
		//Predicate pair
		Predicate<Integer> isPair = num -> num % 2 == 0;
        System.out.println("Is Pair?: "+isPair.test(4));
        
        //Predicate String length
        Predicate<String> lengthS = c -> c.length() == 5;
        System.out.println("5 caracters?: "+lengthS.test("Hello"));
        
        //Predicate positive
        Predicate<Integer> positive = num -> num > 0;
        System.out.println("Positive?: "+positive.test(5));
        
        //Predicate list
        List<String> list1 = new ArrayList<>();
        Predicate<List<String>> isEmptyList = List::isEmpty;
        System.out.println("Is the list empty?: " + isEmptyList.test(list1));
        
        //BiPredicate
        System.out.println("*************************");
		System.out.println("Lambdas BiPredicate");
		System.out.println("*************************");
		
		//BiPredicateAge
		BiPredicate<String, Integer> ageC  = 
                (name, age) -> name.equals("Juan") && age > 18;
            System.out.println("More than 18: "+ageC.test("Juan", 20));
        
        //BiPredicate two Strings
        BiPredicate<String,String> strings = String::equals;
        System.out.println("Same String?: "+strings.test("HI", "HI"));
        
        //BiPredictae Positive
        BiPredicate<Integer, Integer> Positive = (a, b) -> a > 0 && b > 0;
        System.out.println("Are Both Positive?: " + Positive.test(5, 10));

        //BiPredicate InnerStrings
        BiPredicate<String, String> containsString = String::contains;
        System.out.println("Does it contains some of the string?: " + containsString.test("Hello World", "World"));
        
      //Function
        System.out.println("*************************");
		System.out.println("Lambdas Function");
		System.out.println("*************************");
		
		//Function square func
        Function<Integer, Integer> squareFunction = num -> num * num;
        System.out.println("Square: " + squareFunction.apply(5));

        //Function length
        Function<String, Integer> lengthFunction = String::length;
        System.out.println("Length: " + lengthFunction.apply("Hola"));

        //Function Double to String
        Function<Double, String> doubleToString = Object::toString;
        System.out.println("Transformn: " + doubleToString.apply(3.14159));

        //Function multiply by 10
        Function<Integer, Integer> multiplyByTen = num -> num * 10;
        System.out.println("Multiplied by 10: " + multiplyByTen.apply(7));
        
      //BiFunction
        System.out.println("*************************");
		System.out.println("Lambdas BiFunction");
		System.out.println("*************************");
		
		// BiFunction Add
        BiFunction<Integer, Integer, Integer> sumFunction = Integer::sum;
        System.out.println("Add: " + sumFunction.apply(5, 3));

        //  BiFunction Concat
        BiFunction<String, String, String> concatFunction = String::concat;
        System.out.println("Concat: " + concatFunction.apply("Hello ", "World"));

        //  BiFunction divide
        BiFunction<Integer, Integer, Double> divideFunction = (a, b) -> a / (double) b;
        System.out.println("Quotient: " + divideFunction.apply(10, 3));

        //  BiFunction Convertion
        BiFunction<Integer, Integer, String> sumToStringFunction = (a, b) -> "Result: " + (a + b);
        System.out.println(sumToStringFunction.apply(8, 7));
        
        //UnaryOperator
        System.out.println("*************************");
		System.out.println("Lambdas UnaryOperator");
		System.out.println("*************************");
		
		 // Unary Increment
        UnaryOperator<Integer> increment = num -> num + 1;
        System.out.println("Increment by: " + increment.apply(5));

        // Unary Upper
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("hi world"));

        // Unary invert boolean
        UnaryOperator<Boolean> invertBoolean = bool -> !bool;
        System.out.println("Inverted: " + invertBoolean.apply(true));

        // Unary square
        UnaryOperator<Integer> square = num -> num * num;
        System.out.println("Square: " + square.apply(4));
		
      //BinaryOperator
        System.out.println("*************************");
		System.out.println("Lambdas BinaryOperator");
		System.out.println("*************************");
		
		// Binary multiply
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Product: " + multiply.apply(5, 3));

        // Binary add
        BinaryOperator<Double> addDoubles = Double::sum;
        System.out.println("Doubles: " + addDoubles.apply(2.5, 4.3));

        // Binary Concat
        BinaryOperator<String> concatStrings = String::concat;
        System.out.println("Concat: " + concatStrings.apply("Java ", "Lambda"));

        //Binary MAX
        BinaryOperator<Integer> maxOperator = Integer::max;
        System.out.println("MAX: " + maxOperator.apply(7, 10));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
