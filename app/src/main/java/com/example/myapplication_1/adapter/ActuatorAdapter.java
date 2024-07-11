package com.example.myapplication_1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication_1.R;
import com.example.myapplication_1.model.ActuatorModel;

import java.util.List;

/**
 * 设备列表适配器
 */
public class ActuatorAdapter extends BaseAdapter {
    private Context context;
    private List<ActuatorModel> datas;

    public ActuatorAdapter(Context context, List<ActuatorModel> datas){
        this.context = context;
        this.datas = datas;
    }
    //返回条目的数量
    @Override
    public int getCount() {
        return datas.size();
    }
    //返回条目对象
    @Override
    public ActuatorModel getItem(int position) {
        return datas.get(position);
    }
    //返回条目所在的索引（位置）
    @Override
    public long getItemId(int position) {
        return position;
    }

    //返回条目视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //使用内部类viewholder优化getView
        ViewHolder viewHolder;
        if(convertView == null){
            Log.d("getView","条目："+position);
            //第一次条目出现时，绑定条目布局
            convertView = LayoutInflater.from(context).inflate(R.layout.item_devices,null);
            viewHolder = new ViewHolder();
            //初始化条目的控件，设置图标、文本、点击事件处理
            viewHolder.ivIcon = convertView.findViewById(R.id.iv_icon);
            viewHolder.tvName = convertView.findViewById(R.id.tv_device_name);
            viewHolder.btnDevice = convertView.findViewById(R.id.stc_open);

            //设置标记
            convertView.setTag(viewHolder);
        }else {
            //不是第一次出现的条目视图，从viewHolder中获取
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //设置条目数据
        final ActuatorModel device = getItem(position);
        viewHolder.ivIcon.setImageResource(device.getIconID());
        viewHolder.tvName.setText(device.getName());
        viewHolder.btnDevice.setText(device.getValue()==0?"开":"关");
        //注册按钮的监听器
        viewHolder.btnDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送开关指令
                double state = device.getValue();
                Log.d("getView","设置前：state："+state);
                if(state==0){
                    //发送打开设备指令
                    state = 1;
                }else{
                    //发送关闭设备指令
                    state = 0;
                }
                Log.d("getView","设置后：state："+state);
                //设置按钮上的文本
                device.setValue(state);
                //通知数据变化，刷新UI
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder{
        ImageView ivIcon;
        TextView tvName;
        Button btnDevice;
    }
}
