package com.example.myapplication_1.model;

import android.util.Log;

import com.example.myapplication_1.api.ThingsBoardHelp;
import com.example.myapplication_1.utils.OkHttpUtil;
import com.example.myapplication_1.view.DeviceView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ActuatorModel extends DeviceModel{

    public ActuatorModel(DeviceView context, int iconID, String name, int state , String deviceID) {
        super(context, iconID, name, deviceID, String.valueOf(state));
    }

    public void control(int open){
        //发送请求，控制设备
        //https://tb.nlecloud.com/api/plugins/rpc/oneway/db10c750-930a-11ee-bd26-a1c236e96f64
        String url = ThingsBoardHelp.RPC_URL + getDeviceID();
        Log.e("request_data","url:"+url);
        //{""method"":""setValue"",""params"":0}
        String json = "{\"method\":\"setValue\",\"params\":"+open+"}";
        OkHttpUtil.post(url, json,new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //请求结果失败处理
                Log.e("request_data",e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //请求结果成功处理
                String data = response.body().string();
                Log.d("request_data","控制成功："+data);
            }
        });
    }

    public int getValue(){
        return Integer.valueOf(value);
    }

    public void setValue(int state){
        this.value = String.valueOf(state);
    }

}

