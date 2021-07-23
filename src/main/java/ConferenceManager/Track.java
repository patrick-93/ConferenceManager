package ConferenceManager;

import java.util.ArrayList;

public class Track {
    private String name;
    private ArrayList<Talk> morning;
    private ArrayList<Talk> afternoon;

    public Track(String name, ArrayList<Talk> morning, ArrayList<Talk> afternoon) {
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Talk> getMorning() {
        return morning;
    }

    public void setMorning(ArrayList<Talk> morning) {
        this.morning = morning;
    }

    public ArrayList<Talk> getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(ArrayList<Talk> afternoon) {
        this.afternoon = afternoon;
    }
}
