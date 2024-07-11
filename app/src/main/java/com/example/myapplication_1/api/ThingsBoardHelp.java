package com.example.myapplication_1.api;

/**
 * ThingsBoard帮助类
 *
 * @author linho
 *
 */
public class ThingsBoardHelp {
    //AIOT平台登录URL
    public static final String AIOT_LOGIN_URL = "https://upms-gateway.nlecloud.com/api-uaa/oauth/token";
    //AIOT中的ThingsBoard登录URL
    public static final String TB_LOGIN_URL = "https://aiot-gateway.nlecloud.com/api-teaching/getTbUserToken";
    //ThingsBoard主机地址
    public static final String BASE_URL = "https://tb.nlecloud.com";
    //获取设备数据URL
    public static final String DEVICE_VALUE_URL_BASE = BASE_URL + "/api/plugins/telemetry/DEVICE/";
    //控制设备URL
    public static final String RPC_URL = BASE_URL + "/api/plugins/rpc/oneway/";


    //下面设置自己的设备ID
    public static final String TEMP_DEVICE_NAME = "温度";
    public static final String TEMP_DEVICE_ID = "0be14f60-39d4-11ef-a6dc-dfee39fa18bc";
    public static final String HUMI_DEVICE_NAME = "湿度";
    public static final String HUMI_DEVICE_ID = "131bbe50-39d4-11ef-bb0b-ddcaf4ab0189";
    public static final String BODY_DEVICE_NAME = "人体红外";
    public static final String BODY_DEVICE_ID = "15a46500-39d4-11ef-8811-19e854d50255";
    public static final String PA_DEVICE_NAME = "大气压";
    public static final String PA_DEVICE_ID = "18792fe0-39d4-11ef-bb0b-ddcaf4ab0189";
    public static final String PM25_DEVICE_NAME = "PM2.5";
    public static final String PM25_DEVICE_ID = "1aa25170-39d4-11ef-bb0b-ddcaf4ab0189";
    public static final String TVOC_DEVICE_NAME = "TVOC";
    public static final String TVOC_DEVICE_ID = "1cf7b320-39d4-11ef-a6dc-dfee39fa18bc";

    public static final String LED0_DEVICE_NAME = "灯泡0";
    public static final String LED0_DEVICE_ID = "009ce130-39e5-11ef-bb0b-ddcaf4ab0189";
    public static final String LED1_DEVICE_NAME = "灯泡1";
    public static final String LED1_DEVICE_ID = "00ca59d0-39e5-11ef-bb0b-ddcaf4ab0189";
    public static final String LED2_DEVICE_NAME = "灯泡2";
    public static final String LED2_DEVICE_ID = "00e13d30-39e5-11ef-a6dc-dfee39fa18bc";

}