/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class DonationPackage {
	// Variables
	private String d = "";
	private double w = 0;
	
	/**
	 * Create a new donation package instance
	 * 
	 * @param String package description
	 * @param Double package weight
	 */
	public DonationPackage(String description, double weight) {
		this.d = description;
		this.w = weight;
	}
	
	/**
	 * Return donation package description
	 * 
	 * @return String description
	 */
	public String getDescription() {
		return this.d;
	}
	
	/**
	 * Return donation package weight evaluation
	 * 
	 * @return Boolean package too heavy
	 */
	public boolean isHeavy() {
		return this.w >= 20;
	}
}
