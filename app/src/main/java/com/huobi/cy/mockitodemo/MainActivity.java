package com.huobi.cy.mockitodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {

    private int[] sizeArray = {34, 50, 68, 100};
    private int sizeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LottieAnimationView lav_main = findViewById(R.id.lav_main);
        final LottieAnimationView lav_main1 = findViewById(R.id.lav_main1);
        final LottieAnimationView lav_main2 = findViewById(R.id.lav_main2);
        final LottieAnimationView lav_main3 = findViewById(R.id.lav_main3);
        Button btn_switch = findViewById(R.id.btn_switch_size);
        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sizeIndex >= sizeArray.length) {
                    sizeIndex = 0;
                }
                ViewGroup.LayoutParams lp = lav_main.getLayoutParams();
                lp.width = lp.height = dip2px(sizeArray[sizeIndex]);
                lav_main.setLayoutParams(lp);

                lp = lav_main1.getLayoutParams();
                lp.width = lp.height = dip2px(sizeArray[sizeIndex]);
                lav_main1.setLayoutParams(lp);


                lp = lav_main2.getLayoutParams();
                lp.width = lp.height = dip2px(sizeArray[sizeIndex]);
                lav_main2.setLayoutParams(lp);

                lp = lav_main3.getLayoutParams();
                lp.width = lp.height = dip2px(sizeArray[sizeIndex]);
                lav_main3.setLayoutParams(lp);

                sizeIndex ++;

            }
        });
        lav_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lav_main.setAnimation("lottie/ic_tab_chat.json");
                lav_main.enableMergePathsForKitKatAndAbove(true);
                lav_main.useHardwareAcceleration();
                lav_main.playAnimation();
            }
        });
        lav_main1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lav_main1.setAnimation("lottie/ic_tab_contacts.json");
                lav_main1.enableMergePathsForKitKatAndAbove(true);
                lav_main1.useHardwareAcceleration();
                lav_main1.playAnimation();
            }
        });
        lav_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lav_main2.setAnimation("lottie/ic_tab_discovery.json");
                lav_main2.enableMergePathsForKitKatAndAbove(true);
                lav_main2.useHardwareAcceleration();
                lav_main2.playAnimation();
            }
        });
        lav_main3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lav_main3.setAnimation("lottie/ic_tab_me.json");
                lav_main3.enableMergePathsForKitKatAndAbove(true);
                lav_main3.useHardwareAcceleration();
                lav_main3.playAnimation();
            }
        });
    }

    public int dip2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
