package login_View;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public interface LoginView {
    String getUserName();
    String getPw();
    void showProgressBar();
    void dissmissProgressBar();
    void intentActivity();
    void clearUserName();
    void clearPw();
    void showFailedError();
}
