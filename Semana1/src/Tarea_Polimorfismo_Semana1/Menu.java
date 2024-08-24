package Tarea_Polimorfismo_Semana1;

import java.util.Scanner;

public class Menu {
	
	Scanner scan = new Scanner(System.in);
	
	public int mostrarMenu()
	{
		System.out.println("---------Bienvenido al juego----------");
		System.out.println("Elige una clase:");
		System.out.println("1.Mago");
		System.out.println("2.Guerrero");
		System.out.println("3.Ladron");
		System.out.println("4.Arquero");
		int opcion = scan.nextInt();
		return opcion;
	}
}
