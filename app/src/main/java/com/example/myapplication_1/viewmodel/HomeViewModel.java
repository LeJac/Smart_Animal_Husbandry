package com.example.myapplication_1.viewmodel;

import com.example.myapplication_1.HomeActivity;
import com.example.myapplication_1.R;
import com.example.myapplication_1.api.ThingsBoardHelp;
import com.example.myapplication_1.model.SensorModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {
    private List<SensorModel> sensors;

    public void init(HomeActivity context){
        sensors = new ArrayList<>();
        sensors.add(new SensorModel(context, R.drawable.temerature, ThingsBoardHelp.TEMP_DEVICE_NAME,0, "℃", ThingsBoardHelp.TEMP_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.humidity, ThingsBoardHelp.HUMI_DEVICE_NAME,0, "%RH", ThingsBoardHelp.HUMI_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.redray, ThingsBoardHelp.BODY_DEVICE_NAME,0, "", ThingsBoardHelp.BODY_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.pressure, ThingsBoardHelp.PA_DEVICE_NAME,0, "Pa", ThingsBoardHelp.PA_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.pm25, ThingsBoardHelp.PM25_DEVICE_NAME,0, "ppm", ThingsBoardHelp.PM25_DEVICE_ID));
        sensors.add(new SensorModel(context, R.drawable.tvoc, ThingsBoardHelp.TVOC_DEVICE_NAME,0, "ppm", ThingsBoardHelp.TVOC_DEVICE_ID));

        for(SensorModel sensor: sensors){
            sensor.startCollection();
        }
    }

    public List<SensorModel> getSensors() {
        return sensors;
    }
}
