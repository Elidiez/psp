package org.example.semaforo;

import java.util.concurrent.Semaphore;

public class MainSemaforo {

    public static void main(String[] args) {

        Semaphore   semaforo = new Semaphore(1);
        Thread hilo1 = new Thread(new HiloSemaforo( "Hilo1", semaforo));
        Thread hilo2 = new Thread(new HiloSemaforo( "Hilo1", semaforo));
        Thread hilo3 = new Thread(new HiloSemaforo( "Hilo1", semaforo));

        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
