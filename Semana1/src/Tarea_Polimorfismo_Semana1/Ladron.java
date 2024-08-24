package Tarea_Polimorfismo_Semana1;

public class Ladron extends Personaje implements Magia {
	
	@Override
	void atacar()
	{
		System.out.println("El Ladron "+ getNombre()+ " ataca con su daga");
	}
	
	@Override
	void defender()
	{
		System.out.println("El Ladron "+ getNombre()+ " se defiende con una barrera de energia");
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("El ladron "+getNombre()+" encanta su daga para aplicar un efecto de sangrado");
		
	}

}
