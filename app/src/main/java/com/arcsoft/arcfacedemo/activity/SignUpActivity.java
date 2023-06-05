package com.arcsoft.arcfacedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.util.MyTextUtils;

public class SignUpActivity extends AppCompatActivity {

    private EditText mAccount;
    private EditText mPassword;
    private EditText mRePassword;
    private TextView mLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = this.getWindow();

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(this.getResources().getColor(R.color.white));//设置状态栏颜色
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//状态栏为白色 图标显示深色

        }
        setUpViews();
    }

    private void setUpViews() {
        mAccount = findViewById(R.id.registerUsername);
        mPassword = findViewById(R.id.registerPwd);
        mRePassword = findViewById(R.id.registerPwd1);
        mLogin = findViewById(R.id.registerSub);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MyTextUtils.isLegal(mAccount.getText().toString(), 2, 10)
                        && MyTextUtils.isLegal(mPassword.getText().toString(), 6, 18)
                        && MyTextUtils.isLegal(mRePassword.getText().toString(), 6, 18)) {
                    startActivity(new Intent(SignUpActivity.this, ChooseFunctionActivity.class));
                }else {
                    Toast.makeText(SignUpActivity.this,"用户名或密码不合法",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveAccount() {
        SharedPreferences pref = getSharedPreferences("account", Context.MODE_PRIVATE);
        //保存注册好的账号密码
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("remember_password", true);
        editor.putString("account", mAccount.getText().toString());
        editor.putString("password", mPassword.getText().toString());
        editor.apply();
    }
}
