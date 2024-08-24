package Tarea_Singleton_Semana1;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RegistroLog log1 = RegistroLog.obtenerInstancia();
		
		//Agregar algunas entradas al log
		String mensaje;
        while (true) {
            System.out.println("Ingresa un mensaje para el log (o escribe 'salir' para terminar):");
            mensaje = scan.nextLine();

            if (mensaje.equalsIgnoreCase("salir")) {
                break; // Salir del bucle si el usuario ingresa "salir"
            }

            log1.agregarEntrada(mensaje);
        }
		
		//Obtener la instancia de nuevo y agregar mas entradas
		RegistroLog log2 = RegistroLog.obtenerInstancia();
		log2.agregarEntrada("Entrada del segundo log");
		
		//Verificar si log1 es igual a log2
		
		if(log1==log2) {
			System.out.println("Ambas referencias apuntan a la misma instancia de Registro");
		}
		else
		{
			System.out.println("¡ERROR! Se crearon multiples instancias de RegistroLog");
		}
		
		scan.close();

	}

}
