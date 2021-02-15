package Practica_1_supermercado;

/** Practica 1: clientes supermercado
 * @author Sergio Fontan Llamas
 * @version 1.0
 * @since 2020
 */

public class Cliente extends Thread {
	private int id;
	private Supermercado supermercado;
	
	/** Crea un nuevo cliente 
	 * @param int id
	 * @param Supermercado supermercado
	 */
	public Cliente(int id, Supermercado supermercado) {
		this.id = id;
		this.supermercado=supermercado;
	}
	public void run() {
		supermercado.nuevoCliente(id);	
	}
}
