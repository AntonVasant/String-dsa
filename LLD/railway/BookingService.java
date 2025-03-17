package LLD.railway;

public class BookingService {

    private Repository repository;
    private static int idGen = 1;

    public BookingService(Repository repository){
        this.repository = repository;
    }
    public Booking handleBookingRequest(BookingRequest request) {
        if (!isSeatsAvailable(request.getSource(), request.getDestination(), request.getNumberOfSeats())){
            return null;
        }

        repository.lowerSeats(request.getNumberOfSeats(),  request.getSource(), request.getDestination());
        Booking booking = new Booking();
        booking.setBookingId(idGen++);
        booking.setSource(request.getSource());
        booking.setDestination(request.getDestination());
        booking.setNumberOfSeats(request.getNumberOfSeats());
        repository.saveBooking(booking.getBookingId(), booking);
        return booking;
    }

    private boolean isSeatsAvailable(char source, char destination, int seatsWanted) {
        int[] seats = repository.getSeats();

        for (int points = source - 'A'; points <= destination - 'A'; points++){
            if (seats[points] < seatsWanted)
                return false;
        }
        return true;
    }





}
