/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class Container implements ContainerInterface {
	// Variables
	private MyStack<DonationPackage> packages;
	
	/**
	 * Constructor method
	 */
	public Container() {
		this.packages = new MyStack<DonationPackage>(10);
	}
	
	/**
	 * Constructor method
	 * 
	 * @param Int size
	 */
	public Container(int size) {
		this.packages = new MyStack<DonationPackage>(size);
	}
	
	/**
	 * Add package to list
	 * 
	 * @param DonationPackage package
	 * @return Boolean success
	 * @throws ContainerException
	 */
	@Override
	public boolean loadContainer(DonationPackage p) throws ContainerException {
		// Variables
		boolean success = this.packages.push(p);
		
		// Checks
		if (!success) {
			throw new ContainerException("The Container is Full");
		}
		
		// Return
		return success;
	}

	/**
	 * Remove first package from the container
	 * 
	 * @return DonationPackage package
	 * @throws ContainerException
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		// Variables
		DonationPackage pkg = this.packages.pop();
		
		// Checks
		if (pkg == null) {
			throw new ContainerException("The Container is Empty");
		}
		
		// Return
		return pkg;
	}
	
	/**
	 * Convert packages to an array
	 * 
	 * @return DonationPackage[] array
	 */
	@Override
	public DonationPackage[] toArrayPackage() {
		// Variables
		DonationPackage[] newA = new DonationPackage[this.packages.size()];
		Object[] oldA = this.packages.toArray();
		int i = 0;
		
		// Loops
		for (Object pkg : oldA) {
			newA[i++] = (DonationPackage) pkg;
		}
		
		// Return
		return newA;
	}
}
