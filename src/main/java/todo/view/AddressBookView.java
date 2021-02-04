package todo.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import Model.AddressBook;
import Model.BuddyInfo;

/**
 * todo.View class for address book.
 *
 *
 * @author Souheil
 *
 */
public class AddressBookView extends JFrame{

    private JPanel panel;
    private JList<BuddyInfo> list;
    private JMenuBar menuBar;
    private JMenu addressMenu, buddyMenu;
    private JMenuItem create, save, add, delete, edit;
    private ArrayList<JMenuItem> items;

    public AddressBookView() {
    }

    /**
     * Initialize todo.View
     *
     */
    public void init() {
        this.setTitle("Address Book");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(250, 250);
        this.setLocation(300,200);
        panel = new JPanel();

        panel.setLayout(new GridLayout(1,1));

        //------------ PANEL -------------//
        list = new JList<BuddyInfo>();
        this.getContentPane().add(panel);
        panel.add(list);

        //------------ MENU -------------//
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        addressMenu = new JMenu("Address Book");
        menuBar.add(addressMenu);

        buddyMenu = new JMenu("Buddy Info");
        menuBar.add(buddyMenu);
        items = new ArrayList<JMenuItem>();

        create = new JMenuItem("Create");
        addressMenu.add(create);
        items.add(create);
        save = new JMenuItem("Save");
        addressMenu.add(save);
        items.add(save);
        add = new JMenuItem("Add");
        buddyMenu.add(add);
        items.add(add);
        delete = new JMenuItem("Delete");
        buddyMenu.add(delete);
        items.add(delete);
        edit = new JMenuItem("Edit");
        buddyMenu.add(edit);
        items.add(edit);

        setVisible(true);
    }

    public ArrayList<JMenuItem> getMenuItems() {
        return items;
    }

    public void updateList(AddressBook book) {
        list.setModel(book);
    }

    public JList<BuddyInfo> getTable() {
        return list;
    }

    public JFrame getFrame() {
        return this;
    }
}
