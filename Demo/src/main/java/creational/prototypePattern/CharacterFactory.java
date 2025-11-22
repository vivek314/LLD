package creational.prototypePattern;

public class CharacterFactory {
	private final Character prototype;
	// when object creation is expensive, and we need to create customObjects, we do shallow copies of exising classes and modify them to create new objects
	public CharacterFactory() {
		prototype = new Character("John", 10, 4, 1);
	}

	public Character createCharacterWithNewName(String name){
		Character character = prototype.clone();
		character.setName("Vivek");
		return character;
	}
}
