package Tarea_Inyeccion_Dependencias_Semana1;
import java.util.Scanner;

public class Juego {
	private Dificultad dificultad;
    private int numeroAdivinar;
    private int intentosRestantes;

    // Inyección de dependencias a través del constructor
    public Juego(Dificultad dificultad) {
        this.dificultad = dificultad;
        this.numeroAdivinar = dificultad.generarNumeroAleatorio();
        this.intentosRestantes = dificultad.getIntentosPermitidos();
    }

    public void jugar() {
        Scanner scan = new Scanner(System.in);
        boolean adivinado = false;

        System.out.println("¡Comienza el juego! Adivina el número.");

        while (intentosRestantes > 0 && !adivinado) {
            System.out.println("Te quedan " + intentosRestantes + " intentos.");
            System.out.print("Introduce tu adivinanza: ");
            int intento = scan.nextInt();

            if (intento == numeroAdivinar) {
                adivinado = true;
                System.out.println("¡Felicidades! Has adivinado el número.");
            } else if (intento < numeroAdivinar) {
                System.out.println("El número es mayor.");
            } else {
                System.out.println("El número es menor.");
            }

            intentosRestantes--;
        }

        if (!adivinado) {
            System.out.println("No has adivinado el número. Era: " + numeroAdivinar);
        }

        scan.close();
    }
}

