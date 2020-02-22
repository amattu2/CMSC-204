
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	/** 
	 * Student test that a new DonationPackage is created and 
	 * the manager correctly calls load the container 
	 */
	@Test
	public void testManagerLoadcontainer()   {
		try {
			manager.managerLoadContainer(new DonationPackage("Paper", 3));
			manager.managerLoadContainer(new DonationPackage("Computers", 9));
			manager.managerLoadContainer(new DonationPackage("Desks", 19));	 
		} catch (ContainerException e) {
			System.out.println("This test should have not thrown an exception");
		}	
	}
	 
	/**
	 * Student test that a new Volunteer is created and 
	 * the manager correctly queues the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new Volunteer("Alec"));
			manager.managerQueueVolunteer(new Volunteer("Test 2"));
			manager.managerQueueVolunteer(new Volunteer("Test 92"));
			manager.managerQueueVolunteer(new Volunteer("ABC"));
		} catch (VolunteerException e) {
			System.out.println("This test should have not thrown an exception");
		} 	 
	}

	/**
	 * Student test that a new Recipient is created and 
	 * the manager correctly queues the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueRecipient(new Recipient("Alec"));
			manager.managerQueueRecipient(new Recipient("Test 2"));
		} catch (RecipientException e) {
			System.out.println("This test should have not thrown an exception");
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage,
	 * testing the situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		// Variab;es
	    Volunteer v1 = new Volunteer("Alec");
	    Recipient r1 = new Recipient("UMD");
	    DonationPackage d1 = new DonationPackage("Toshiba Laptops", 4);
	    DonationPackage d2 = new DonationPackage("Speakers", 1);
	
		try {
			// Add Containers
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);
			
			// Can't donate
			assertEquals(manager.donatePackage(), 1);
			
			// Can't donate (No recipient)
			manager.managerQueueVolunteer(v1);
			assertEquals(manager.donatePackage(), 2);
			
			// Donate
			manager.managerQueueRecipient(r1);
			assertEquals(manager.donatePackage(), 0);
			
			// Can't donate (No recipient)
			assertEquals(manager.donatePackage(), 2);
		} catch (ContainerException | VolunteerException | RecipientException e) {
			// Not a problem, some tests cause an error
		}
	} 
}
