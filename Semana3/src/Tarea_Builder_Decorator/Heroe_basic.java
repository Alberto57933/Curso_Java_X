package Tarea_Builder_Decorator;
import java.util.ArrayList;
import java.util.List;

public class Heroe_basic implements Character{
	
	@Override
	public double damage() {
		return 10;
	}

	@Override
	public String descriptionHeroe() {
		return "Heroe equipment ";
	}

	@Override
	public double hp() {
		return 100;
	}

	@Override
	public double damagebyeffect() {
		return 0;
	}

	@Override
	public double armor() {
		return 50;
	}

}
