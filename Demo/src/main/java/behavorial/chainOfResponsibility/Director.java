package behavorial.chainOfResponsibility;

public class Director extends Approver {

	@Override
	public void processLeaveRequest(int days) {
		if(days<=10){
			System.out.println("Leave Request approved by director");
		} else if(nextApprover!=null){
			System.out.println("Leave Request redirecting to " +  nextApprover.getName());
			nextApprover.processLeaveRequest(days);
		}
	}

	@Override
	public String getName() {
		return "Director";
	}
}
