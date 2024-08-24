package Tarea_Singleton_Semana1;

import java.time.LocalDateTime;

public class RegistroLog {
	// Atributo privado estatico que contiene la unica instancia de la clase
		private static RegistroLog instanciaUnica;
		
		//Constructor privado para evitar la creacion de nuevas instancias
		private RegistroLog() {
			
		}
		
		//Metodo estatico que proporciona el acceso a la unica instancia
		public static RegistroLog obtenerInstancia()
		{
			if (instanciaUnica == null)
			{
				instanciaUnica = new RegistroLog();
			}
			return instanciaUnica;
		}
		
		//Metodo para agregar una entrada al log
		public void agregarEntrada(String mensaje) {
			System.out.println(LocalDateTime.now()+": "+mensaje);
		}
}
