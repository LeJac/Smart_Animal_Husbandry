package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.adapter.ActuatorAdapter;
import com.example.myapplication_1.model.ActuatorModel;
import com.example.myapplication_1.viewmodel.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class DeviceControlActivity extends AppCompatActivity {


    private ListView lvDevices;

    private List<ActuatorModel> devices;

    private HomeViewModel homeViewModel;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_control);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setSelectedItemId(R.id.navigation_control);
//为 bottomNavigationView 设置了一个 OnNavigationItemSelectedListener
// 即 navListener。这个监听器会在用户点击底部导航栏的菜单项时触发相应的操作
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        initData();
        //绑定ListView
        lvDevices = findViewById(R.id.list_divices_control);
        //设置ListView的数据适配器
        lvDevices.setAdapter(new ActuatorAdapter(this, devices));

    }

    private void initData(){
        homeViewModel = new HomeViewModel();
        homeViewModel.init();
        devices = homeViewModel.getDevices();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_monitor:
                            startActivity(new Intent(DeviceControlActivity.this, HomeActivity.class));
                            finish();
                            return true;
                        case R.id.navigation_control:
                            // 不应该启动当前活动，可以根据需要执行特定的操作
                            return true;
                        case R.id.navigation_profile:
                            startActivity(new Intent(DeviceControlActivity.this, PersonalCenter.class));
                            finish(); // 可选：如果希望从当前活动跳转后销毁当前活动
                            return true;
                    }
                    return false;
                }
            };

}