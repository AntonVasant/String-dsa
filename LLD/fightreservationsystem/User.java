package LLD.fightreservationsystem;

public class User {
    private String userId;
    private String userName;
    private String email;

    public User(String name,String email,String id) {
        this.email = email;
        this.userName = name;
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
