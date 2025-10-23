package org.example.carnicerialock;

public class Cliente extends Thread {
    private String nombre;
    private Carniceria carniceria;


    public Cliente(String nombre, Carniceria carniceria) {
        this.nombre = nombre;
        this.carniceria = carniceria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carniceria getCarniceria() {
        return carniceria;
    }

    public void setCarniceria(Carniceria carniceria) {
        this.carniceria = carniceria;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + this.getNombre() + " ha entrado en la carniceria ");
        try {

            //se puede quitar el lock en todas y ponerlo aquí
            carniceria.pedircarne(this);
            carniceria.pagar(this);
            carniceria.despedirse(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
