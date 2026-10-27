package ITDeskSystemPackage;

/*
Create an abstract base class that implements the shared parts of SupportRequest.

Required data:
• int id
• String title
• int basePoints
• boolean resolved

Required invariants:
• id > 0
• title is not null or blank
• basePoints > 0

Required behavior:
• Constructor validates invariants and throws IllegalArgumentException for invalid input
• Common getters
• Shared resolved-state handling
• A useful toString()

A request should not be resolved more than once. A repeated resolution attempt should fail
consistently, preferably by throwing IllegalStateException.
*/

public class AbstractSupportRequest implements SupportRequest {

	//Define class variables
	private final int id; 
	private final String title;
	private final int basePoints;
	private boolean resolved;

	//Class constructor
	public AbstractSupportRequest(int id, String title, int basePoints, boolean resolved) {

		//Check invariants
		if(basePoints <= 0) throw new IllegalArgumentException("Support Request ID cannot be negative");
		if(title == null || title.isBlank()) throw new IllegalArgumentException("Support Request Title cannot be null"); 
		if(basePoints < 0) throw new IllegalArgumentException("Support Request cannot reward negative points");
		
		//Fill variables
		this.id = id; 
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = resolved;
		
	}
	
	//Override toString
	@Override 
	public String toString() {
		if(resolved==true) return this.title + " (" + this.id + "), resolved, for " + this.basePoints + " points";
		else return this.title + " (" + this.id + "), unresolved, for " + this.basePoints + " points";
	}
	
	//Getters
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getBasePoints() {
		return this.basePoints;
	}
	
	public boolean isResolved() {
		return this.resolved;
	}
	
	//Resolver
	public int resolveFor(Technician technician) {
		
		//Check valid resolution
		if(this.resolved==true) throw new IllegalArgumentException("Support Request cannot be resolved twice");
		
		this.resolved = true;
		technician.addPoints(basePoints);
		return basePoints;
		
	}
		
}
