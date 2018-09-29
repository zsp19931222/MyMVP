package login_model;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class User {
    private String username;
    private String pw;

    public User(String username, String pw) {
        this.username = username;
        this.pw = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
