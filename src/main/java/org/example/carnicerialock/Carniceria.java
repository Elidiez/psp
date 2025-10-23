package org.example.carnicerialock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Carniceria {


    private int id;
    private Lock lock = new ReentrantLock();

    public Carniceria(int id) {
        this.id = id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void pedircarne(Cliente cliente) throws InterruptedException {
        lock.lock(); //bloqueo el método una vez empieza
        //es lo mismo que poner un synchronized porque bloqueo y desbloqueo
        System.out.println("El cliente " + cliente.getNombre() + " está pidiendo 2kg de carne");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("El cliente " + cliente.getNombre() + " ha dejado de pedir carne");

    }

    public void pagar(Cliente cliente) throws InterruptedException {

        lock.lock(); //bloqueo el método una vez empieza
        //es lo mismo que poner un synchronized porque bloqueo y desbloqueo
        System.out.println("El cliente " + cliente.getNombre() + " está pagando");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("El cliente " + cliente.getNombre() + " ha pagado su pedido");

    }

    public void despedirse(Cliente cliente) throws InterruptedException {
        lock.lock(); //bloqueo el método una vez empieza
        //es lo mismo que poner un synchronized porque bloqueo y desbloqueo
        System.out.println("El cliente " + cliente.getNombre() + " está despidiendose");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("El cliente " + cliente.getNombre() + " ha dejado la carniceria");

    }

}
