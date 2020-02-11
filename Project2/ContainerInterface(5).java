
import java.util.EmptyStackException;

/**
 * Container Interface represents the interface for the Container Class
 
 * The class that uses this  interface uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from the container.
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
 
public interface ContainerInterface {
	/**
	 * Provide two constructors:
	 * Container(int size) make the internal stack this size
	 * Container() make the internal stack a default size
	 */
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException;
	 
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public  DonationPackage removePackageFromContainer() throws ContainerException;

	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	public DonationPackage[] toArrayPackage();

}
