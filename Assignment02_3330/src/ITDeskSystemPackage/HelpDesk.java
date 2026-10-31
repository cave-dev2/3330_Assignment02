package ITDeskSystemPackage;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/*
This class coordinates request storage and assignment.
*/

public class HelpDesk {
	
	// Private class fields requestsById and assignments
	private Map<Integer, SupportRequest> requestsById; 
	private Map<Technician, List<SupportRequest>> assignments; 
	
	// Class constructor 
	public HelpDesk(Map<Integer, SupportRequest> requestsById, Map<Technician, List<SupportRequest>> assignments) {
		
		// Assign class fields
		this.requestsById = requestsById; 
		this.assignments = assignments; 
	}
	
	// Default constructor for an empty HelpDesk object
	public HelpDesk() {
	    this.requestsById = new HashMap<>();
	    this.assignments = new HashMap<>();
	}
	
	// Class methods: 
	
	// addRequest method
	public void addRequest(SupportRequest request) {

	    // Validate that request ID does not already exist
	    if (this.requestsById.containsKey(request.getId())) {
	        throw new IllegalArgumentException("Request ID already exists");
	    }

	    // If request is valid, add to current HelpDesk object
	    this.requestsById.put(request.getId(), request);
	}
	
	// findRequest method 
	public SupportRequest findRequest(int id) {
		
		// Search for support request using corresponding ID
		if (this.requestsById.containsKey(id)) {
			
			// If ID is found, return support request 
			return this.requestsById.get(id); 
		}
		
		// If ID doesn't exist, return null
		else {
			return null; 
		}
	}
	
	// assignRequest method 
	public String assignRequest(Technician technician, int requestId) {
		
		// We choose to only allow for a request to be assigned to a technician one time. 
		
		// Find the desired SupportRequest 
		SupportRequest request = this.findRequest(requestId);
		
		// Validate that request exists 
		if(this.findRequest(requestId) == null) {
			throw new IllegalArgumentException("Request ID does not exist");
		}
		
		// Validate that desired technician exists in assignments 
		if(this.assignments.containsKey(technician)) {
			
			// Isolate technician's assigned requests 
			List<SupportRequest> technicianRequests = this.assignments.get(technician);
					
			// Validate that technician has not been assigned the task already 
			if(technicianRequests.contains(request)) {
				throw new IllegalArgumentException(technician + " already assigned to this request");
			}
			
			// If technician hasn't already been assigned the request, add to assignments
			technicianRequests.add(request); 
			return technician + " assigned to request.";
		}
		
		// If technician is not found in HelpDesk object, throw IllegalArgumentException  
		else {
			
			throw new IllegalArgumentException("Technician not found in Help Desk");
			
			}
	}
		
		// resolveRequest method 
		public int resolveRequest(Technician technician, int requestId) {
					
			// If passed technician does not have an assignment list, throw an IllegalArgumentException
			if(this.assignments.containsKey(technician)) {
				
				// Isolate technician's assignments
				List<SupportRequest> technicianRequests = this.assignments.get(technician);
				
				// Loop through technicianRequests to validate that technician has been assigned to the request
				for(SupportRequest request : technicianRequests) {
					
					// Once request is found, call resolveFor() method and return points awarded
					int currentId = request.getId();
					if(currentId == requestId) {
						int pointsAwarded = this.requestsById.get(requestId).resolveFor(technician);
						return pointsAwarded; 
					}
					
				}
				// If request isn't found, throw IllegalArgumentException 
				throw new IllegalArgumentException("Request not assigned to this technician");
			}
		
			// If passed technician does not have an assignment list, throw an IllegalArgumentException
			else {
				throw new IllegalArgumentException("Technician not present in assignment list");
			}

		}
		
		// printAllRequests() method 
		public void printAllRequests() {
			
			// Loop through current HelpDesk object's requestsById field to print each one
			List<SupportRequest> requestList = new ArrayList<>(this.requestsById.values()); 
			for(SupportRequest request : requestList) {
				System.out.println(request);
			}
		}
		
		// printAssignmentsFor() method 
		public void printAssignmentsFor(Technician technician) {
			
			// Check that technician's assignment list is not null 
			if(this.assignments.get(technician) != null) {
				
				// If technician has an assignment list that is not null, 
				// print each request associated with the technician 
				System.out.println("Assignments for " + technician + ":");
				for(SupportRequest request : this.assignments.get(technician)) {
					System.out.println(request);
				}
			}
			
			// If technician's assignment list is null, return error message 
			else {
				System.out.println(technician + " has a null assignment list.");
			}
		}
		
}
