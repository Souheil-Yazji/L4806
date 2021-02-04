import Model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo buddy1;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting it up!");
        buddy1 = new BuddyInfo();
    }

    @Test
    public void setName() {
        buddy1.setName("Buddy2");
        assertEquals("Buddy2", buddy1.getName());
    }

    @Test
    public void setAddress() {
        buddy1.setAddress("Fake Address");
        assertEquals("Fake Address", buddy1.getAddress());
    }

    @Test
    public void setPhoneNumber() {
        buddy1.setPhoneNumber("18001119999");
        assertEquals("18001119999", buddy1.getPhoneNumber());
    }
}