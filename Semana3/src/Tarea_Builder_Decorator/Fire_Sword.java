package Tarea_Builder_Decorator;

public class Fire_Sword extends Heroe_Decorator {
	public Fire_Sword(Character character) {
		super(character);
	}
	
	@Override
	public double damage() {
		return character.damage()+5;
	}

	@Override
	public String descriptionHeroe() {
		return character.descriptionHeroe()+" Fire Sword,";
	}

	@Override
	public double hp() {
		return character.hp();
	}

	@Override
	public double damagebyeffect() {
		return character.damagebyeffect()+5;
	}

	@Override
	public double armor() {
		return character.armor();
	}
}
