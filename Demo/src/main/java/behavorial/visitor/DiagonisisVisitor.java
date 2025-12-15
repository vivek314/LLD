package behavorial.visitor;

public class DiagonisisVisitor implements Visitor {

	@Override
	public void visit(ChildPatient childPatient) {
		System.out.println("DiagonisisVisitor to child Patient");
	}

	@Override
	public void visit(AdultPatient adultPatient) {
		System.out.println("DiagonisisVisitor to adult Patient");
	}

	@Override
	public void visit(SeniorPatient seniorPatient) {
		System.out.println("DiagonisisVisitor to senior Patient");
	}
}
