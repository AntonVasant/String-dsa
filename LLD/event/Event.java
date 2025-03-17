package LLD.event;

public class Event {
    private String event;
    private String start;
    private  String end;
    private int durationInMinutes;

    public Event(String event, String start, int durationInMinutes){
        this.event = event;
        this.start = start;
        this.durationInMinutes = durationInMinutes;
    }

    public String setEnd(int durationInMinutes) {
        String[] time = start.split(":");
        int startHour = Integer.parseInt(time[0]);
        int startMinute = Integer.parseInt(time[1]);
        int durationHours = durationInMinutes/ 60;
        int durationMinutes = durationInMinutes % 60;
        if (durationMinutes + startMinute >= 60){
            durationHours++;
        }
        durationMinutes = (durationInMinutes + startMinute) % 60;
        durationHours += startHour;

        this.end = durationHours +":"+ durationMinutes;

        return durationHours < 10 ? "0"+durationHours+":"+durationMinutes : durationHours +":"+ durationMinutes;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
