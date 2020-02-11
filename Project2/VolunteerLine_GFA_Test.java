
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author revised by Professor Kartchner
 *
 */
public class VolunteerLine_GFA_Test {

	VolunteerLine aVolunteerLine;
	Volunteer v1;

	@Before
	public void setUp() throws Exception {
		aVolunteerLine = new VolunteerLine(5);
		v1 = new Volunteer("vol1");
	}

	@After
	public void tearDown() throws Exception {
		aVolunteerLine = null;
		v1 = null;
	}

	@Test
	public void testAddNewVolunteer() {

		try {
			assertTrue(aVolunteerLine.addNewVolunteer(v1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}
	}
}
