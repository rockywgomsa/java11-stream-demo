package com.mitocode;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mitocode.model.Person;
import com.mitocode.model.Product;

public class App {
    public static void main(String[] args) {

        Person p1 = new Person(1, "William", LocalDate.of(1991, 1, 21));
        Person p2 = new Person(2, "Code", LocalDate.of(1990, 2, 21));
        Person p3 = new Person(3, "Rocky", LocalDate.of(1980, 6, 23));
        Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
        Person p5 = new Person(5, "Osito", LocalDate.of(2010, 1, 4));

        Product pr1 = new Product(1, "Ceviche", 15.0);
        Product pr2 = new Product(2, "Chilaquiles", 25.50);
        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
        Product pr4 = new Product(4, "Ceviche", 15.0);
        Product pr5 = new Product(5, "Chilaquiles", 25.50);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4, pr5);

        System.out.println("=========R O C K Y=============");
        
        /*LAS EXPRESIONES LAMBDA SON FUNCIONES ANONIMAS*/
                
//        printList(persons);

        // 1-Filter (param: Predicate, esto es siempre una condicion que devolvera true o false)        
//        filterPerson(persons);
        
        // 2-Map (param: Function, siempre recibe una funcion. La funcion se puede aislar)
//        mapPerson(persons);  

        // 3-Sorted (param: Comparator)
//        sorterPerson(persons);        
        
        // 4-Match (param: Predicate)
//          matchPerson(persons);
        
        // 5-Limit/Skip
//       limitPerson(persons);
        
        // 6-Collectors        
//        colectorsProducts(products);
        
        //7-reduce        
        reduceProducts(products);
    }
    
    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list){
    	
    	// Lambda //method reference
        /*for(int i = 0; i<persons.size(); i++){
                System.out.println(persons.get(i));
        
        }*/
        /*for(Person p : persons){
                System.out.println(p);
        }*/
//        lista.forEach(x -> System.out.println(x));        
        //persons.forEach(System.out::println);
//    	list.forEach(x -> System.out.println(x));
    	
        list.forEach(System.out::println);
    }
    
    public static void filterPerson(List<Person> persons) {
    	List<Person> lista = persons.stream()
				                .filter(p -> App.getAge(p.getBirthDate()) >= 18)
				                .collect(Collectors.toList());
    	
    	App.printList(lista);
    }
    
    public static void mapPerson(List<Person> persons) {
    	Function<String, String> rockyFunction = x -> x + "_Rocky";
    	List<String> lista = persons.stream()
//    			.filter(p -> App.getAge(p.getBirthDate()) >= 18)
//    			.map(p -> App.getAge(p.getBirthDate()))
//    			.map(p -> p.getName() + "_Rocky")
    			.map(Person::getName)
    			.map(rockyFunction)
    			.collect(Collectors.toList());
    	
        App.printList(lista);
    }
    
    public static void sorterPerson(List<Person> persons) {
    	Comparator<Person> byNameAsc = (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Person> byNameDesc = (Person o1, Person o2) -> o2.getName().compareTo(o1.getName());
        Comparator<Person> byBirthDate = (Person o1, Person o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());

        List<Person> lista = persons.stream()
                                        .sorted(byBirthDate)
                                        .collect(Collectors.toList());
       
        App.printList(lista);
    }
    
    public static void matchPerson(List<Person> persons) {
    	Predicate<Person> startsWithPredicate = p -> p.getName().startsWith("R");
        // anyMatch : No evalua todo el stream, termina en la coincidencia
        boolean rpta1 = persons.stream()
                                .anyMatch(startsWithPredicate);        
        // allMatch : Evalua todo el stream bajo la condicion
        boolean rpta2 = persons.stream()
                                .allMatch(startsWithPredicate);        
        
        // noneMatch : Evalua todo el stream bajo la condicion
        boolean rpta3 = persons.stream()
                                .noneMatch(startsWithPredicate);
        
        System.out.println(rpta3);
    }
    
    public static void limitPerson(List<Person> persons) {
    	 int pageNumber = 1;
         int pageSize = 2;
         //skip(2): mostrara los elementos a partir de la posicion 3
         //limit(2): muestra los 2 primeros elementos
         List<Person> lista = persons.stream()
                                         .skip(pageNumber * pageSize)
                                         .limit(pageSize)
                                         .collect(Collectors.toList());
        
         App.printList(lista);
	}
    
    
    public static void colectorsProducts(List<Product> products ) {
    	// GroupBy
    	Map<String, List<Product>> collect1 = products.stream()
									                .filter(p -> p.getPrice() > 20)
									                .collect(Collectors.groupingBy(Product::getName));
//		System.out.println(collect1);
		// Counting
		Map<String, Long> collect2 = products.stream()
								            .collect(Collectors.groupingBy(
								                Product::getName, Collectors.counting()
								                )
								            );
//		System.out.println(collect2);
		
		//Agrupando por nombre producto y sumando
		Map<String, Double> collect3 = products.stream()
								            .collect(Collectors.groupingBy(
								                Product::getName, 
								                Collectors.summingDouble(Product::getPrice)
								                )
								            );
//		System.out.println(collect3);
		
		
		//Obteniendo suma y resumen: obtienes sum, promedio,min,max
		DoubleSummaryStatistics statistics = products.stream()
		                .collect(Collectors.summarizingDouble(Product::getPrice));
		System.out.println(statistics);
			}
    
    public static void reduceProducts(List<Product> products) {
    	//sumar los precios
		Optional<Double> sum = products.stream()
									.map(Product::getPrice)
									.reduce(Double::sum);
//									 .reduce((a,b) -> a+b);
		System.out.println(sum.get());
	}
}
