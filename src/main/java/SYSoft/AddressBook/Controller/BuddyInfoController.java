package SYSoft.AddressBook.Controller;

import SYSoft.AddressBook.Model.AddressBook;
import SYSoft.AddressBook.Model.BuddyInfo;
import SYSoft.AddressBook.Repository.AddressBookRepository;
import SYSoft.AddressBook.Repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class provides a REST endpoint for interacting with Buddyinfo objects.
 *
 * @author Souheil
 */
@RestController
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;
    @Autowired
    private AddressBookRepository addressBookRepository;


    @RequestMapping(value = "/addressbook/buddy", method = RequestMethod.GET)
    public BuddyInfo getBuddy(@RequestParam("bookId") Long bookId, @RequestParam("buddyId") int buddyId){
        AddressBook addressBook = addressBookRepository.findById(bookId).get();
        return buddyInfoRepository.findById(buddyId);
    }


    @RequestMapping(value = "/addressbook/buddy", method = RequestMethod.POST)
    public BuddyInfo addBuddy(@RequestParam("bookId") Long bookId, @RequestBody BuddyInfo buddyInfo){
        AddressBook addressBook = addressBookRepository.findById(bookId).get();
        addressBook.addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
        return buddyInfo;
    }

    @RequestMapping(value = "/addressbook/buddy", method = RequestMethod.DELETE)
    public String removeBuddy(@RequestParam("bookId") Long bookId, @RequestParam("buddyId") int buddyId){
        AddressBook addressBook = addressBookRepository.findById(bookId).get();
        addressBook.removeBuddy(buddyId);
        buddyInfoRepository.deleteById(Long.valueOf(buddyId));
        addressBookRepository.save(addressBook);
        return "success";
    }





}
