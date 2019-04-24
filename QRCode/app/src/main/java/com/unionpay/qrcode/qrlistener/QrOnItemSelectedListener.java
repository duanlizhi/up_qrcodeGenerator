package com.unionpay.qrcode.qrlistener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.unionpay.qrcode.activity.HandleString;

/**
 * @author homels
 * @date 2019/3/19
 */
public class QrOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    String tag;
    String[] list = null;
    HandleString handleString;
    public QrOnItemSelectedListener(String[] list, String tag, HandleString handleString){
        this.list = list;
        this.tag = tag;
        this.handleString = handleString;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(tag.equals("1")){
            //选择支付系统
            Toast.makeText(adapterView.getContext(), list[i], Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
