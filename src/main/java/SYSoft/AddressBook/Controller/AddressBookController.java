package SYSoft.AddressBook.Controller;

import SYSoft.AddressBook.Model.AddressBook;
import SYSoft.AddressBook.Model.BuddyInfo;
import SYSoft.AddressBook.Repository.AddressBookRepository;
import SYSoft.AddressBook.Repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;


    /**
     *
     * @return
     */
    @RequestMapping(value = "/addressbook/new", method = RequestMethod.POST)
    public RedirectView addAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return new RedirectView("/");
    }

    /**
     * List all addressbooks
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String listAddressBooks(Model model){
        model.addAttribute("addressBooks", addressBookRepository.findAll());
        return "addressbooklist";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/addressbook/get", method = RequestMethod.GET)
    public String getAddressBook(@RequestParam("id") Long id, Model model){
        AddressBook addressBook = addressBookRepository.findById(id).get();
        if (addressBook == null){
            throw new NullPointerException();
        }
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddyInfo", new BuddyInfo());

        return "addressbook";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/addressbook/addBuddy", method = RequestMethod.POST)
    public RedirectView addBuddy(@RequestParam("id") Long id, @ModelAttribute BuddyInfo buddyInfo){
        AddressBook addressBook = addressBookRepository.findById(id).get();
        if (addressBook == null){
            throw new NullPointerException();
        }

        buddyInfo.setAddressBook(addressBook);
        buddyInfoRepository.save(buddyInfo);
        addressBook.addBuddy(buddyInfo);

        return new RedirectView("/addressbook/get?id=" + addressBook.getId());
    }

    /**
     *
     */
    @RequestMapping(value = "/addressbook/delBuddy", method = RequestMethod.POST)
    public RedirectView deleteBuddy(@RequestParam("bookId") Long bookId, @RequestParam("buddyId") int buddyId, Model model){
        AddressBook addressBook = addressBookRepository.findById(bookId).get();
        BuddyInfo buddyInfo = buddyInfoRepository.findById(buddyId);

        if(addressBook == null || buddyInfo == null)  return null;

        addressBook.removeBuddy(buddyId);
        buddyInfoRepository.delete(buddyInfo);

        return new RedirectView("/addressbook/get?id=" + addressBook.getId());
    }
}
