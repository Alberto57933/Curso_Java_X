package Tarea_Inyeccion_Dependencias_Semana1;
import java.util.Random;

public class Dificil implements Dificultad {
	
	public int generarNumeroAleatorio() {
        return new Random().nextInt(100) + 1; // Números entre 1 y 100
    }

    public int getIntentosPermitidos() {
        return 3; // 3 intentos
    }

}
