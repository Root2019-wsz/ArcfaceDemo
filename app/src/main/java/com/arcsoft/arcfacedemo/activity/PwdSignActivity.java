package com.arcsoft.arcfacedemo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.arcsoft.arcfacedemo.R;

public class PwdSignActivity extends AppCompatActivity {

    private TextView mPwd;

    private TextView mRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwdsign);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = this.getWindow();

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(this.getResources().getColor(R.color.white));//设置状态栏颜色
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//状态栏为白色 图标显示深色

        }

        setUpViews();
    }

    private void setUpViews() {
        mPwd = findViewById(R.id.pwd_et);
        mRegister = findViewById(R.id.register_tw);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PwdSignActivity.this,"签到成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
