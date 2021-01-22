
/**
 *
 * @author souheilyazji
 *
 */
public class BuddyInfo {

    private String name, address, phoneNumber;

    /**
     *
     */
    public BuddyInfo(String name, String address, String phoneNumber) {
//        super();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }
    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    public static void main(String[] args) {
//		BuddyInfo bud = new BuddyInfo("Homer","382 Hampshire","3134214");
//		System.out.println("Hello " + bud.getName());
//    }

}
