package ConferenceManager;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Make sure a file is passed as an argument
        if (args.length == 0) {
            System.out.println("Usage: java -jar ConferenceManager.jar </path/to/file>");
            System.exit(1);
        }
        FileParser fp = new FileParser();
        ArrayList<Talk> allTalks = fp.generateList(args[0]);

        Scheduler scheduler = new Scheduler(allTalks);
        scheduler.print();
    }
}
