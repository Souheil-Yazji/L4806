import Controller.AddressBookController;
import todo.view.AddressBookView;

public class MVCMain {
    public static void main(String[] args) {
        AddressBookView view = new AddressBookView();
        AddressBookController controller = new AddressBookController(view);
    }
}
