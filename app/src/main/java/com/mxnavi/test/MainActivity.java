package com.mxnavi.test;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ZipAniView mAniView;
    private String nowMenu="assets/resource.zip";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAniView= (ZipAniView)findViewById(R.id.mAni);
        mAniView.setScaleType(Gl2Utils.TYPE_CENTERINSIDE);
        mAniView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mAniView.isPlay()){
                    mAniView.setAnimation(nowMenu,50);
                    mAniView.start();
                }
            }
        });
        mAniView.setStateChangeListener(new StateChangeListener() {
            @Override
            public void onStateChanged(int lastState, int nowState) {
                if(nowState==STOP){
                    if(!mAniView.isPlay()){
                        mAniView.setAnimation(nowMenu,50);
                        mAniView.start();
                    }
                }
            }
        });
    }
}
