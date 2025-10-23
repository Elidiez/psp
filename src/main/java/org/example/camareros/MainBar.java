package org.example.camareros;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainBar {

    public static void main(String[] args) {

        ExecutorService camarero = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 40; i++) {

            camarero.execute(new Cliente(i));

        }

        camarero.shutdown();
    }
}
