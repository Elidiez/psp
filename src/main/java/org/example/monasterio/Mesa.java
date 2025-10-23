package org.example.monasterio;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Mesa {

    private int sitio;
    //ocupado o no ocupado array booleano
    private boolean[] ocupado = new boolean[5];

    public Mesa(int sitio) {
        this.sitio = sitio;

    }

    //si el monje 0 está comiendo/rezando, el monje -1 y 1 no come, reza
    //si el monje 1 está comiendo/rezando, el monje 0 y 2 no come, reza  ....

    synchronized public void cogerTenedor(Monje monje) {
        for (int i = 0; i < ocupado.length; i++) {
            while ((ocupado[i-1] = true) && (ocupado[i+1] = true) ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("El monje sentado en el sitio " + this.sitio + "va a empezar a comer");
            }
        }

    }

    synchronized public void comer(Monje monje) {

        for (int i = 0; i < ocupado.length; i++) {
            ocupado[i] = true;
            try {
                sleep(500);
                System.out.println("El monje sentado en el sitio " + this.sitio + " está comiendo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    synchronized public void dejarTenedor(Monje monje) {
        for (int i = 0; i < ocupado.length; i++) {
            ocupado[i] = false;
            notifyAll();
            System.out.println("El monje sentado en el sitio " + this.sitio + " ha dejado de comer");
        }
    }

    synchronized public void rezar(Monje monje) {
        for (int i = 0; i < ocupado.length; i++) {
            try {
                ocupado[i] = true;
                wait();
                sleep(500);
                System.out.println("El monje sentado en el sitio " + this.sitio + " está rezando");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
