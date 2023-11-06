import java.io.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.WARNING);
        handler.setFilter(new MyFilter());
        log.addHandler(handler);
        log.setUseParentHandlers(false);


    }
     static public int count=0;
    public static void main(String[] args) {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/filles/emails.txt"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                count++;
                // read next line
                line = reader.readLine();
            }
           log.severe("xabarlar soni "+count+" ta");

            reader.close();
        } catch (IOException e) {
           log.severe(e.getMessage());
        }





    }

}