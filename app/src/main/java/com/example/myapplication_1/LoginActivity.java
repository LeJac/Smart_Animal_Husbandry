package com.example.myapplication_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.utils.OkHttpUtil;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    //声明要用到的控件
    EditText etAccount; //账号输入框
    EditText etPassword;//密码输入框
    Button btnLogin;  //登录按钮



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }


    private  void initView(){

        //绑定布局中的控件
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        //注册按钮的点击事件监听器
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //处理点击效果
                //获取输入框中的账号密码
               final String account  = etAccount.getText().toString();
               final String password = etPassword.getText().toString();

                //将账号密码以土司弹窗（弹出后消失）显示
//                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show(); //上下文环境activity对象
                //创建线程
                new Thread(){
                    @Override
                    public void run(){
                        //把账号密码以http的方式发送到服务器
                        login(account,password);
                    }
                }.start();



            }
        });
    }
    //登录
    private void login(String account, String password) {
        //https://upms-gateway.nlecloud.com/api-uaa/oauth/token?grant_type=password&username=20240000218&password=123456
        String urlAIOT = "https://upms-gateway.nlecloud.com/api-uaa/oauth/token";
        //参数部分：grant_type=password&username=20246666661&password=123456
        urlAIOT += "?grant_type=password&username=" + account + "&password=" + password;
        Log.d("login", "url:" + urlAIOT);
        //1.创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //2.构建请求对象
        Request.Builder build = new Request.Builder();
        build.addHeader("Accept", "application/json");
        build.addHeader("Authorization", "Basic YWlvdC1hcHA6MTIzNDU2");
        //构建请求包体
        MediaType jsonType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create("", jsonType);
        Request request = build
                .url(urlAIOT)
                .post(body)
                .build();
        try {
            //3.发送请求(同步方式)
            Response resp = client.newCall(request).execute();
            //获取响应数据
            String result = resp.body().string();
            Log.d("login", "aiot登录响应结果：" + result);
            //使用Android SDK JsonObject解析
            JSONObject jsonObject = new JSONObject(result);
            //{"data":
            // {
            // "access_token":"0db3bd84-887f-4ec1-90b6-9a035e524bb9",
            // "token_type":"bearer","refresh_token":"b14f21b1-f605-4a89-9250-791581f83108",
            // "expires_in":17999,"scope":"all"
            // },
            // "code":200,"message":""}
            //获取成功code字段值
            int code = jsonObject.getInt("code");
            //Log.d("login", "code：" + code);
            if(code == 200){
                String accessToken = jsonObject.getJSONObject("data").getString("access_token");
                Log.d("login", "aiot登录响应结果accessToken=：" + accessToken);
                //登录ThingsBoard平台
                //curl -X POST https://aiot-gateway.nlecloud.com/api-teaching/getTbUserToken
                // --header "Accept: application/json"
                // --header "Authorization:Bearer 66fdbb5b-efe7-4bd9-a6a9-c334a1be903a"
                String urlTB = "https://aiot-gateway.nlecloud.com/api-teaching/getTbUserToken";
                Request.Builder build2 = new Request.Builder();
                build2.addHeader("Accept", "application/json");
                if(accessToken!=null){
                    build2.addHeader("Authorization", "Bearer "+accessToken);
                }
                //构建请求包体
                RequestBody body2 = RequestBody.create("", jsonType);
                Request request2 = build2
                        .url(urlTB)
                        .post(body)
                        .build();
                Response resp2 = client.newCall(request2).execute();
                //获取响应数据
                String result2 = resp2.body().string();
                Log.d("login", "ThingsBoard登录响应结果：" + result2);
                //解析result2结果
                JSONObject jsonObject2 = new JSONObject(result2);
                int code2 = jsonObject2.getInt("code");
                if(code2 == 200){
                    OkHttpUtil.tbToken = jsonObject2.getString("message");
                    Log.d("login", "ThingsBoard登录成功Token：" + OkHttpUtil.tbToken);
                    showToastOnUIThread("登陆成功");
                    dealLoginResult(true);

                }else {
                    dealLoginResult(false);
                }
            }else{
                    dealLoginResult(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //在UI线程中弹窗
    private void dealLoginResult(final boolean isSuccess){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isSuccess){
                    //左边是当前环境对象，右边是目标页面容器的class对象
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    //在UI线程中弹窗
    private void showToastOnUIThread(final String msg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
