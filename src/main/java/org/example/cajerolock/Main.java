package org.example.cajerolock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        private static double saldo = 1000.00;
        private static Lock Lock = new ReentrantLock();

        public static void main(String[] args) {
            Thread t1 = new Thread(() -> {
                realizarRetiro(500.00);
            });

            Thread t2 = new Thread(() -> {
                realizarRetiro(700.00);
            });

            t1.start();
            t2.start();
        }

        public static void realizarRetiro(double cantidad) {
            Lock.lock();  //bloquea el acceso a la variable saldo
            try {
                if (saldo >= cantidad) {
                    saldo -= cantidad;
                    System.out.println("Retiro exitoso de " + cantidad);
                } else
                    System.out.println("Fondos insuficientes");
            } finally {
                Lock.unlock();
            }
        }

}