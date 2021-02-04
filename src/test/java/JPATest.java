import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import Model.AddressBook;
import Model.BuddyInfo;
import org.junit.Test;

public class JPATest {

    @Test
    public void main(){

        AddressBook book = new AddressBook();
        book.setId(1);

        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Souheil");
        buddy1.setAddress("North Pole");
        buddy1.setPhoneNumber("6137618823");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("SY");
        buddy2.setAddress("South Pole");
        buddy2.setPhoneNumber("3167823948");

        book.addBuddy(buddy1);
        book.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("addressbook");
        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the book and addressbook entity objects

//        em.persist(buddy1);
//        em.persist(buddy2);
        em.persist(book);

        tx.commit();

        Query q = em.createQuery("SELECT b FROM Model.AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (AddressBook b : results) {
            System.out.println("Book id=" + b.getId());
            b.printBuddies();
        }

        // Closing connection
        em.close();

        emf.close();
    }

}
