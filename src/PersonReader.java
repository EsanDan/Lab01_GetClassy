import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Person> people = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        Scanner in = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            in = new Scanner(selectedFile);
        }

        while (in.hasNext()) {
            people.add(new Person(removeComma(in.next()), removeComma(in.next()), removeComma(in.next()), removeComma(in.next()), in.nextInt()));
        }

        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "ID", "First Name", "Last Name", "Title", "YOB");
        System.out.println("======================================================================");

        for (Person person : people) {
            System.out.printf("%-15s", person.getID());
            System.out.printf("%-15s", person.getFirstName());
            System.out.printf("%-15s", person.getLastName());
            System.out.printf("%-15s", person.getTitle());
            System.out.printf("%-15d\n", person.getYOB());
        }
    }

    private static String removeComma(String inString) {
        return inString.substring(0, inString.length() - 1);
    }
}