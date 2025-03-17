package LLD.railway;

public class CancellingService {

    private Repository repository;

    public CancellingService(Repository repository){
        this.repository = repository;
    }
    public boolean cancelSeats(int bookingId, int numberOfSeats) {
        Booking booking = repository.getBookingById(bookingId);
        if (booking == null){
            System.out.println("false");
            return false;
        }

        booking.addCancelSeats(numberOfSeats);
        if (booking.getSeatsCancelled() == booking.getNumberOfSeats())
            repository.removeBooking(bookingId);
        repository.increaseSeats(numberOfSeats, booking.getSource(), booking.getDestination());
        System.out.print("remaining seats =");
        System.out.println(booking.getNumberOfSeats() - booking.getSeatsCancelled());
        return true;
    }
}
