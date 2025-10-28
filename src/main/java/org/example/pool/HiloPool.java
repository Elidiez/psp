package org.example.pool;

public class HiloPool extends Thread {

    public int id;
    public HiloPool(int id)
    {
        this.id = id;
    }

    @Override
    public void run()
    {
        System.out.println("HiloPool " + id +  " coge el pool " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
