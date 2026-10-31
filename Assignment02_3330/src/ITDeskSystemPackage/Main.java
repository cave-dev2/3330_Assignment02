package ITDeskSystemPackage;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/*
Hardcoded demonstration of ITDeskSystemPackage
Created by: Brendan Treleven and Jace Ellis
*/

public class Main {

	public static void main(String[] args) {

		// --- Create at least 3 technicians, including two with the same name ---
		Technician chrisL = new Technician("Chris L", 0); 
		Technician leonardE = new Technician("Leonard", 15); 
		Technician chrisK = new Technician("Chris K", 15); 
		Technician chrisKuntz = new Technician("Chris K", 5);
		
		// --- Create at least 6 support requests total ---
		// 2 DeviceSetupRequest objects 
		DeviceSetupRequest labDesktopSetupRequest = new DeviceSetupRequest(
					10, "Set up Lab Desktops", 
					20, false, 25
				);
		
		DeviceSetupRequest projectorSetupRequest = new DeviceSetupRequest(
					11, "Set up Projector", 
					5, false, 1
				);
		
		// 2 NetworkIssueRequest objects 
		NetworkIssueRequest cafeteriaNetworkRequest = new NetworkIssueRequest(
					20, "Cafeteria Network Outage", 
					50, false, 300
				);
		
		NetworkIssueRequest mcdavidF1NetworkRequest = new NetworkIssueRequest(
					21, "McDavid Hall Floor 1 Network Outage", 
					30, false, 20
				);
		
		// 2 PasswordResetRequest objects 
		PasswordResetRequest user2078PasswordRequest = new PasswordResetRequest(
					30, "User ****2078 Password Reset Request", 
					5, false, "jmendm@missouri.edu"
				);
				
		PasswordResetRequest user1945PasswordRequest = new PasswordResetRequest(
					31, "User ****1945 Password Reset Request", 
					5, false, "truman@missouri.edu"
				);
		
		// -- Add requests to the help desk --
		// Create and populate requestsById map 
		Map<Integer, SupportRequest> requestsById = new HashMap<>();
		
		requestsById.put(10, labDesktopSetupRequest); 
		requestsById.put(11, projectorSetupRequest); 
		
		requestsById.put(20, cafeteriaNetworkRequest); 
		requestsById.put(21, mcdavidF1NetworkRequest); 
		
		requestsById.put(30, user2078PasswordRequest); 
		requestsById.put(31, user1945PasswordRequest);
		
		// Create and populate assignments map
		Map<Technician, List<SupportRequest>> assignments = new HashMap<>(); 
		
		List<SupportRequest> chrisLRequests = new ArrayList<>();
		List<SupportRequest> leonardERequests = new ArrayList<>();
		List<SupportRequest> chrisKRequests = new ArrayList<>();
		
		assignments.put(chrisL, chrisLRequests);
		assignments.put(leonardE, leonardERequests);
		assignments.put(chrisK, chrisKRequests);
		
		// Call HelpDesk constructor
		HelpDesk helpDesk = new HelpDesk(requestsById, assignments);
		
		// --- Assign at least 4 requests across at least 2 technicians ---
		helpDesk.assignRequest(chrisL, 10); 
		helpDesk.assignRequest(chrisL, 20); 
		
		helpDesk.assignRequest(leonardE, 30); 
		helpDesk.assignRequest(chrisK, 21); 
		helpDesk.assignRequest(chrisKuntz, 11); 
		
		// --- Resolve at least 3 requests across different request types --- 
		helpDesk.resolveRequest(chrisL, 10); 
		helpDesk.resolveRequest(chrisK, 21);
		helpDesk.resolveRequest(leonardE, 30);
		
		// --- Print all requests ---
		System.out.println("   Print all requests: ");
		helpDesk.printAllRequests(); 
		
		// --- Print assignments for each technician --- 
		System.out.println("\n   Print Assignments for each technician: ");
		List<Technician> techList = new ArrayList<>(assignments.keySet()); 
		
		for(Technician tech : techList) {
			helpDesk.printAssignmentsFor(tech);
		}
		
		// ---  Print final technician service point totals ---
		System.out.println("\n   Print final technician service points totals: ");
		for(Technician tech : techList) {
			System.out.println(tech);
		}
		
		// --- Use HelpDeskUtil.sumPoints to print the total service points across technicians --- 
		System.out.println("\n   Total service points across technicians: " + HelpDeskUtil.sumPoints(techList));
		
		// Fail-fast error checking example: 
		// Assigning a request to a technician who is not in the HelpDesk object
		System.out.println("\n   Fail-Fast error checking:");
		Technician jaceE = new Technician("Jace", 0); 
		try {
			helpDesk.assignRequest(jaceE, 31); 
		} catch(IllegalArgumentException e) {
			System.out.println("Expected exception: " + e.getMessage());
		}
				
		// Assigning a requestId that does not exist to a technician in the HelpDesk object
		try {
		    helpDesk.assignRequest(chrisK, 12);
		} catch (IllegalArgumentException e) {
		    System.out.println("Expected exception: " + e.getMessage());
		}
		
	}

}
