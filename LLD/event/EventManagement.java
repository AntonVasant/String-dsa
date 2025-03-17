package LLD.event;

import java.util.ArrayList;
import java.util.List;

public class EventManagement {

    private static String currentTime = "09:00";
    private static boolean isAfterNoon = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Welcome event 30 mins");
        list.add("C programming 45 mins");
        list.add("Working with java beans 30 mins");
        list.add("Ruby and Rails programming 60 mins");
        list.add("Rail debugging 45 mins");
        list.add("Tips and tricks in c 30 mins");
        list.add("Backend development 50 mins");
        list.add("Sit down and take notes lightning");
        list.add("Introduction in  45 mins");
        list.add("Team management concept in  30 mins");
        list.add("Introduction to java framework lightning");
        list.add("Working with angular js 45 mins");
        list.add("Ruby and rails programming development in 60 mins");
        list.add("Introduction to kotlin 60 mins");
        list.add("debug and testing product in 60 mins");
        list.add("Documenting a software 40 mins");

        EventManagement eventManagement = new EventManagement();
        eventManagement.arrangeEvents(list);
    }

   public void arrangeEvents(List<String> events){
       List<Event> events1 = new ArrayList<>();
       for (String s : events){
           adjustTime();
           int duration = getDurations(s);
           if (canDoToday(duration)){
               Event event = new Event(s,currentTime, duration);
               currentTime = event.setEnd(duration);
               events1.add(event);
           }
           else {
               currentTime = "09:00";
               Event event = new Event(s, currentTime, duration);
               currentTime = event.setEnd(duration);
               events1.add(event);
           }

       }
       for (Event event : events1) {
           System.out.println(event.getStart() +" - "+ event.getEnd() + " "+ event.getEvent());
       }
   }

   private void adjustTime() {

       int currentHour = Integer.parseInt(currentTime.substring(0, 2));
       if (currentHour > 12){
           int hour = currentHour - 12;
           currentTime = "0"+hour+":"+currentTime.substring(3);
       }
   }



    private boolean canDoToday(int duration){
        String[] time = currentTime.split(":");
        int hour = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int hoursNeed = duration / 60;
        int minutesNeed = duration % 60;
        if (minutes + minutesNeed >= 60){
            hoursNeed++;
            minutesNeed = minutes + minutesNeed % 60;
        }
        if (hour > 4){
            return hour + hoursNeed < 16   || hoursNeed + hour == 16 && minutesNeed == 0;
        }
        else {
            return hour + hoursNeed < 4 || hoursNeed + hour == 4 && minutesNeed == 0;
        }
    }

    private int getDurations(String s){
        int index = s.indexOf("mins");
        if (index >= 0){
            return Integer.parseInt(s.substring(index-3, index-1));
        }
        else {
            if (s.contains("lightning"))
                return 5;
        }
        return -1;
    }
}
