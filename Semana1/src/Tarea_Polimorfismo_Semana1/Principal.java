package Tarea_Polimorfismo_Semana1;
import java.util.Scanner;
public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Menu menu = new Menu();
		int opcion =menu.mostrarMenu();
		
		if (opcion < 1 || opcion > 4)
		{
			System.out.println("Opcion no valida, reinicie el programa");
			scan.close();
		}
		
		System.out.println("Ingresa el nombre de tu personaje: ");
		String nombre= scan.nextLine();
		
		System.out.println("Ingresa la raza de tu personaje");
		String raza = scan.nextLine();
		
		Personaje personaje = null;
		
		switch(opcion) {
		case 1:
			personaje = new Mago();
			personaje.setVida(150);
			break;
			
		case 2:
			personaje =  new Guerrero();
			personaje.setVida(250);
			break;
		
		case 3:
			personaje = new Ladron();
			personaje.setVida(120);
			break;
			
		case 4:
			personaje = new Arquero();
			personaje.setVida(200);
			break;
			
		default:
			System.out.println("Opcion no valida.");
			return;
		}
		
		if(personaje != null)
		{
			personaje.setNombre(nombre);
			personaje.setRaza(raza);
			
			System.out.println("Has creado un "+ personaje.getClass().getSimpleName()+
			" llamado "+personaje.getNombre()
			+" de la raza "+personaje.getRaza()+" Tienes un total de "+personaje.getVida()+" de puntos de vida");
			
			personaje.atacar();
			personaje.defender();
			
			if(personaje instanceof Magia)
			{
				System.out.println("Este personaje puede usar magia");
				((Magia) personaje).lanzarHechizo();
			}
		}
		
		scan.close();
		
	}
	
}
