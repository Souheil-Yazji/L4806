import java.util.*;

/**
 * A book to keep buddyInfo in
 *
 * @author souheilyazji
 *
 *
 */
public class AddressBook {


    private List<BuddyInfo> buddyInfos;

    public AddressBook() {
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    /**
     * add not null buddy into the book
     * @param buddy - budy to be added to book
     */
    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            buddyInfos.add(buddy);
        }
    }

    /**
     * remove buddy from book
     * @param index - remove at index
     */
    public void removeBuddy(int index) {
        if (index > 0 && index < buddyInfos.size()) {
            buddyInfos.remove(index);
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		System.out.println("Address book");
        AddressBook book1 = new AddressBook();
        BuddyInfo bud1 = new BuddyInfo("SY", "2525 Colonel by dr.", "6137007777");
        book1.addBuddy(bud1);
        book1.removeBuddy(0);
    }

    public int size() {
        return buddyInfos.size();
    }
}