package ITDeskSystemPackage;
import java.util.List;

/*
Create a small utility class to practice generics safely.
*/

public class HelpDeskUtil {

	// Generic method printAll 
	public static <T> void printAll(List<T> items) {
		
		// Iterate through 'items' list to print each item on its own line
		for(T i : items) {
			System.out.println(i + "\n");
		}
	}
	
	// Generic method sumPoints 
	public static int sumPoints(List<? extends Technician> technicians) {
		
		// Create sum counter variable 
		int counter = 0; 
		
		// Iterate through 'technicians' list while grabbing servicePoints values and adding them
		for(Technician tech : technicians) {
			
			counter = tech.getServicePoints() + counter;
		}
		
		// Return counter variable
		return counter; 
	}
}
