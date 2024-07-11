package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonalCenter extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setSelectedItemId(R.id.navigation_profile);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // 找到退出登录按钮并设置点击事件
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 执行退出登录的操作，这里假设直接跳转到 LoginActivity
                Intent intent = new Intent(PersonalCenter.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_monitor:
                            startActivity(new Intent(PersonalCenter.this, HomeActivity.class));

                            // 不应该启动当前活动，可以根据需要执行特定的操作
                            return true;
                        case R.id.navigation_control:
                            startActivity(new Intent(PersonalCenter.this, DeviceControlActivity.class));
                            finish(); // 可选：如果希望从当前活动跳转后销毁当前活动
                            return true;
                        case R.id.navigation_profile:
//                            finish(); // 可选：如果希望从当前活动跳转后销毁当前活动
                            return true;
                    }
                    return false;
                }
            };
}
