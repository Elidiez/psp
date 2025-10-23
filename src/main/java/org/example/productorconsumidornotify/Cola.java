
public class Cola {
	int numero;
	private boolean disponible = false;
	/*public int get() {
		if(disponible) {
			disponible = false;
			return numero;
		}
		return -1;
	}
	*/
	public synchronized int get() throws InterruptedException{
	 if(!disponible)
	 {
		 wait();
	 }
	 disponible = false;
	 notifyAll();
	 return numero;
	}
	/*
	public void put (int valor) {
		numero = valor;
		disponible = true;
	}
*/
	public synchronized void put(int valor) throws InterruptedException
	{
		while(disponible)
		{
			wait();
			
		}
		numero = valor;
		disponible = true;
		notifyAll();
	}
}
