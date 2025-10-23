package org.example.pistola;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainPistola {
    public static void main(String[] args) {

        Pistola p1 = new Pistola();

        //DISPARAR 60 veces, al llegar a 40, para
        new Thread() {

            @Override
            public void run() {
                p1.disparar(60);
            }

        }.start();

        //RECARGAR
        new Thread() {
            @Override
            public void run() {
                p1.recargar();
            }
        }.start();
    }
}

