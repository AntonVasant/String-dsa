package LLD.railway;

public class Passenger {
    private int id;
    private String name;
    private char berthPreference;
    private int age;
    private String gender;

    public Passenger(String name,int age,String gender,char berthPreference) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.berthPreference = berthPreference;
    }

    public char getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(char berthPreference) {
        this.berthPreference = berthPreference;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
