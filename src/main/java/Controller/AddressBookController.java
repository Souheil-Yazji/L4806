package Controller;

import Model.AddressBook;
import Model.BuddyInfo;
import todo.view.AddressBookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Controller class for address book, handles all operations.
 *
 * @author Souheil
 *
 */
public class AddressBookController {

    private AddressBookView view;
    private AddressBook book;

    public AddressBookController(AddressBookView view) {
        this.view = view;

        for (JMenuItem item : view.getMenuItems()) {
            item.addActionListener(new MyActionListener());
        }
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            if (item.getText().equals("Create")) {
                book = new AddressBook();
                view.updateList(book);
            }

            else if (item.getText().equals("Save")) {
                if (book == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Must create an Address Book first!");
                } else {
                    String s = "";
                    for (int j = 0; j < book.size(); j++) {
                        s += (book.getElementAt(j).toString() + "\n");
                    }
                    System.out.println(s);

                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("myBook.txt"));
                        out.append(s);
                        out.close();
                    } catch (IOException excep) {
                        // TODO Auto-generated catch block
                        excep.printStackTrace();
                    }
                }
            }

            else if (item.getText().equals("Add")) {
                if (book == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Must create an Address Book first!");
                } else {
                    String name = JOptionPane.showInputDialog(view.getFrame(), "Enter Buddy Name:");
                    String address = JOptionPane.showInputDialog(view.getFrame(), "Enter Buddy address:");
                    String phonenum = JOptionPane.showInputDialog(view.getFrame(), "Enter Buddy number:");
                    if (name == null || address == null || phonenum == null) {
                    } else {
                        BuddyInfo buddy = new BuddyInfo(name,address,phonenum);
                        book.addElement(buddy);
                    }
                }
            }

            else if (item.getText().equals("Delete")) {
                if (view.getTable().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Must select a buddy first!");
                } else {
                    int i = view.getTable().getSelectedIndex();
                    book.removeElementAt(i);
                }
            }

            else if (item.getText().equals("Edit")) {
                if (view.getTable().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Must select a buddy first!");
                } else {
                    int i = view.getTable().getSelectedIndex();
                    String name = JOptionPane.showInputDialog(view.getFrame(), "Enter new Buddy Name:");
                    String address = JOptionPane.showInputDialog(view.getFrame(), "Enter new Buddy address:");
                    String phonenum = JOptionPane.showInputDialog(view.getFrame(), "Enter new Buddy number:");
                    if (name == null || address == null || phonenum == null) {
                    } else {
                        BuddyInfo buddy = new BuddyInfo(name, address, phonenum);
                        book.setElementAt(buddy, i);
                    }
                }
            }
        }
    }
}
