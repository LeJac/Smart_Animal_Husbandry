package com.example.myapplication_1.viewmodel;

import com.example.myapplication_1.R;
import com.example.myapplication_1.model.ActuatorModel;
import com.example.myapplication_1.model.SensorModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {

    private List<SensorModel> sensors;
    private List<ActuatorModel> devices;

    public void init(){
        devices = new ArrayList<>();
        devices.add(new ActuatorModel(R.drawable.fan,"风扇","1",0));
        devices.add(new ActuatorModel(R.drawable.light,"灯泡","1",1));
        devices.add(new ActuatorModel(R.drawable.water,"水泵","1",1));

        sensors = new ArrayList<>();
        sensors.add(new SensorModel(R.mipmap.ic_launcher,"温度","1",25,"℃"));
        sensors.add(new SensorModel(R.mipmap.ic_launcher,"湿度","1",79,"%RH"));
        sensors.add(new SensorModel(R.mipmap.ic_launcher,"二氧化碳浓度","1",2000,"ppm"));
        sensors.add(new SensorModel(R.mipmap.ic_launcher,"土壤水分","1",80,"%RH"));
        sensors.add(new SensorModel(R.mipmap.ic_launcher,"光照强度","1",3000,"lux"));
        sensors.add(new SensorModel(R.mipmap.ic_launcher,"大气压力","1",500,"pa"));
    }

    public List<ActuatorModel> getDevices() {
        return devices;
    }

    public List<SensorModel> getSensors() {
        return sensors;
    }
}
