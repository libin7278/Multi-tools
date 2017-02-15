package com.libin.multi.tools.wifi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.libin.multi.tools.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 17/2/9.
 */

public class MyWifiRVAdapter extends RecyclerView.Adapter<MyWifiRVAdapter.ViewHolder>{
    private List mDatas = new ArrayList();
    private Context mContext;

    public MyWifiRVAdapter(Context context,List data){
        mContext = context;
        mDatas = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View inflate = layoutInflater.inflate(R.layout.wifi_mac_item,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_macid.setText(mDatas.get(position)+"");
        holder.tv_macid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.e(position+"-----");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_macid;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_macid = (TextView) itemView.findViewById(R.id.tv_macid);
        }

    }
}
