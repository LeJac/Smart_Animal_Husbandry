package com.example.myapplication_1.model;

import android.util.Log;

import com.example.myapplication_1.api.ThingsBoardHelp;
import com.example.myapplication_1.utils.OkHttpUtil;
import com.example.myapplication_1.view.DeviceView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DeviceModel {
    protected int iconID;
    protected String name;
    protected String deviceID;
    protected String value;
    private DeviceView context;//上下文环境

    public DeviceModel(DeviceView context, int iconID, String name, String deviceID, String value) {
        this.iconID = iconID;
        this.name = name;
        this.deviceID = deviceID;
        this.value = value;
        this.context = context;
    }


    public void startCollection(){
        //启动采集数据定时器
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                collect();
            }
        }, 100, 3000);
    }

    private void collect(){
        //获取设备数据
        String url = ThingsBoardHelp.DEVICE_VALUE_URL_BASE + deviceID + "/values/timeseries?useStrictDataTypes=true";
        OkHttpUtil.get(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("request_data", e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String bodyStr = response.body().string();
                Log.d("request_data", bodyStr);
                try {
                    JSONObject body = new JSONObject(bodyStr);
                    value = body.getJSONArray("value").getJSONObject(0).getString("value");
                    Log.d("value:",value);
                    context.handler.sendEmptyMessage(200);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public int getIconID() {
        return iconID;
    }

    public String getName() {
        return name;
    }

    public String getDeviceID() {
        return deviceID;
    }
}

