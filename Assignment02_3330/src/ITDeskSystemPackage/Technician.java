package ITDeskSystemPackage;

/*
Represents an IT technician who can be assigned support requests.

Required data:
• String name (not null or blank)
• int servicePoints (starts at 0 and must never become negative)

Required behavior:
• Constructor validates the technician name
• addPoints(int amount) with fail-fast validation
• getServicePoints()
• toString() includes the technician name and service points

Required equals and hashCode: Technicians will be stored in a HashSet<Technician>.
Implement equals and hashCode so that two Technician objects are considered equal when their
name values match exactly.
Your equals and hashCode implementations must be consistent with each other.
*/

import java.util.Objects;

public class Technician {

	//Define class variables
	private final String name; 
	private int servicePoints; 

	//Class constructor
	public Technician(String name, int servicePoints) {

		//Check invariants
		if(name == null || name.isBlank()) throw new IllegalArgumentException("Technician Name cannot be null"); 
		if(servicePoints < 0) throw new IllegalArgumentException("Technician Service Points cannot be negative");
		
		//Fill variables
		this.name = name; 
		this.servicePoints = servicePoints;
		
	}
	
	//Override toString
	@Override 
	public String toString() {
		return this.name + " (" + this.servicePoints + " points)";
	}
	
	//Override equals to compare name
    @Override
    public boolean equals(Object obj) {

        //Check valid equals
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        //Compare Technician names
        Technician tec = (Technician) obj;
        return Objects.equals(name, tec.name);
        
    }
    
    //Override hashCode to mirror equals
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
	
	//Adders & Getters
	public int addPoints(int amount) {
		
		if(servicePoints + amount < 0) throw new IllegalArgumentException("Technician Service Points cannot be negative");
		this.servicePoints += amount;
		return this.servicePoints;
		
	}
	
	public int getServicePoints() {
		return this.servicePoints;
	}
		
}
