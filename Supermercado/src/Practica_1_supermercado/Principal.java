package Practica_1_supermercado;

/** Practica 1: clientes supermercado
 * @author Sergio Fontan Llamas
 * @version 1.0
 * @since 2020
 */

public class Principal {

	public static void main(String[] args) {
		
		Supermercado supermercado = new Supermercado();
		/* Creacion del numero aleatorio de cajas. */
		int cajas = (int) (Math.random() * 4) + 3;

		/* Creacion del numero aleatorio de clientes. */
		int clientes = (int) (Math.random() * 30) + 100;
		System.out.println(clientes + " clientes seran atendidos por " + cajas + " cajas.");

		/* Creacion de clientes */
		Cliente[] c = new Cliente[clientes];
		for (int i = 0;i<clientes ; i++) {
			c[i]=new Cliente(i+1, supermercado);
			c[i].start();
		}
		
		/* Creacion de cajas */
		Caja[]ca = new Caja[cajas];
		for (int i = 0;i<cajas ; i++) {
			ca[i] = new Caja(i+1, supermercado);
			ca[i].start();
		}

		/* Esperar a que terminen todas las cajas */
		for (int i = 0; i<cajas; i++) {
			try {
				ca[i].join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
		/* Esperar a que terminen todos clientes */
		for (int i = 0;i<clientes ; i++) {
			try {
				c[i].join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		/* Se cierra la supermercado */
		System.out.println("Se cierra el supermercado con un tiempo total de " + supermercado.getTiempo());
	}
}