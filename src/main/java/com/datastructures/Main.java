package com.datastructures;
import java.util.ArrayList;
import com.datastructures.theory.*;
import java.util.List;
import com.datastructures.models.*;
import com.datastructures.utils.*;
import java.util.Optional;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //arrayListExercices();
        linkedListExercices();

    }

    private static void arrayListExercices(){
        System.out.println("---Generating data---");

        //Stars the time-taking
        long start = System.nanoTime();

        //generate products
        List<Product> products = DataGenerator.generateProducts(10000);
        for (Product product : products) {
            System.out.println("Code: " + product.getCode());
            System.out.println("Product name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("--------------------------------------");
        }

        //generate users
        List<User> users = DataGenerator.generateUsers(200);
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
            System.out.println("--------------------------------------");
        }

        //generate orders
        List<Order> orders = DataGenerator.generateOrders(5000, users, products, 2, 10);
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("User who made the order: " + order.getUser().getName());
            System.out.println("Quantity of products ordered: " + order.getProducts().size());
            System.out.println("Total price: " + order.getTotalPrice());
            System.out.println("--------------------------------------");
        }

        System.out.println("================================================");
        double totalPrice = orders.stream().mapToDouble(Order::getTotalPrice).sum();
        long totalPriceLong = (long) totalPrice;
        long averagePriceLong = Math.round(totalPrice / orders.size());
        System.out.println("Total price for all orders: " + totalPriceLong);
        System.out.println("Average price for all orders: " + averagePriceLong);


        System.out.println("================================================");

        Optional<Order> maxOrder = orders.stream()
                .max(Comparator.comparingDouble(Order::getTotalPrice));

        if (maxOrder.isPresent()) {
            System.out.println("Order with highest total price: " + maxOrder.get());
        } else {
            System.out.println("No orders found.");
        }

        System.out.println("================================================");
        System.out.println("Number of generate users: " + users.size());
        System.out.println("Number of generate products: " + products.size());
        System.out.println("Number of generate Orders: " + orders.size());

        //ends time-taking
        long end = System.nanoTime();
        long duration = end - start;
        double milisecondsDuration = duration / 1000000;

        System.out.println("================================================");
        System.out.println("Run time: " + duration + "ns");
        System.out.println("Run time: " + milisecondsDuration + "ms");
    }

    private static void linkedListExercices(){

        LinkedList<String> myList = new LinkedList<>();

        // Agregar elementos
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");

        System.out.println("Lista actual:");
        myList.print();

        // Eliminar un elemento
        myList.remove("Bob");
        System.out.println("Después de eliminar 'Bob':");
        myList.print();

        System.out.println("Tamaño de la lista: " + myList.size());

        //Java LinkedList
        List<String> list = new java.util.LinkedList<>();

        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");
        list.add("freddy");
        System.out.println("Tamaño de la lista enlazada de java utils: " + list.size());

        System.out.println("Lista: " + list);

        list.remove("Bob");
        System.out.println("Después de eliminar 'Bob': " + list);
        System.out.println("Tamaño de la lista enlazada de java utils: " + list.size());


        myList.reverse();
        myList.print();

    }

}
