package Tarea_Polimorfismo_Semana1;

public abstract class Personaje {
	
	private String nombre;
	
	private String raza;
	
	private int vida;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if(vida >0)
		{
			this.vida = vida;
		}
		else
		{
			System.out.println("No se puede tener vida negativa");
		}
		
	}

	abstract void atacar();
	
	abstract void defender();

}
