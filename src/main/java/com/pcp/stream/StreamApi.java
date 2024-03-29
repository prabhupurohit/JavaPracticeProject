package com.pcp.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamApi {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("Prabhu", 42, "Male", 2100.00, "Bangalore");
        Person person2 = new Person("Banani", 41, "Female", 1250.00, "Rourkela");
        Person person3 = new Person("Suman", 42, "Male", 1200.00, "Hyderabad");
        Person person4 = new Person("Bikas", 42, "Male", 1000.00, "Chennai");
        Person person5 = new Person("Prajit", 42, "Male", 2000.00, "Mangalore");
        Person person6 = new Person("Sapna", 42, "Female", 5000.00, "Bhubaneswar");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        //System.out.println(personList);;

        //Get all persons having Income more than 2000

        List<String> names = personList.stream()
                .filter(p -> p.getIncome() > 2000.00)
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(names);

        //Method1: Get the persons having highest 2 salaries

        List<Person> list1 = personList.stream()
                .sorted(Comparator.comparingDouble(Person::getIncome).reversed())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list1);

        //Method2: Get the persons having highest 2 salaries

        List<Person> list2 = personList.stream()
                .sorted(Comparator.comparing(Person::getIncome, Comparator.reverseOrder()))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list2);

        //Method3: Get the persons having highest 2 salaries

        List<Person> list3 = personList.stream()
                .sorted(Comparator.comparing(Person::getIncome).reversed())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list3);

        //Method4: Get the persons having highest 2 salaries

        List<Person> list4 = personList.stream()
                .sorted((p1, p2) -> (int) (p2.getIncome() - p1.getIncome()))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list4);

        //Method1: Get the Person with the Highest Salary

        Optional<Person> personMax = personList.stream().reduce((p1, p2) -> p1.getIncome() > p2.getIncome() ? p1 : p2);
        personMax.ifPresent(System.out::println);

        //Method2: Get the Person with the Highest Salary
        Person personMax1 = personList.stream().reduce((p1, p2) -> p1.getIncome() > p2.getIncome() ? p1 : p2)
                .get();
        System.out.println(personMax1);

        //Method3: Get the Person with the Highest Salary
        Person personMax2 = personList.stream()
                .sorted(Comparator.comparingDouble(Person::getIncome).reversed())
                                .limit(1)
                                .collect(Collectors.toList()).get(0);

        System.out.println(personMax2);

        //Find the Total Salary of Males and Females in a Map (Key: Male/Female, Value: Total Salary)

        Map<String, Double> map1 = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.summingDouble(Person::getIncome)));

        System.out.println(map1);

        //Find the Total Salary of Males and Females in a Map (Key: Male/Female, Value: Total Salary) -> Using Reduce function

        Map<String, List<Person>> map12 = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        map12.forEach((key, value) -> System.out.println(key + ": " + value.stream()
                .mapToDouble(Person::getIncome)
                .reduce(0, Double::sum)));

        //Find the total salary of all the persons using Reduce
        Double personSum = personList.stream()
                .mapToDouble(Person::getIncome)
                .reduce(0, (v1, v2) -> v1 + v2);

        OptionalDouble totalSum = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender))
                .entrySet()
                .stream().map(e -> e.getValue())
                .mapToDouble(p -> p.stream().collect(Collectors.summingDouble(Person::getIncome)))
                .reduce((v1, v2) -> v1 + v2);
        System.out.println(totalSum.getAsDouble());


        System.out.println(personSum);

        //Find the Maximum Salary of Males and Females in a Map (Key: Male/Female, Value: Max Salary)

        Map<String, Optional<Person>> map2 = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.maxBy(Comparator.comparingDouble(Person::getIncome))));

        map2.values().forEach(v -> v.ifPresent(p -> System.out.println("Name: " + p.getName() + ", Income: " + p.getIncome())));

    }


}
