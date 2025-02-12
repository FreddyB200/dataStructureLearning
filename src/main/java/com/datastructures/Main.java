package com.datastructures;
import java.util.ArrayList;
import java.util.List;
import com.datastructures.models.*;
import com.datastructures.utils.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Agregando 20 users e imprimiendolos en pantalla: ");

        long start = System.nanoTime();

        List<User> users = DataGenerator.generateUsers(1000000);
        for (User user : users) {
            System.out.println("Id: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Age: " + user.getAge());
            System.out.println("----------------------------");
        }

        long end = System.nanoTime();

        long duration = end - start;
        double milisecondsDuration = duration / 1000000;

        System.out.println("Run time: " + duration + "ns");
        System.out.println("Run time: " + milisecondsDuration + "ms");
        System.out.println("Number of generate users: " + users.size());


    }

}
