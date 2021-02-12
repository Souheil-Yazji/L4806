package SYSoft.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

	// used for console output
	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(BuddyInfoRepository repository) {
//		return (args) -> {
//			// save some buddies
//			repository.save(new BuddyInfo("Souheil","1125 Colonel By Dr.","613-613-6133"));
//			repository.save(new BuddyInfo("SY2","99 Eastside avenue","613-846-5431"));
//			repository.save(new BuddyInfo("SY3","3030 Westlane road","613-412-3521"));
//
//
//			// fetch a buddy
//			BuddyInfo buddy = repository.findByName("Souheil");
//			log.info("Buddy found by name:");
//			log.info("--------------------");
//			log.info(buddy.toString());
//
//			buddy = repository.findByAddress("99 Eastside avenue");
//			log.info("Buddy found by address:");
//			log.info("--------------------");
//			log.info(buddy.toString());
//
//			buddy = repository.findByPhoneNumber("613-412-3521");
//			log.info("Buddy found by phone number:");
//			log.info("--------------------");
//			log.info(buddy.toString());
//
//		};
//	}

}
