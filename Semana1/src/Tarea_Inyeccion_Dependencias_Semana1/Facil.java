package Tarea_Inyeccion_Dependencias_Semana1;
import java.util.Random;

public class Facil implements Dificultad {
	public int generarNumeroAleatorio() {
        return new Random().nextInt(10) + 1; // Números entre 1 y 10
    }

    public int getIntentosPermitidos() {
        return 5; // 5 intentos
    }
}
