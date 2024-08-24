package Tarea_Polimorfismo_Semana1;

public class Guerrero extends Personaje {
	
	@Override
	void atacar()
	{
		System.out.println("El Guerrero "+ getNombre()+ " ataca con su espada");
	}
	
	@Override
	void defender()
	{
		System.out.println("El Guerrero "+ getNombre()+ " se defiende con su escudo");
	}
}
