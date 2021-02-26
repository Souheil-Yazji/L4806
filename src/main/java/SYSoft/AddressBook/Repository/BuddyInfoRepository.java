package SYSoft.AddressBook.Repository;

import SYSoft.AddressBook.Model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    BuddyInfo findByName(String name);
    BuddyInfo findByPhoneNumber(String phoneNumber);
    BuddyInfo findByAddress(String address);
    BuddyInfo findById(long id);

}
