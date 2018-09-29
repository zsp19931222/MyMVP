package login_model;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class LoginModel {
    /**
     * 登录业务接口
     */
    public interface IUserBiz {
        void login(String username, String pw, onLoginListener onLoginListener);
    }

    /**
     * 登录状态接口回调
     */
    public interface onLoginListener {
        void loginSuccess(User user);

        void loginFail();
    }

    public static class IUserBizIml implements IUserBiz {

        @Override
        public void login(final String username, final String pw, final onLoginListener onLoginListener) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        if (username.equals("zsp") && pw.equals("123")) {
                            onLoginListener.loginSuccess(new User(username, pw));
                        } else {
                            onLoginListener.loginFail();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
