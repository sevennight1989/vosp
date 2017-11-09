package ll.opensource.Bean;

/**
 * Created by Percy on 11-3 0003.
 */

public class LoginInfo {

    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "LoginInfo{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
    }
}
