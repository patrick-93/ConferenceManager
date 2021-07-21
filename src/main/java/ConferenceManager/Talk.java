package ConferenceManager;

import java.time.LocalTime;
import java.util.Calendar;

public class Talk {
    private int length;
    private String name;
    private Calendar begin;
    private Calendar end;

    public Talk (int length, String name) {
        this.length = length;
        this.name = name;
    }

    public Talk() {}

    @Override
    public String toString() {
        return "Talk [name=" + name + ", length=" + length + ", begin=" + begin + ", end=" + end + "]";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBegin() {
        return begin;
    }

    public void setBegin(Calendar begin) {
        this.begin = begin;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }
}
