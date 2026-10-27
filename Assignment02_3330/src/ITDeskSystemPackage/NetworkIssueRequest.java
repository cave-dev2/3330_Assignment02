package ITDeskSystemPackage;

/*
Represents a network issue affecting multiple users.

Required additional data:
• int affectedUsers (must be positive)

Resolution rule (open design choice): Choose ONE of the following approaches and doc-
ument your choice in a short comment near the formula:
• linear rule: basePoints + affectedUsers
• weighted rule: basePoints + (affectedUsers * 2)
• milestone rule: award an additional bonus when affectedUsers >= 20
• your own clear and reasonable rule

Your rule must be consistent and validated.
*/

public class NetworkIssueRequest extends AbstractSupportRequest {

	//Define class variables
	private final int affectedUsers;

	//Class constructor
	public NetworkIssueRequest(int id, String title, int basePoints, boolean resolved, int affectedUsers) {

		//Milestone rule: award an additional bonus when affectedUsers >= 20
		super(id, title, basePoints, (int)((affectedUsers >= 20) ? basePoints * 0.25f : 0), resolved);
		
		//Check invariants
		if(affectedUsers < 0) throw new IllegalArgumentException("Network Issue cannot affect negative users");
		
		//Fill variables
		this.affectedUsers = affectedUsers;
		
	}
	
	//Override toString
	@Override 
	public String toString() {
		if(this.isResolved()==true) return this.getTitle() + " (" + this.getId() + ") for " + this.affectedUsers + " users, resolved, for " + this.getBasePoints() + " points";
		else return this.getTitle() + " (" + this.getId() + ") for " + this.affectedUsers + " devices, unresolved, for " + this.getBasePoints() + " points";
	}
		
}
