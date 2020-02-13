/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class Container implements ContainerInterface {
	public Container(int i) {
		
	}

	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		return false;
	}

	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		return null;
	}

	@Override
	public DonationPackage[] toArrayPackage() {
		return null;
	}

}
