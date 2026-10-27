package ITDeskSystemPackage;

/*
Represents a password or account reset request.

Required additional data:
• String accountName (not null or blank)

Resolution rule:
• awards exactly basePoints
*/

public class PasswordResetRequest extends AbstractSupportRequest {

	//Define class variables
	private final String accountName;

	//Class constructor
	public PasswordResetRequest(int id, String title, int basePoints, boolean resolved, String accountName) {

		super(id, title, basePoints, 0, resolved);
		
		//Check invariants
		if(accountName == null || accountName.isBlank()) throw new IllegalArgumentException("Password-related Request Account Name cannot be null");
		
		//Fill variables
		this.accountName = accountName;
		
	}
	
	//Override toString
	@Override 
	public String toString() {
		if(this.isResolved()==true) return this.getTitle() + " (" + this.getId() + ") on " + this.accountName + ", resolved, for " + this.getBasePoints() + " points";
		else return this.getTitle() + " (" + this.getId() + ") on " + this.accountName + ", unresolved, for " + this.getBasePoints() + " points";
	}
		
}
