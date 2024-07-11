package com.example.myapplication_1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication_1.R;
import com.example.myapplication_1.model.SensorModel;

import java.util.List;

/*
 * 设备列表适配器
 */
public class SensorsAdapter extends BaseAdapter {
    private Context context;
    private List<SensorModel> datas;

    public SensorsAdapter(Context context, List<SensorModel>datas){
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
    public SensorModel getItem(int position) {
        return datas.get(position);
    }

    //返回条目所在的索引（位置编号）
    @Override
    public long getItemId(int position) {
        return position;
    }

    //返回条目的视图(最重要)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){  //条目视图只需要第一次出现的时候才绑定
            //条目的视图,绑定条目的布局
            Log.d("getView","条目"+position);
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sensors,null);

            viewHolder = new ViewHolder();
            //初始化条目的控件，设置图标、文本、点击事件处理
            viewHolder.ivIcon = convertView.findViewById(R.id.iv_sensors);
            viewHolder.tvName = convertView.findViewById(R.id.tv_sensors_name);
            viewHolder.tvValue = convertView.findViewById(R.id.tv_sensors_value);
            //设置标记
            convertView.setTag(viewHolder);
        }else{
            //不是第一次出现的条目视图，从viewHolder中获取
            viewHolder = (ViewHolder)convertView.getTag();
        }

        //设置条目数据
        final SensorModel sensor = getItem(position);
        viewHolder.ivIcon.setImageResource(sensor.getIconID());
        viewHolder.tvName.setText(sensor.getName());
        viewHolder.tvValue.setText(sensor.getValue()+sensor.getUnit());


        return convertView;
    }

    //补充优化部分：内部类
    class ViewHolder{
        ImageView ivIcon;
        TextView tvName;
        TextView tvValue;
    }
}
