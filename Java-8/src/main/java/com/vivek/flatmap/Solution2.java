package com.vivek.flatmap;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {


/*        2. Flatten List of Strings into Characters

        You have a List<String> like ["Java", "Stream"].
        Task: Convert it into a List<Character> containing all characters.
*/
        System.out.println("******************  Flatten List of Strings into Characters ********************************");

        List<String> listOfString= List.of("JAVA","Stream","vivek","satish","Iram");

        List<Character> charList= listOfString.stream()
                .flatMap(word-> word.chars().mapToObj(s->(char) s))
                .toList();
        System.out.println(charList);

        /*
        3. Split Sentences into Words

        Given a List<String> where each string is a sentence.
                Task: Extract all words into a single list using flatMap.
        */
        System.out.println("******************  Split Sentences into Words ********************************");

        List<String> sentences= List.of("Hi I am India"
                ,"i am ranveer singh"
                ,"i love my country"
                ,"i want to sing a song"
                ,"iran is nationa");

        List<String> stringList= sentences.stream()
                .flatMap(word-> Arrays.stream(word.split(" ")))
                .toList();

        System.out.println("Words: " + stringList);

/*
        4. Get All Emails from Users

        You have a List<User> where each user has a List<String> emails.
        Task: Collect all emails into a single list.
*/
        System.out.println("******************  Get All Emails from Users ********************************");

        List<User> users = List.of(
                new User("U1", List.of("u1@gmail.com", "u1@yahoo.com")),
                new User("U2", List.of("u2@gmail.com")),
                new User("U3", List.of("u3@gmail.com", "u3@outlook.com")),
                new User("U4", List.of("u4@yahoo.com")),
                new User("U5", List.of("u5@gmail.com", "u5@yahoo.com", "u5@outlook.com")),
                new User("U6", List.of("u6@gmail.com")),
                new User("U7", List.of("u7@yahoo.com", "u7@gmail.com")),
                new User("U8", List.of("u8@outlook.com")),
                new User("U9", List.of("u9@gmail.com", "u9@yahoo.com")),
                new User("U10", List.of("u10@gmail.com"))
        );

      List<String> emails=  users.stream()
              .flatMap(s-> s.getEmail().stream())
              .toList();

        System.out.println("emails: " + emails);
/*
        5. Flatten Optional Values

        You have a List<Optional<String>>.
        Task: Extract all present values into a List<String>.
*/
        System.out.println("****************** Flatten Optional Values ********************************");


        List<Optional<String>> optionalList = List.of(
                Optional.of("Java"),
                Optional.of("Stream"),
                Optional.empty(),
                Optional.of("FlatMap"),
                Optional.empty(),
                Optional.of("Optional"),
                Optional.of("Lambda"),
                Optional.empty(),
                Optional.of("API"),
                Optional.of("Code")
        );

        List<String> stringOpList= optionalList.stream()
                .flatMap(s->s.stream()).toList();

        System.out.println("Extracted Values: " + stringOpList);
/*
        6. Get Unique Characters from Words

        Given a List<String>.
        Task: Extract all characters using flatMap and return unique ones.

*/
        System.out.println("****************** Get Unique Characters from Words ********************************");

        List<String> words= List.of("JAVA","Stream","vivek","satish","Iram");

        List<Character> uniqueCharacters= words.stream()
                        .flatMap(s-> s.chars().mapToObj(a->(char) a))
                        .distinct()
                        .toList();

        System.out.println(uniqueCharacters);
/*
        7. Flatten Map Values

        You have a Map<String, List<Integer>>.
        Task: Combine all values into a single list.
*/
        System.out.println("****************** Flatten Map Values ********************************");
        Map<String, List<Integer>> map = Map.of(
                "A", List.of(1, 2),
                "B", List.of(3, 4),
                "C", List.of(5, 6)
        );

        List<Integer> numbers = map.values().stream().flatMap(Collection::stream).toList();


        /*
        8. Process Nested Orders

        You have a List<Customer> → each has List<Order> → each order has List<Item>.
        Task: Get a list of all items using flatMap.
*/

        Item item1 = new Item("Laptop", 50000);
        Item item2 = new Item("Mouse", 500);
        Item item3 = new Item("Keyboard", 1500);
        Item item4 = new Item("Monitor", 10000);

        Order order1 = new Order(1, List.of(item1, item2));
        Order order2 = new Order(2, List.of(item3));
        Order order3 = new Order(3, List.of(item4));

        Customer c1 = new Customer("Vivek", List.of(order1, order2));
        Customer c2 = new Customer("Rahul", List.of(order3));

            List<Customer> customers = List.of(c1,c2);

        System.out.println("******************  List Item ********************************");
        List<Item> items= customers.stream().flatMap(s->s.getOrders().stream())
                .flatMap(s->s.getItems().stream()).toList();

        
    }
}
