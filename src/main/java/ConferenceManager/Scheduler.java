package ConferenceManager;

import java.time.LocalTime;
import java.util.ArrayList;

public class Scheduler {
    ArrayList<Talk> allTalks;
    ArrayList<Talk> morningTalks = new ArrayList<>();
    ArrayList<Talk> afternoonTalks = new ArrayList<>();

    public Scheduler(ArrayList<Talk> allTalks) {
        this.allTalks = allTalks;
        generateSchedule();
    }

    public void print() {
        System.out.println("\nMorning Talks\n");
        for (Talk talk : morningTalks) {
            System.out.println(talk.toString());
        }
        System.out.println("\n\nAfternoon talks\n");
        for (Talk talk : afternoonTalks) {
            System.out.println(talk.toString());
        }
    }

    private void generateSchedule() {
        populateMorning();
        populateAfternoon();
    }

    private void populateMorning() {
        // Create the current time and end time
        LocalTime current = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(12, 0);

        int loopCount = 0;
        while (allTalks.size() != 0 && loopCount < 2) {
            for (int i = 0; i < allTalks.size(); i++) {
                // Check if the current is before the end time
                if (
                        current.compareTo(end) < 0 && (current.plusMinutes(allTalks.get(i).getLength()).compareTo(end) < 0)
                ) {
                    // current was before end so set talk.begin to current
                    allTalks.get(i).setBegin(current);

                    // Add the current talk object to morningTalks, remove from allTalks, increment current
                    morningTalks.add(allTalks.get(i));
                    current = current.plusMinutes(allTalks.get(i).getLength());
                    allTalks.remove(allTalks.get(i));
                }
            }
            loopCount++;
        }
    }

    private void populateAfternoon() {
        // Create the current time and end time
        LocalTime current = LocalTime.of(1, 0);
        LocalTime end = LocalTime.of(5, 0);

        int loopCount = 0;
        while (allTalks.size() != 0 && loopCount < 2) {
            for (int i = 0; i < allTalks.size(); i++) {
                // Check if the current is before the end time
                if (
                        current.compareTo(end) < 0 && (current.plusMinutes(allTalks.get(i).getLength()).compareTo(end) < 0)
                ) {
                    // current was before end so set talk.begin to current
                    allTalks.get(i).setBegin(current);

                    // Add the current talk object to afternoonTalks, remove from allTalks, increment current
                    afternoonTalks.add(allTalks.get(i));
                    current = current.plusMinutes(allTalks.get(i).getLength());
                    allTalks.remove(allTalks.get(i));
                }
            }
            loopCount++;
        }
    }
}