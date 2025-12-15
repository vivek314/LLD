package behavorial.template;

abstract class Beverage {

	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	void boilWater(){
		System.out.println("Boil Water");
	}
	void pourInCup(){
		System.out.println("Pour in Cup");
	}

	abstract void brew();
	abstract void addCondiments();
}
