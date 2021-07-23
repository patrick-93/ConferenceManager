package ConferenceManager;

import java.time.LocalTime;
import java.util.ArrayList;

public class Scheduler {
    ArrayList<Talk> allTalks;
    ArrayList<Talk> morningTalks = new ArrayList<>();
    ArrayList<Talk> afternoonTalks = new ArrayList<>();
    ArrayList<Track> tracks = new ArrayList<>();

    public Scheduler(ArrayList<Talk> allTalks) {
        this.allTalks = allTalks;
        generateSchedule();
    }

    public void print() {
        // Loop over the track list
        for (Track track : tracks) {
            // Print out schedule for each track
            System.out.println(track.getName() + "\n---------------------");

            // Loop over the morning schedule
            for (Talk talk : track.getMorning()) {
                System.out.println(talk.getBegin() + "AM " + talk.getName() + " " + talk.getLength() + "min");
            }
            System.out.println("12:00PM Lunch");

            // Loop over the afternoon schedule
            for (Talk talk : track.getAfternoon()) {
                System.out.println(talk.getBegin() + "PM " + talk.getName() + " " + talk.getLength() + "min");
            }
            System.out.println("\n");
        }
    }

    private void generateSchedule() {
        // Counter for track names
        int trackCounter = 0;

        while (allTalks.size() > 0) {
            // Fill the morning and afternoon Talk lists
            populateMorning();
            populateAfternoon();

            // Create a new track with the morning and afternoon Talk lists and add it to track list
            Track track = new Track(
                    "Track" + trackCounter,
                    new ArrayList<Talk>(morningTalks),
                    new ArrayList<Talk>(afternoonTalks)
            );
            tracks.add(track);

            // Clear out the morning and afternoon Talk lists to repopulate them for the next track
            morningTalks.clear();
            afternoonTalks.clear();

            // Increment the trackCounter for new track names
            trackCounter++;
        }
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