package ConferenceManager;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Make sure a file is passed as an argument
        if (args.length == 0) {
            System.out.println("Usage: java -jar ConferenceManager.jar </path/to/file>");
            System.exit(1);
        }

        // Create a new FileParser and get a list from the args
        FileParser fp = new FileParser();
        ArrayList<Talk> allTalks = fp.generateList(args[0]);

        Scheduler scheduler = new Scheduler(allTalks);
        scheduler.print();
    }
}
