package behavorial.chainOfResponsibility;

public class Manager extends Approver{

	@Override
	public void processLeaveRequest(int days) {
		if(days<=7){
			System.out.println("Leave Request approved by manager");
		} else if(nextApprover!=null){
			System.out.println("Leave Request redirecting to " +  nextApprover.getName());
			nextApprover.processLeaveRequest(days);
		}
	}

	@Override
	public String getName() {
		return "Manager";
	}
}
