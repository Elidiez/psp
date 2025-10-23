
public class Productor extends Thread{

	private Cola cola;
	
		public Productor (Cola c) {
			cola = c;
		}
		public void run() {
			for (int i = 0;i<5;i++) {
				try {
					cola.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //pone el n�mero en la cola
				System.out.println(i+ "=>Productor produce "+ i);
				try {
					sleep(100);
				}catch(InterruptedException ex) {
					
				}
			}
		}
		
}
