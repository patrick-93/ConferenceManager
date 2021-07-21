package ConferenceManager;

import java.time.LocalTime;
import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Talk> allTalks;
    private ArrayList<Talk> morning;
    private ArrayList<Talk> afternoon;

    public Scheduler(ArrayList<Talk> allTalks) {
        this.allTalks = allTalks;
    }

    public void print() {
        for (Talk talk : allTalks) {
            System.out.println(talk.getName());
        }
    }

    private void generateSchedule() {
        
    }

    private void populateMorning() {

    }
}
