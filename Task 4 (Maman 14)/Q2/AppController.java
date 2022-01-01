import java.io.IOException;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {

    PhoneBook fb = new PhoneBook();

    @FXML
    private TextField searchBar;

    @FXML
    private ListView<String> contactList;

    /**
     * Add Buttom pressed - add contact to the structure and the list(gui)
     * @param event
     */
    @FXML
    void addPressed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Enter Name");
        // check if alredy exist
        if(fb.getBook().containsKey(name))
            JOptionPane.showMessageDialog(null, "this name is alredy taken, try to update..");
        else{
            String num = JOptionPane.showInputDialog("Enter Phone Number");
            fb.getBook().put(name, num);
            updateList(); // add to listView
        }

    }
    /**
     * Add the elements to the list view.
     */
    public void updateList(){

        contactList.getItems().clear();
        for (Entry<String, String> entry : fb.getBook().entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();

            String line = key +"\t,\t" + value;
            // Add this string to listView
            contactList.getItems().add(line);
        }
    }

    /**
     * delete Buttom pressed - delete from structure and call to updateList to delete from listView.
     * @param event
     */
    @FXML
    void deletePressed(ActionEvent event) {

        String name = JOptionPane.showInputDialog("Enter Name To Remove");
        // Search the key in the hashMap
        if(fb.getBook().containsKey(name)){
            fb.getBook().remove(name); // And remove it
            updateList(); // delete him from the Listview
        }
        else{
            notFoundError();
        }
    }

    /**
     * Export buttom pressed - export all contact to file (get the name of the file from user)
     * @param event
     */
    @FXML
    void exportContacts(ActionEvent event) {
        String nameFile = JOptionPane.showInputDialog("Please Enter Name To File");
        try{
            fb.writeTableToFile(nameFile); // phoneBook's method
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error, File Not Found.");
        }

    }

    /**
     *  Import Buttom pressed - import contact from txt file    *   To Do
     * @param event
     */
    @FXML
    void importContacts(ActionEvent event) {
        String nameOfFile = JOptionPane.showInputDialog("Enter Name Of File");
            try{
                fb.readTableFromFile(nameOfFile);
                for (Entry<String, String> entry : fb.getBook().entrySet())
                    System.out.println(entry.getKey()+" ,   "+entry.getValue());
            //updateList();
            }catch(IOException exception){
                JOptionPane.showMessageDialog(null, "There Is No File With This Name");
            }
            updateList();
    }

    /**
     * Search contact using textField
     * @param event
     */
    @FXML
    void searchByName(ActionEvent event) {

        String search = searchBar.getText();
        searchBar.clear();
        if(fb.getBook().containsKey(search)){
            JOptionPane.showMessageDialog(null, search+" Phone Number Is: "+fb.getBook().get(search));
        }

    }

    @FXML
    void updatePressed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Enter Name To Update");
        if(fb.getBook().containsKey(name)){
            String newNum = JOptionPane.showInputDialog("Enter New Phone Number");
            fb.getBook().put(name, newNum);
            updateList();
        }
        else{
            notFoundError();
        }
    }

    public void notFoundError(){
        JOptionPane.showMessageDialog(null, "There Is No Contact With This Name");
    }

}

