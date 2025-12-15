package behavorial.chainOfResponsibility;

public class Supervisor extends Approver{

	@Override
	public void processLeaveRequest(int days) {
		if(days<=3){
			System.out.println("Leave sanctioned by supervisor");
		} else if(nextApprover!=null){
			System.out.println("Leave Request redirecting to " +  nextApprover.getName());
			nextApprover.processLeaveRequest(days);
		}
	}

	@Override
	public String getName() {
		return "Supervisor";
	}
}
