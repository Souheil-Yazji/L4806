package Model;

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
public class AddressBook extends DefaultListModel<BuddyInfo> {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfos;
    @Id
    @GeneratedValue
    private Integer id;

    public AddressBook() {
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
     * @param index - remove at index
     */
    public void removeBuddy(int index) {
        if (index > 0 && index < buddyInfos.size()) {
            buddyInfos.remove(index);
        }
    }

    /**
     *
     * @return size of the buddyInfos list
     */
    public int size() {
        return buddyInfos.size();
    }

    public void printBuddies(){
        System.out.println("Buddies:");
        for(BuddyInfo b : buddyInfos) {
            System.out.println(b.getName());
        }
    }

    /**
     * Overload addElement to add BuddyInfos to both the DefaultListModel and buddyList
     * @param element The BuddyInfo to add
     */
    @Transient
    @Override
    public void addElement(BuddyInfo element){
        super.addElement(element);
        this.buddyInfos.add(element);
    }

    /**
     * Overload remove to remove BuddyInfos to both the DefaultListModel and buddyList
     * @param index The index to remove the BuddyInfo
     */
    @Transient
    @Override
    public void removeElementAt(int index){
        super.remove(index);
        this.buddyInfos.remove(index);
    }

    /**
     * Overload set to set an element at index to both the DefaultListModel and buddyList
     * @param index The index to add the BuddyInfo
     * @param element The element to add to the list/model
     */
    @Transient
    @Override
    public void setElementAt(BuddyInfo element, int index){
        super.set(index, element);
        this.buddyInfos.set(index, element);
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