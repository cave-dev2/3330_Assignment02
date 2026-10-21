package ITDeskSystemPackage;

/*
This class coordinates request storage and assignment.

Required fields (minimum):
• Map<Integer, SupportRequest> requestsById
• Map<Technician, List<SupportRequest>> assignments

Required behavior:
• addRequest(SupportRequest request)
– rejects duplicate request IDs by throwing IllegalArgumentException
• SupportRequest findRequest(int id) returns the matching request or null if not found
• assignRequest(Technician technician, int requestId)
– assigns an existing request to a technician
– decide whether the same request can be assigned more than once to the same technician
and enforce your rule consistently
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

}
