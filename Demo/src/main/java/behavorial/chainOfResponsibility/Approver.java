package behavorial.chainOfResponsibility;

abstract class Approver {
	public String name;
	public Approver nextApprover;

	public void setNextApprover(Approver nextApprover) {
		this.nextApprover = nextApprover;
	}
	public abstract void processLeaveRequest(int days);
	public abstract String getName();
}
