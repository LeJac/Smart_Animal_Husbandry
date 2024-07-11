/*
package com.example.myapplication_1;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.adapter.ActuatorAdapter;
import com.example.myapplication_1.adapter.SensorsAdapter;
import com.example.myapplication_1.model.DeviceModel;
import com.example.myapplication_1.model.SensorModel;
import com.example.myapplication_1.viewmodel.HomeViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView lvDevices;
    private List<DeviceModel> devices;
    private GridView gvSensor;
    private List<SensorModel> sensors;
    private HomeViewModel homeViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        initData();
        //绑定ListView
        lvDevices = findViewById(R.id.list_divices);
        //设置ListView的数据适配器
        lvDevices.setAdapter(new ActuatorAdapter(this,devices));

        //绑定GridView
        gvSensor = findViewById(R.id.grid_sensors);
        //设置GridView的数据适配器
        gvSensor.setAdapter(new SensorsAdapter(this,sensors));
    }

    private void initData(){
        homeViewModel = new HomeViewModel();
        devices = homeViewModel.getDevices();
        sensors = homeViewModel.getSensors();


    }
}
*/
package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.adapter.ActuatorAdapter;
import com.example.myapplication_1.adapter.SensorsAdapter;
import com.example.myapplication_1.model.ActuatorModel;
import com.example.myapplication_1.model.SensorModel;
import com.example.myapplication_1.viewmodel.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView lvDevices;
    private GridView gvSensors;

    private List<ActuatorModel> devices;
    private List<SensorModel> sensors;
    private HomeViewModel homeViewModel;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        // 获取底部导航栏
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        // 设置底部导航栏的监听器, 监听跳转动作
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        initData();
        //绑定ListView
        lvDevices = findViewById(R.id.list_divices);
        //绑定GridView
        gvSensors = findViewById(R.id.grid_sensors);
        //设置ListView的数据适配器
        lvDevices.setAdapter(new ActuatorAdapter(this, devices));
        //设置GridView的数据适配器
        gvSensors.setAdapter(new SensorsAdapter(this,sensors));
    }

    private void initData(){
        homeViewModel = new HomeViewModel();
        homeViewModel.init();
        devices = homeViewModel.getDevices();
        sensors = homeViewModel.getSensors();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_monitor:
                            // 不应该启动当前活动，可以根据需要执行特定的操作
                            return true;
                        case R.id.navigation_control:
                            startActivity(new Intent(HomeActivity.this, DeviceControlActivity.class));
                            finish(); // 可选：如果希望从当前活动跳转后销毁当前活动
                            return true;
                        case R.id.navigation_profile:
                            startActivity(new Intent(HomeActivity.this, PersonalCenter.class));
                            finish(); // 可选：如果希望从当前活动跳转后销毁当前活动
                            return true;
                    }
                    return false;
                }
            };
}


