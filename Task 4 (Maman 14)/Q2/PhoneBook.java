import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PhoneBook{

    private HashMap<String, String> book;


    public PhoneBook(){
        book = new HashMap<String,String>();
    }

    public HashMap<String, String> getBook(){
        return book;
    }

    /**
     * Method that write HashTable into text file.
     */
    public void writeTableToFile(String nameFile){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(nameFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // foreach
        for (Map.Entry<String,String> entry : getBook().entrySet()) {
            out.println(entry.getKey() + "\t,\t" + entry.getValue());
        }

        out.close();
    }

    /**
     * Method that read HashTable from file.
     * The file needs to be in ' key , value ' format.
     * Is the same format that we use in writeTableToFile.
     * @param fileName The name of the file that we want to read from.
     */
    public void readTableFromFile(String fileName) throws IOException{
        String[] arr = new String[2]; //array for 2 words in line.
        //try{
            Scanner s = new Scanner(new File(fileName));
            while (s.hasNext()){
                String line  = s.nextLine();
                arr = line.split("\t,\t");  // put each word in in cell so we can use it for 'put' func:
                getBook().put( arr[0], arr[1]);
            //}
            s.close();
        /*} catch (IOException e){ // file error exception
            System.out.println("there is no such file.");
        }*/
        }


    }
}


