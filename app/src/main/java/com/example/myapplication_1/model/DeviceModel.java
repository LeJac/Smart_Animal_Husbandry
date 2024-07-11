package com.example.myapplication_1.model;

import java.util.Timer;
import java.util.TimerTask;

public class DeviceModel {
    private int iconID; //图标资源id
    private String name; //名字
    private String deviceId;//设备id
    private double value; //设备状态：0为关，1为开


    public DeviceModel(){
    }

    public DeviceModel(int iconID, String name, String deviceId, double value) {
        this.iconID = iconID;
        this.name = name;
        this.deviceId = deviceId;
        this.value = value;
    }



    public void collection(){
        //启动一个定时器，每间隔一段事件采集一次数据
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //发送请求，获取传感器数据
            }
        },100,3000);
    }

    public String getName() {
        return name;
    }



    public int getIconID() {
        return iconID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
