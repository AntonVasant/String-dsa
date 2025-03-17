package LLD.railway;

import java.util.Arrays;

public class PrepareChart {

    private Repository repository;

    public PrepareChart(Repository repository){
        this.repository = repository;
    }

    public void displayTickets(){
        int[] seats = repository.getSeats();
        int totalSeats = Repository.getSeatLimit();
        System.out.println(Arrays.toString(seats));
    }
}
