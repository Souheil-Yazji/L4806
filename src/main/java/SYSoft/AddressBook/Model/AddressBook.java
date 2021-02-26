package SYSoft.AddressBook.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

/**
 * A book to keep buddyInfo in
 *
 * @author souheilyazji
 *
 *
 */
@Entity
public class AddressBook {


    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<BuddyInfo> buddyInfos;

    @Id
    @GeneratedValue()
    private long id;


    public AddressBook() {
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * add not null buddy into the book
     * @param buddy - buddy to be added to book
     */
    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            buddyInfos.add(buddy);
        }
    }

    /**
     * remove buddy from book
     * @param id - remove by id
     */
    public void removeBuddy(int id) {
        for (int i = 0; i < getSize(); i++){
            if (buddyInfos.get(i).getId() == id) {
                buddyInfos.remove(i);
            }
        }

    }

    public BuddyInfo getBuddy(int index) {
        return buddyInfos.get(index);
    }

    /**
     *
     * @return size of the buddyInfos list
     */
    public int getSize() {
        return buddyInfos.size();
    }

    /**
     * print all buddy objects in this address book
     */
    public void printBuddies(){
        System.out.println("Buddies:");
        for(BuddyInfo b : buddyInfos) {
            System.out.println(b.getName());
        }
    }


    public List<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    public void setBuddyInfos(List<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }



    @Override
    @Transient
    public String toString(){
        String s = "contents of book " + id + ":\n";
//        s += buddyInfos.toString() + "\n";

        for(BuddyInfo b : buddyInfos){
            s += b.toString();
        }
        return s;
    }

}