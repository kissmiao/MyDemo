package com.hongliang.demo;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import com.hongliang.demo.view.FloatingView;

public class FloatingService extends Service {
    private Context mContext;
    public static final String ACTION = "action";
    public static final String SHOW = "show";
    public static final String HIDE = "hide";
    private FloatingView mFloatingView;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;


        //mFloatingView=new FloatingView(this,R.drawable.select_btn_floating);
        @SuppressLint("ResourceType") XmlResourceParser parser = mContext.getResources().getXml(R.layout.floating_view);
        AttributeSet attributes = Xml.asAttributeSet(parser);
        mFloatingView = new FloatingView(this, attributes);
        Log.i("LOG", "mFloatingView" + mFloatingView);

        mFloatingView.setOnFloatingClickListener(new FloatingView.onFloatClicklistener() {
            @Override
            public void onFloatingClick() {
                //todo 点击浮动按钮的时候 比如返回MainActivity

              /*  Intent intent=new Intent();
                intent.setAction(MainActivity.ACTION_BACK_MAIN);
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);*/
                //手电
/*                if(!FlashLightUtils.isOpen()){
                    try {

                        FlashLightUtils.openFlash(getApplication());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{

                    try {
                        FlashLightUtils.closeFlash();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }*/
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getStringExtra(ACTION);

            Log.i("LOG", "action========" + action);
            if (SHOW.equals(action)) {
                mFloatingView.show();
            } else if (HIDE.equals(action)) {
                mFloatingView.hide();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

}
