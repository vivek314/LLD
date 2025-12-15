package behavorial.visitor;

public class Hospital {
	public static void main(String[] args) {
		Patient[] patients = {
				new ChildPatient(),
				new AdultPatient(),
				new SeniorPatient(),
		};
		Visitor diagonisisVisitor = new DiagonisisVisitor();
		Visitor billingVisitor = new BillingVisitor();
		for (Patient patient : patients) {
			patient.accept(diagonisisVisitor);
			patient.accept(billingVisitor);
		}
	}
}
