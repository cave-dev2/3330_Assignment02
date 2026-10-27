package ITDeskSystemPackage;

/*
Represents setup or configuration of one or more devices.

Required additional data:
• int deviceCount (must be positive)

Resolution rule:
• awarded service points = basePoints * deviceCount
*/

public class DeviceSetupRequest extends AbstractSupportRequest {

	//Define class variables
	private final int deviceCount;

	//Class constructor
	public DeviceSetupRequest(int id, String title, int basePoints, boolean resolved, int deviceCount) {

		super(id, title, basePoints, (basePoints * (deviceCount - 1)), resolved);
		
		//Check invariants
		if(deviceCount < 0) throw new IllegalArgumentException("Device Setup Count cannot be negative");
		
		//Fill variables
		this.deviceCount = deviceCount;
		
	}
	
	//Override toString
	@Override 
	public String toString() {
		if(this.isResolved()==true) return this.getTitle() + " (" + this.getId() + ") on " + this.deviceCount + " devices, resolved, for " + this.getBasePoints() + " points";
		else return this.getTitle() + " (" + this.getId() + ") on " + this.deviceCount + " devices, unresolved, for " + this.getBasePoints() + " points";
	}
		
}
