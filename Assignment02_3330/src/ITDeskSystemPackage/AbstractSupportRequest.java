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

public class AbstractSupportRequest {

}
