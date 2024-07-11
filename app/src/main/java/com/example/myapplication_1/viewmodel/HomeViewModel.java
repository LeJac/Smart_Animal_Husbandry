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
        devices.add(new ActuatorModel(R.drawable.fan,"风扇1","1",0));
        devices.add(new ActuatorModel(R.drawable.fan,"风扇2","1",0));
        devices.add(new ActuatorModel(R.drawable.fan,"风扇3","1",0));
        devices.add(new ActuatorModel(R.drawable.light,"灯光1","1",1));
        devices.add(new ActuatorModel(R.drawable.light,"灯光2","1",1));
        devices.add(new ActuatorModel(R.drawable.light,"灯光3","1",1));
        devices.add(new ActuatorModel(R.drawable.feed,"进料口1","1",1));
        devices.add(new ActuatorModel(R.drawable.feed,"进料口2","1",1));
        devices.add(new ActuatorModel(R.drawable.feed,"进料口3","1",1));
        devices.add(new ActuatorModel(R.drawable.water,"水泵1","1",1));
        devices.add(new ActuatorModel(R.drawable.water,"水泵2","1",1));
        devices.add(new ActuatorModel(R.drawable.water,"水泵3","1",1));


        sensors = new ArrayList<>();
        sensors.add(new SensorModel(R.drawable.temerature,"温度","1",25,"℃"));
        sensors.add(new SensorModel(R.drawable.humidity,"湿度","1",79,"%"));
        sensors.add(new SensorModel(R.drawable.co2,"二氧化碳浓度","1",2000,"ppm"));
        sensors.add(new SensorModel(R.drawable.nh3,"氨气浓度","1",80,"ppm"));
        sensors.add(new SensorModel(R.drawable.tvoc,"TVOC","1",3000,"ppm"));
        sensors.add(new SensorModel(R.drawable.pressure,"大气压强","1",500,"pa"));
        sensors.add(new SensorModel(R.drawable.redray,"红外感应","1",500,""));
        sensors.add(new SensorModel(R.drawable.studio,"噪声检测","1",99.0,"dB"));
    }

    public List<ActuatorModel> getDevices() {
        return devices;
    }

    public List<SensorModel> getSensors() {
        return sensors;
    }
}
