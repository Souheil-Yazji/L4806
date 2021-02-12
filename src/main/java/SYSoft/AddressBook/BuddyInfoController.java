package SYSoft.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuddyInfoController {

    private final BuddyInfoRepository buddyInfoRepository;
    private final AddressBookRepository addressBookRepository;

    @Autowired
    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

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
