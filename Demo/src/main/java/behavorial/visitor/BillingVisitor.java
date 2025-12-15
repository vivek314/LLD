package behavorial.visitor;

public class BillingVisitor implements Visitor {
	@Override
	public void visit(ChildPatient childPatient) {
		System.out.println("BillingVisitor to child Patient");
	}

	@Override
	public void visit(AdultPatient adultPatient) {
		System.out.println("BillingVisitor to adult Patient");
	}

	@Override
	public void visit(SeniorPatient seniorPatient) {
		System.out.println("BillingVisitor to senior Patient");
	}
}
