package machinecoding.train;

public class PrepareChart {

    private TicketsRepository repository;

    public PrepareChart(TicketsRepository repository) {
        this.repository = repository;
    }

    public void displayChart(){
        int[] seats = repository.getSeatsPerStops();
        for (int i = 1; i <= seats.length; i++)
            System.out.print("  "+(i+1));
        System.out.println();
        for (int i = 1; i <= seats.length; i++){
            System.out.print("  "+(i+1));
            for (int j = 0; j < seats[i-1]; j++)
                System.out.print("*  ");
            System.out.println();
        }
    }
}
