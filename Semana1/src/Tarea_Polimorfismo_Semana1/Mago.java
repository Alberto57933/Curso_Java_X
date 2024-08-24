package Tarea_Polimorfismo_Semana1;

public class Mago extends Personaje implements Magia {
	
	@Override
	void atacar()
	{
		System.out.println("El Mago "+ getNombre()+ " ataca con un hechizo");
	}
	
	@Override
	void defender()
	{
		System.out.println("El Mago "+ getNombre()+ " se defiende con una barrera de energia");
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("El Mago "+getNombre()+" lanza un gran rayo de magia");
		
	}
}
