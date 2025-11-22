package creational.prototypePattern;

public class Character implements Cloneable{
	private String name;
	private int health;
	private int power;
	private int level;

	public Character(String name, int health, int power, int level) {
		this.name = name;
		this.health = health;
		this.power = power;
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Character clone() {
		try {
			Character clone = (Character) super.clone();//shallow copy, only copies the references, does not create new object
			// TODO: copy mutable state here, so the clone can't change the internals of the original
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
