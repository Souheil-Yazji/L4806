import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook book1;
    private BuddyInfo buddy1, buddy2;


    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
        book1 = new AddressBook();
        buddy1 = new BuddyInfo("Buddy1", "2525 Colonel by dr.", "6137007777");
        buddy2 = new BuddyInfo("Buddy2", "2525 Colonel by dr.", "6137007777");
    }


    @Test
    public void testBuddy() {
        System.out.println("Testing add buddy!");

        assertEquals(0, book1.size());    //empty
        book1.addBuddy(buddy1);
        assertEquals(1, book1.size());    //add first buddy
        book1.addBuddy(buddy2);
        assertEquals(2, book1.size());    //add second buddy

        System.out.println("Testing remove buddy!");

        book1.removeBuddy(1);
        assertEquals(1, book1.size());    //remove first buddy
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        book1 = null;
        buddy1 = null;
        buddy2 = null;
        assertNull(book1);
    }

}