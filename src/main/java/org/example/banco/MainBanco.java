package org.example.banco;

public class MainBanco {
    public static void main(String[] args) {

        CuentaBancaria cuentaSantander = new CuentaBancaria();
        PersonaBanco Eduardo = new PersonaBanco("Eduardo", cuentaSantander);
        PersonaBanco Maria = new PersonaBanco("Maria", cuentaSantander);
        PersonaBanco Luis = new PersonaBanco("Luis", cuentaSantander);
        PersonaBanco Marta = new PersonaBanco("Marta", cuentaSantander);

        new Thread()
        {
           @Override
           public void run()
           {
              Eduardo.sacar(60);
              {

           }
           }


        }.start();
    }

}
