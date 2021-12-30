
import java.io.IOException;
//import java.util.Scanner;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {

    PhoneBook fb = new PhoneBook();

    @FXML
    private Button deleteBtn;

    @FXML
    private Button importBtn;

    @FXML
    private Button exportBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private Button addBtn;

    @FXML
    private ListView<String> contactList;

    @FXML
    private Button updateBtn;

    @FXML
    void addPressed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Enter Name");
        if(fb.getBook().containsKey(name))
            JOptionPane.showMessageDialog(null, "this name is alredy taken, try to update..");
        else{
            String num = JOptionPane.showInputDialog("Enter Phone Number");
            fb.getBook().put(name, num);
            updateList();
        }

    }

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

    @FXML
    void deletePressed(ActionEvent event) {

        String name = JOptionPane.showInputDialog("Enter name to remove");
        // Search the key in the hashMap
        if(fb.getBook().containsKey(name)){
            fb.getBook().remove(name); // And remove it
            updateList(); // delete him from the Listview
        }
        else{
            JOptionPane.showMessageDialog(null, "There is no such name");
        }
    }

    @FXML
    void exportContacts(ActionEvent event) {
        String nameFile = JOptionPane.showInputDialog("Enter name to file");
        try{
            fb.writeTableToFile(nameFile);
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @FXML ///**************************** */
    void importContacts(ActionEvent event) {
        String nameOfFile = JOptionPane.showInputDialog("Enter name of File");
            try{
                fb.readTableFromFile(nameOfFile);
                for (Entry<String, String> entry : fb.getBook().entrySet())
                    System.out.println(entry.getKey()+" ,   "+entry.getValue());
            //updateList();
            }catch(IOException exception){
                JOptionPane.showMessageDialog(null, "There is no such name");
            }

    }

    @FXML
    void searchByName(ActionEvent event) {

        String search = searchBar.getText();
        searchBar.clear();
        if(fb.getBook().containsKey(search)){
            JOptionPane.showMessageDialog(null, search+" phone num is: "+fb.getBook().get(search));
        }

    }

    @FXML
    void updatePressed(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Enter Name To Update");
        if(fb.getBook().containsKey(name)){
            String newNum = JOptionPane.showInputDialog("Enter new Phone NUmber");
            fb.getBook().put(name, newNum);
            updateList();
        }
        else{
            JOptionPane.showMessageDialog(null, "There is no such name");
        }
    }



}

