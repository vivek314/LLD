package behavorial.chainOfResponsibility;

public class Main {
	public static void main(String[] args) {
		Approver supervisor = new Supervisor();
		Approver manager =new Manager();
		Approver director = new Director();
		supervisor.setNextApprover(manager);
		manager.setNextApprover(director);
		supervisor.processLeaveRequest(11);
	}
}
