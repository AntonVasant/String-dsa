package LLD.parking;

import javax.xml.crypto.Data;
import java.util.Date;

public class Ticket {

    private String id;
    private Vehicle vehicle;
    private Date from;
    private Date to;

    public Ticket(String id,Vehicle vehicle,Date start,Date end) {
        this.id = id;
        this.vehicle = vehicle;
        this.from = start;
        this.to=end;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
