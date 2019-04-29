package my.pet.mavenjavafxapp;

public class User {

    private String username;
    private String password;
    private int timer;

    public User(String username, String password, int timer) {
        this.username = username;
        this.password = password;
        this.timer = timer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
