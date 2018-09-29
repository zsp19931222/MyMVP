package presenter;

import android.os.Handler;

import login_View.LoginView;
import login_model.LoginModel;
import login_model.User;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class LoginPresenter {
    private LoginModel.IUserBiz userBiz;
    private LoginView userLoginView;
    private Handler mHandler = new Handler();

    public LoginPresenter(LoginView userLoginView) {
        this.userLoginView = userLoginView;
        userBiz = new LoginModel.IUserBizIml();
    }

    public void login() {
        userLoginView.showProgressBar();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPw(), new LoginModel.onLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.intentActivity();
                        userLoginView.dissmissProgressBar();
                    }
                });
            }

            @Override
            public void loginFail() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.dissmissProgressBar();
                    }
                });
            }

        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPw();
    }
}
