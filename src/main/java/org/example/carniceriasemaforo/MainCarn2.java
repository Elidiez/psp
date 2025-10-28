package org.example.carniceriasemaforo;

public class MainCarn2 {


        public static void main(String[] args) {
            Carniceria2 carniceria = new Carniceria2();
            int nombre = 1;
/*
        Thread[] clientes = new Thread[8];
        for (int i = 1; i <= 8; i++) {
            clientes[i-1] = new Thread(new Cliente(carniceria, "Cliente " + i));
            clientes[i-1].start();
        }
        */
            for(int i = 8; i>0;i--) {

                Cliente2 c = new Cliente2(carniceria, "Cliente " + nombre,i);
                c.start();
                nombre++;
            }

        }
    }