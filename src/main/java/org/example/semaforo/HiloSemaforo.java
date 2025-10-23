package org.example.semaforo;

import java.util.concurrent.Semaphore;

public class HiloSemaforo implements Runnable {

    private Semaphore semaphore;
    private String nombre;

    public HiloSemaforo(String nombre, Semaphore semaphore){
        this.nombre = nombre;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        System.out.println("Esperando el semaforo");

        try {
            semaphore.acquire();

        System.out.println("Ha adquirido el semaforo");
        Thread.sleep(300);
        semaphore.release();
        System.out.println("Ha liberado el semaforo");
        } catch (InterruptedException e) {
           e.getMessage();
        }
    }
}
