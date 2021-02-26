package SYSoft.AddressBook.Controller;

import SYSoft.AddressBook.Model.AddressBook;
import SYSoft.AddressBook.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This class provides a REST endpoint for the application.
 *
 * @author Souheil
 */
@RestController
public class AddressBookRestController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * Post a new addressbook
     * @return
     */
    @RequestMapping(value = "/addressbook", method = RequestMethod.POST)
    public AddressBook addAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    /**
     * Show the contents of the addressbook
     *
     * @param id the id of the addressbook to be shown
     * @return string representation of the addressbook contents
     */
    @RequestMapping(value = "/addressbook", method = RequestMethod.GET)
    public AddressBook getAddressBook(@RequestParam("id") Long id){
        return addressBookRepository.findById(id).get();
    }



}
