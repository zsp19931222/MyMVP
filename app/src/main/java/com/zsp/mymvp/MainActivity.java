package com.zsp.mymvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import login_View.LoginView;
import presenter.LoginPresenter;
import util.ClearUtil;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText username;
    private EditText pw;
    private Button username_clear;
    private Button pw_clear;
    private ProgressBar progressBar;
    private Button loginBtn;
    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        username = findViewById(R.id.username);
        pw = findViewById(R.id.pw);
        username_clear = findViewById(R.id.username_clear);
        pw_clear = findViewById(R.id.pw_clear);
        progressBar = findViewById(R.id.progress);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });
        pw_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPw() {
        return pw.getText().toString();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dissmissProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void intentActivity() {
        Toast.makeText(this,"登录成功跳转",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPw() {
        pw.setText("");
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
    }
}
