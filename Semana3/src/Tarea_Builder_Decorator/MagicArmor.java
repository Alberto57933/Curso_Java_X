package Tarea_Builder_Decorator;

public class MagicArmor extends Heroe_Decorator{

	public MagicArmor(Character character) {
		super(character);
	}
	
	@Override
	public double damage() {
		return character.damage();
	}

	@Override
	public String descriptionHeroe() {
		return character.descriptionHeroe()+" Magic Armor,";
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
		return character.armor()+75;
	}

}
