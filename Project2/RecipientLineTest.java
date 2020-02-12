
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
public class RecipientLineTest {

	RecipientLine aRecipientLine;
	Recipient r1, r2, r3, r4, r5, r6;

	@Before
	public void setUp() throws Exception {
		aRecipientLine = new RecipientLine(5);
		r1 = new Recipient("rc1");
		r2 = new Recipient("rc2");
		r3 = new Recipient("rc3");
		r4 = new Recipient("rc4");
		r5 = new Recipient("rc5");
		r6 = new Recipient("rc6");
	}

	@After
	public void tearDown() throws Exception {
		aRecipientLine = null;
		r1 = r2 = r3 = r4 = r5 = null;
	}

	@Test
	public void testAddNewRecepient() {

		try {
			assertTrue(aRecipientLine.addNewRecipient(r1));
			assertTrue(aRecipientLine.addNewRecipient(r2));
			assertTrue(aRecipientLine.addNewRecipient(r3));
			assertTrue(aRecipientLine.addNewRecipient(r4));
			assertTrue(aRecipientLine.addNewRecipient(r5));
		} catch (RecipientException e) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}
		
		try {
			assertFalse(aRecipientLine.addNewRecipient(r6));
			assertTrue("This should have thrown an exception", false);
		} catch (RecipientException e) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", true);
		}

	}

	@Test
	public void tesRecipientTurn() {
		Recipient temp;
		try {
			try {
				aRecipientLine.addNewRecipient(r1);
				aRecipientLine.addNewRecipient(r2);
			} catch (RecipientException e) {
				// TODO Auto-generated catch block
				assertTrue("This should not have thrown an exception", false);
			}

			try {
				temp = aRecipientLine.recipientTurn();
				assertEquals(temp.getName(), "rc1");
				temp = aRecipientLine.recipientTurn();
				assertEquals(temp.getName(), "rc2");
			} catch (RecipientException e) {
				// TODO Auto-generated catch block
				assertTrue("This should not have thrown an exception", false);
			}
			
			try {
				aRecipientLine.recipientTurn();
				assertTrue("This should have thrown an exception", false);
			} catch (RecipientException e) {
				// TODO Auto-generated catch block
				assertTrue("This should have thrown an exception, No more recipients", true);
			}

		} catch (NoSuchElementException e) {
			System.out.println("No more recipient");
		}

	}

	@Test
	public void testToArrayRecipient() {
		try {
			aRecipientLine.addNewRecipient(r1);
		} catch (RecipientException e1) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}

		assertEquals(aRecipientLine.toArrayRecipient()[0].getName(), "rc1");
		try {
			aRecipientLine.addNewRecipient(r2);
			aRecipientLine.addNewRecipient(r3);
			aRecipientLine.addNewRecipient(r4);
			aRecipientLine.addNewRecipient(r5);
		} catch (RecipientException e1) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}
		
		assertEquals(aRecipientLine.toArrayRecipient()[1].getName(), "rc2");
		assertEquals(aRecipientLine.toArrayRecipient()[2].getName(), "rc3");
		assertEquals(aRecipientLine.toArrayRecipient()[3].getName(), "rc4");
		assertEquals(aRecipientLine.toArrayRecipient()[4].getName(), "rc5");

	}

}
