package behavorial.template;

public class Coffee extends Beverage{

	@Override
	void brew() {
		System.out.println("Brewing Coffee");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Sugar and milk");
	}
}
