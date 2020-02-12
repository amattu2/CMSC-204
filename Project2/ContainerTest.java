
import static org.junit.Assert.*;

import java.util.EmptyStackException;
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author revised by Professor Kartchner
 *
 */
public class ContainerTest {
	Container aContainer;
	DonationPackage dpk1, dpk2 ,dpk3,dpk4,dpk5,dpk6;
	@Before
	public void setUp() throws Exception {
		dpk1 = new DonationPackage("Pens", 10);
		dpk2 = new DonationPackage("Books", 12);
		dpk3 = new DonationPackage("Papers", 5);
		dpk4 = new DonationPackage("Folders", 9);
		dpk5 = new DonationPackage("Erasers", 10);
		dpk6 = new DonationPackage("Miscellaneous", 10);
		aContainer = new Container(5);
		 
		
	}

	@After
	public void tearDown() throws Exception {
		dpk1=dpk2=dpk3=dpk4=dpk5=dpk6=null;
		aContainer=null;
	}

	@Test
	public void testLoadContainer() {
		 
		try {
			assertTrue(aContainer.loadContainer(dpk1));
			assertTrue(aContainer.loadContainer(dpk2));
			assertTrue(aContainer.loadContainer(dpk3));
			assertTrue(aContainer.loadContainer(dpk4));
			assertTrue(aContainer.loadContainer(dpk5));

		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}
		
		try {
			aContainer.loadContainer(dpk6);
			assertTrue("This should have thrown an exception", false);
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			assertTrue("This should have thrown an exception", true);
		}
		 
	}
	@Test
	public void tesRemovePackageFromContainer() {
		DonationPackage temp;
		 
		try {
			aContainer.loadContainer(dpk1);
			aContainer.loadContainer(dpk2);
			temp= aContainer.removePackageFromContainer();
			assertEquals(temp.getDescription(), "Books");
			temp= aContainer.removePackageFromContainer();
			assertEquals(temp.getDescription(), "Pens");
			aContainer.removePackageFromContainer();

		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			assertTrue("This should have thrown an exception, No more packages", true);
		}

	}
	@Test
	public void testToArrayPackage() {
		try {
			aContainer.loadContainer(dpk1);
		} catch (ContainerException e1) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}

		assertEquals(aContainer.toArrayPackage()[0].getDescription(), "Pens");
		try {
			aContainer.loadContainer(dpk2);
			aContainer.loadContainer(dpk3);
			aContainer.loadContainer(dpk4);
			aContainer.loadContainer(dpk5);
		} catch (ContainerException e1) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}
		assertEquals(aContainer.toArrayPackage()[1].getDescription(), "Books");
		assertEquals(aContainer.toArrayPackage()[2].getDescription(), "Papers");
		assertEquals(aContainer.toArrayPackage()[3].getDescription(), "Folders");
		assertEquals(aContainer.toArrayPackage()[4].getDescription(), "Erasers");
	}

}
