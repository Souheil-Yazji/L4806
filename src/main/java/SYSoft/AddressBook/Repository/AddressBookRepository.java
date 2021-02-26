package SYSoft.AddressBook.Repository;

import SYSoft.AddressBook.Model.AddressBook;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
//    AddressBook findById();
}
