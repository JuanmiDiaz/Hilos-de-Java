package Practica_1_supermercado;

/** Practica 1: clientes supermercado
 * @author Sergio Fontan Llamas
 * @version 1.0
 * @since 2020
 */

public class Caja extends Thread {
	private int id;
	private Supermercado supermercado;
	private Integer tiempoCaja;

	/** Crea una nueva caja 
	 * @param int id
	 * @param Supermercado supermercado
	 */
	public Caja(int id, Supermercado supermercado) {
		this.id = id;
		this.supermercado=supermercado;
		this.tiempoCaja=0;
	}

	public void run() {
		int retardo;
		int numeroCliente;
		while(supermercado.isClientesPendientes()) {
			try {
				/* Crea un tiempo de retardo de atencion entre clientes. */
				retardo =(int)(Math.random()*90+10);
				tiempoCaja+=retardo;
				numeroCliente=supermercado.terminarCliente(retardo);
				sleep(retardo);
				System.out.println("La caja " + id + " ha atendido al cliente " + numeroCliente + " en un tiempo de " + retardo);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println("Fin de la caja " + id + ", que ha terminado con un tiempo parcial de " + tiempoCaja);
		
	}
}