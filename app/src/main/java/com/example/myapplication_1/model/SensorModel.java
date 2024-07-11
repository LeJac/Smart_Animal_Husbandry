package com.example.myapplication_1.model;


public class SensorModel extends DeviceModel {
    private String unit;//传感器单位
    public SensorModel(int iconID, String name, String deviceId, double value, String unit) {
        super(iconID, name, deviceId,value);
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }




}
