package behavorial.template;

public class Tea extends Beverage{
	@Override
	void brew() {
		System.out.println("Brewing Tea");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Tea leaves");
	}
}
