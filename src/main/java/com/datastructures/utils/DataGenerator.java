package com.datastructures.utils;

import com.datastructures.models.Order;
import com.datastructures.models.User;
import com.datastructures.models.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Emma"};
    private static final String[] PRODUCTS = {"Laptop", "Phone", "Tablet", "Monitor", "Keyboard"};
    private static final Random RANDOM = new Random();

    public static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            users.add(new User("U" + i, NAMES[RANDOM.nextInt(NAMES.length)], RANDOM.nextInt(50) + 18));
        }
        return users;
    }


    public static List<Product> generateProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            products.add(new Product("P" + i, PRODUCTS[RANDOM.nextInt(PRODUCTS.length)], RANDOM.nextDouble() * 1000));
        }
        return products;
    }


    public static List<Order> generateOrders(int count, List<User> users, List<Product> products, int min, int max) {
        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            //creating a user
            User user = users.get(RANDOM.nextInt(users.size()));

            //product list for the order
            List<Product> orderProducts = new ArrayList<>();
            int productCount = RANDOM.nextInt(min) + max;

            for (int j = 0; j < productCount ; j++) {
                Product product = products.get(RANDOM.nextInt(products.size()));
                orderProducts.add(product);
            }
            orders.add(new Order("O" + i, user, orderProducts));
        }
        return orders;
    }

}
