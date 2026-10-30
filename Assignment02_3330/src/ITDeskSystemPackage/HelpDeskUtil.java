package ITDeskSystemPackage;

/*
Create a small utility class to practice generics safely.

Requirement A: Generic method
• Implement public static <T> void printAll(List<T> items)
• It prints each item on its own line using toString().
Requirement B: Wildcard method
• Implement public static int sumPoints(List<? extends Technician> technicians)

The method returns the total service points across all technicians in the list.
The upper-bounded wildcard allows the method to work with Technician objects or any future
subclass of Technician, while safely reading them as Technician. You are not required to create
any technician subclasses for this assignment.
*/

public class HelpDeskUtil {

	// Generic method printAll 
	public static <T> void printAll(List<T> items) {
		
		// Iterate through 'items' list to print each item on its own line
		for(i in items) {
			System.out.println(i + "\n");
		}
	}
	
	// Generic method sumPoints 
	public static int sumPoints(List<? extends Technician> technicians) {
		
		// Create sum counter variable 
		private int counter = 0; 
		
		// Iterate through 'technicians' list while grabbing servicePoints values and adding them
		for(tech in technicians) {
			
			counter = tech.getServicePoints() + counter;
		}
		
		// Return counter variable
		return counter; 
	}
}
