package org.example.banco;

public class PersonaBanco {

    private String nombre;
    private CuentaBancaria cuenta =   new CuentaBancaria();

    public PersonaBanco(String nombre, CuentaBancaria cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public synchronized void sacar(int retirada)
    {
        if(retirada > cuenta.getSaldo())
        {
            System.out.println("Saldo insuficiente");
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cuenta.getSaldo() -= retirada;
            System.out.println("Retirado con éxito: " + retirada);
        }
        notifyAll();
    }

    public synchronized void ingresar(int ingresado)
    {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cuenta.getSaldo() += ingresado;
        System.out.println("has ingresado: " + ingresado );

        notifyAll();
    }

    public synchronized void consultar()
    {
        System.out.println("Tu saldo es: " + cuenta.getSaldo());
        notifyAll();

    }

}
