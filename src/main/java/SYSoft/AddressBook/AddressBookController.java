package SYSoft.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddressBookController {

    private AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository){
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping(value = "/addressbook", method = RequestMethod.POST)
    public AddressBook addAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @RequestMapping(value = "/addressbook", method = RequestMethod.GET)
    public AddressBook getAddressBook(@RequestParam("id") Long id){
        return addressBookRepository.findById(id).get();
    }

}
