package Tarea_Builder_Decorator;

public class Mysterious_Potion extends Heroe_Decorator {

	public Mysterious_Potion(Character character) {
		super(character);
	}
	
	@Override
	public double damage() {
		return character.damage()+2;
	}

	@Override
	public String descriptionHeroe() {
		return character.descriptionHeroe()+" Mysterious potion,";
	}

	@Override
	public double hp() {
		return character.hp()+25;
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
