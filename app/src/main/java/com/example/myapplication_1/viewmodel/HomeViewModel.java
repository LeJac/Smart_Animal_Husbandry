package com.example.myapplication_1.viewmodel;

import com.example.myapplication_1.HomeActivity;
import com.example.myapplication_1.R;
import com.example.myapplication_1.api.ThingsBoardHelp;
import com.example.myapplication_1.model.ActuatorModel;
import com.example.myapplication_1.model.SensorModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {

    private List<SensorModel> sensors;
    private List<ActuatorModel> actuators;

    public void init(HomeActivity context){
        actuators = new ArrayList<>();
        actuators.add(new ActuatorModel(context, R.drawable.lightbulb, ThingsBoardHelp.LED0_DEVICE_NAME, 0, ThingsBoardHelp.LED0_DEVICE_ID));
        actuators.add(new ActuatorModel(context, R.drawable.lightbulb, ThingsBoardHelp.LED1_DEVICE_NAME, 0, ThingsBoardHelp.LED1_DEVICE_ID));
        actuators.add(new ActuatorModel(context, R.drawable.lightbulb, ThingsBoardHelp.LED2_DEVICE_NAME, 0, ThingsBoardHelp.LED2_DEVICE_ID));

        sensors = new ArrayList<>();
        sensors.add(new SensorModel(context, R.drawable.lightbulb, ThingsBoardHelp.TEMP_DEVICE_NAME,0, "℃", ThingsBoardHelp.TEMP_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.humidity, ThingsBoardHelp.HUMI_DEVICE_NAME,0, "%RH", ThingsBoardHelp.HUMI_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.user, ThingsBoardHelp.BODY_DEVICE_NAME,0, "", ThingsBoardHelp.BODY_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.barometer, ThingsBoardHelp.PA_DEVICE_NAME,0, "Pa", ThingsBoardHelp.PA_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.dust, ThingsBoardHelp.PM25_DEVICE_NAME,0, "ppm", ThingsBoardHelp.PM25_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.tvoc, ThingsBoardHelp.TVOC_DEVICE_NAME,0, "ppm", ThingsBoardHelp.TVOC_DEVICE_ID));

        for(SensorModel sensor: sensors){
            sensor.startCollection();
        }
        for(ActuatorModel act: actuators){
            act.startCollection();
        }
    }

    public List<ActuatorModel> getDevices() {
        return actuators;
    }

    public List<SensorModel> getSensors() {
        return sensors;
    }
}
