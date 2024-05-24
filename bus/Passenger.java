package bus;

import java.util.Objects;

public class Passenger {
    private int age;
    private String name;
    private int seatNumber;

    public Passenger(int age,int seatNumber,String name) {
        this.age = age;
        this.seatNumber=seatNumber;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
