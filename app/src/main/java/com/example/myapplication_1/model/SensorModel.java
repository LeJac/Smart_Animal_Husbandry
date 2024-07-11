package com.example.myapplication_1.model;


import com.example.myapplication_1.HomeActivity;
import com.example.myapplication_1.view.DeviceView;

public class SensorModel extends DeviceModel {
    private String unit;//传感器单位

    public SensorModel(DeviceView context, int iconID, String name, double value, String unit, String deviceID) {
        super(context, iconID, name, deviceID, String.valueOf(value));
        this.unit = unit;
    }


    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getUnit() {
        return unit;
    }

    public void setValue(double value) {
        this.value = String.valueOf(value);
    }

    public double getValue() {
        return Double.valueOf(this.value);
    }

}
