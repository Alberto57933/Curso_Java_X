package Tarea_Inyeccion_Dependencias_Semana1;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	
	public Dificultad seleccionarDificultad() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. Fácil (1-10, 5 intentos)");
        System.out.println("2. Medio (1-50, 4 intentos)");
        System.out.println("3. Difícil (1-100, 3 intentos)");
        
        int opcion = scan.nextInt();
        Dificultad dificultad = null;

        switch (opcion) {
            case 1:
                dificultad = new Facil();
                break;
            case 2:
                dificultad = new Medio();
                break;
            case 3:
                dificultad = new Dificil();
                break;
            default:
                System.out.println("Opción no válida.");
                System.exit(0);
        }

        return dificultad;
    }

}
