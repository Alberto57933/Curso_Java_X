package Tarea_Builder_Decorator;
import java.util.List;
import java.util.ArrayList;

abstract class Heroe_Decorator implements Character {
	protected Character character;
	
	public Heroe_Decorator(Character character)
	{
		this.character = character;
	}
	
	@Override
	public double damage() {
		return character.damage();
	}

	@Override
	public String descriptionHeroe() {
		return character.descriptionHeroe();
	}

	@Override
	public double hp() {
		return character.hp();
	}

	@Override
	public double damagebyeffect() {
		return character.damagebyeffect();
	}

	@Override
	public double armor() {
		return character.armor();
	}
	
	
}
