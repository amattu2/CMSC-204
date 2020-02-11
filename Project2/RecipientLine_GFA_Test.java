
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
public class RecipientLine_GFA_Test {

	RecipientLine aRecipientLine;
	Recipient r1;

	@Before
	public void setUp() throws Exception {
		aRecipientLine = new RecipientLine(5);
		r1 = new Recipient("rc1");
	}

	@After
	public void tearDown() throws Exception {
		aRecipientLine = null;
		r1 = null;
	}

	@Test
	public void testAddNewRecipient() {

		try {
			assertTrue(aRecipientLine.addNewRecipient(r1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}
	}
}
