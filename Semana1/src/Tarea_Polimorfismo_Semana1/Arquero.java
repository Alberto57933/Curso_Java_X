package Tarea_Polimorfismo_Semana1;

public class Arquero extends Personaje implements Magia {
	@Override
	void atacar()
	{
		System.out.println("El Arquero "+ getNombre()+ " lanza una flecha");
	}
	
	@Override
	void defender()
	{
		System.out.println("El Arquero "+ getNombre()+ " se defiende con un escudo");
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("El arquero "+getNombre()+" encanta su arco y hace mas daño");
		
	}

}
