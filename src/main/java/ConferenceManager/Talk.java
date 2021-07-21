package ConferenceManager;

import java.time.LocalTime;

public class Talk {
    private int length;
    private String name;
    private LocalTime begin;
    private LocalTime end;

    public Talk (int length, String name) {
        this.length = length;
        this.name = name;
    }

    public Talk() {}

    @Override
    public String toString() {
        return "Talk [name=" + name +
                ", length=" + length +
                ", begin=" + begin +
                ", end=" + end + "]";
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

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
