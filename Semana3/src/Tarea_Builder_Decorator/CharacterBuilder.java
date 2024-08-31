package Tarea_Builder_Decorator;

public class CharacterBuilder {
	
	private Character character;

	public CharacterBuilder() {
		this.character = new Heroe_basic() ;
	}
	
	public CharacterBuilder addArmor()
	{
		this.character = new MagicArmor(character);
		return this;
	}
	
	public CharacterBuilder addSword()
	{
		this.character = new Fire_Sword(character);
		return this;
	}
	
	public CharacterBuilder addPotion()
	{
		this.character = new Mysterious_Potion(character);
		return this;
	}
	
	public Character build()
	{
		return this.character;
	}
	
	
}
