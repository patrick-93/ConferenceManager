package ConferenceManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

    public ArrayList<Talk> generateList(String filename) {
        // Create a new file object with the CLI arg and try to open it with scanner
        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to locate the file provided, does it exist?\n");
            System.exit(1);
        }

        ArrayList<Talk> allTalks = new ArrayList<>();

        // Scanner didn't fail to open so start parsing each line
        while(sc.hasNextLine()) {
            Talk temp = parseLine(sc.nextLine());
            if (temp != null) {
                allTalks.add(temp);
            }
        }
        return allTalks;
    }

    public Talk parseLine(String s) {
        // Create a new empty Talk object
        Talk temp = new Talk();

        // Split the passed string into an array
        String[] tempArr = s.split(" ");

        // Check the last string in the array, should contain
        // either "min" or "lightning" if valid
        String lastString = tempArr[tempArr.length - 1];
        int length = 0;
        if (lastString.equals("lightning")) {
            length = 5;
        } else if (lastString.contains("min")){
            length = Integer.parseInt(lastString.replace("min", ""));
        } else {
            System.out.println("Error parsing line: " + s);
            return null;
        }
        temp.setLength(length);

        // Put the string back together to set the name of the Talk object
        String name = "";
        for (int i = 0; i < tempArr.length - 1; i++) {
            name += tempArr[i];
            name += " ";
        }

        temp.setName(name.trim());
        return temp;
    }
}
