package ITDeskSystemPackage;

/*
This class coordinates request storage and assignment.

Required fields (minimum):
• Map<Integer, SupportRequest> requestsById
• Map<Technician, List<SupportRequest>> assignments

Required behavior:
• int resolveRequest(Technician technician, int requestId)
– finds the request in that technician’s assignments
– calls request.resolveFor(technician) polymorphically
– returns the service points awarded
• void printAllRequests()
• void printAssignmentsFor(Technician technician)

Design requirements:
• Keep fields private.
• Do not expose internal collections directly.
• Avoid long message chains and knowledge leaks.
• The help desk should not perform type checking such as if (request instanceof DeviceSetupRequest).
• Request-specific behavior belongs in the request classes, not in HelpDesk.
• Keep HelpDesk focused on coordination rather than turning it into a god class.
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
		if (this.requestsById.containsKey(request.getId())) {
			
			// If ID is found, return support request 
			return this.requestsById.get(id); 
		}
		
		// If ID doesn't exist, return null
		else {
			return null; 
		}
	}
	
	// assignRequest method 
	public string assignRequest(Technician technician, int requestId) {
		
		// We choose to only allow for a request to be assigned to a technician one time. 
		
		// Find the desired SupportRequest 
		this.findRequest(requestId);
		
		// Validate that request exists 
		if(this.findRequest(requestId) == null) {
			throw new IllegalArgumentException("Request does not exist.");
		}
		
		// Validate taht technician is not null
	    if (technician == null) {
	        throw new IllegalArgumentException("Technician cannot be null");
	    }
		
		// Validate that desired technician exists in assignments 
		if(this.assignments.containsKey(technicican)) {
			
			// Isolate technician's assigned requests 
			List<SupportRequest> technicicanRequests = this.assignments.get(technician);
					
			// Validate that technician has not been assigned the task already 
			if(technicianRequests.contains(request)) {
				throw new IllegalArgumentException(technician + " already assigned to this request.");
			}
			
			// If technician hasn't already been assigned the request, add to assignments
			technicianRequests.add(request); 
			return technician + " assigned to request.";
		}
		
		// If technician does not currently have a list of assignments, create one 
		else {
			
			// Create SupportRequest list 
			List<SupportRequest> technicianRequests = new ArrayList(); 
			
			// Add request 
			technicianRequests.add(request);
			
			// Add technician assignment to the current object's map
			this.assignments.put(technician, technicianRequests);
			
			// Return message 
			return "Created assignment list for " + technician; 
			}
	}
		
		// resolveRequest method 
		public int resolveRequest(Technicican technician, int requestId) {
					
			// If passed technicican does not have an assignment list, throw an IllegalArgumentException
			if(this.assignments.containsKey(technicican)) {
				
				// Isolate technician's assignments
				List<SupportRequest> technicianRequests = this.assignments.get(technicican)
						
				// Validate that passed requestId is found in technician's assignments
				if(technicianRequests.containsKey(requestId)) {
					
					// If both technician and requestId exist as expected, 
					// resolve request and return the service points awarded.
					this.requestsById.get(requestId).resolveFor(technician);
					return requestsById.getBasePoints(); 
				}
			}
		}
		
		// printAllRequests() method 
		public void printAllRequests() {
			
			// Loop through current HelpDesk object's requestsById field to print each one
			for(request in this.requestsById) {
				System.out.println(request + "\n");
			}
		}
		
		// printAssignmentsFor() method 
		public void printAssignmentsFor(Technician technician) {
			
			// Check that technician's assignment list is not null 
			if(this.assignments.get(technician) != null) {
				
				// If technician has an assignment list that is not null, 
				// print each request associated with the technicican 
				System.out.println("Assignments for " + technician + ":");
				for(request in this.assignments.get(technician)) {
					System.out.println(request + "\n");
				}
			}
			
			// If technician's assignment list is null, return error message 
			else {
				System.out.println(technician + " has a null assignment list.");
			}
		}
		
}
