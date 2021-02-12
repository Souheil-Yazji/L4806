package SYSoft.AddressBook;

import javax.persistence.*;
import javax.swing.*;
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

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfos;
    @Id
    @GeneratedValue
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

//    @Override
//    @Transient
//    public String toString(){
//        String s = "";
//        for(Model.BuddyInfo b : buddyInfos){
//            s += buddyInfos.toString() + "\n";
//        }
//        return s;
//    }

}