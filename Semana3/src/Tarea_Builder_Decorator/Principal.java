package Tarea_Builder_Decorator;

public class Principal {

	public static void main(String[] args) {

		
		Character character = new CharacterBuilder()
				.addArmor()
				.addSword()
				.addPotion()
				.build();
		
		
		System.out.println(character.descriptionHeroe());
		System.out.println("Hp: "+character.hp());
		System.out.println("Damage: "+character.damage());
		System.out.println("Armor: "+character.armor());
		System.out.println("Damage by effect: "+character.damagebyeffect());
	}
}
