package com.panghaha.it.manypopwindowanddialog;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.panghaha.it.manypopwindowanddialog.View.TopPopupWindows;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/6/8.
 *  仿微信右上+号角弹窗
 */
public class Pop4 extends BaseToobarChangeStateActivity {

    private RelativeLayout month,day,year,jidu,date_layout;
    private TextView month_text,day_text,year_text,jidu_text;
    private View shu1,shu2,shu3;
    private TextView ChoseModelName;
    private LinearLayout ChoseModelBut;
    private TopPopupWindows topPopupWindows;
    private ImageView jiatu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        month = (RelativeLayout) findViewById(R.id.month);
        day = (RelativeLayout) findViewById(R.id.day);
        year = (RelativeLayout) findViewById(R.id.year);
        jidu = (RelativeLayout) findViewById(R.id.jidu);
        month_text = (TextView) findViewById(R.id.month_text);
        day_text = (TextView) findViewById(R.id.day_text);
        year_text = (TextView) findViewById(R.id.year_text);
        jidu_text = (TextView) findViewById(R.id.jidu_text);
        shu1 = findViewById(R.id.shu1);
        shu2 = findViewById(R.id.shu2);
        shu3 = findViewById(R.id.shu3);

        date_layout = (RelativeLayout) findViewById(R.id.date_layout);

        jiatu = (ImageView) findViewById(R.id.jiatu);
        ChoseModelBut = getChoseModelBut();
        ChoseModelName = getChoseModelName();

        onclick();
    }

    private void onclick() {

        getSendjob_tag().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSendjob_tag().setBackgroundResource(R.drawable.add_renwu_bg);
                getSendjob_text().setTextColor(getResources().getColor(R.color.left_menu_font));
                getAcceptjob_tag().setBackgroundResource(R.color.touming);
                getAcceptjob_text().setTextColor(getResources().getColor(R.color.white));
//                choseRenwuType = 8;
//                if (personcode == 1){
//                    http(choseDate);
//                }else if (personcode == 2){
//                    http2();
//                }else if (personcode == 3){
//                    http3();
//                }


            }
        });
        getAcceptjob_tag().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAcceptjob_tag().setBackgroundResource(R.drawable.add_renwu_bg);
                getAcceptjob_text().setTextColor(getResources().getColor(R.color.left_menu_font));
                getSendjob_tag().setBackgroundResource(R.color.touming);
                getSendjob_text().setTextColor(getResources().getColor(R.color.white));
//                choseRenwuType = 7;
//                if (personcode == 1){
//                    http(choseDate);
//                }else if (personcode == 2){
//                    http2();
//                }else if (personcode == 3){
//                    http3();
//                }

            }
        });

        ChoseModelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTopPopwindow();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.setBackgroundResource(R.drawable.qian);
                day_text.setTextColor(getResources().getColor(R.color.shen));
                month.setBackgroundResource(R.color.touming);
                month_text.setTextColor(getResources().getColor(R.color.qian));
                year.setBackgroundResource(R.color.touming);
                year_text.setTextColor(getResources().getColor(R.color.qian));
                jidu.setBackgroundResource(R.color.touming);
                jidu_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.GONE);
                shu2.setVisibility(View.VISIBLE);
                shu3.setVisibility(View.VISIBLE);
//                choseDate = 4;
//                http(choseDate);
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                month.setBackgroundResource(R.drawable.qian);
                month_text.setTextColor(getResources().getColor(R.color.shen));
                day.setBackgroundResource(R.color.touming);
                day_text.setTextColor(getResources().getColor(R.color.qian));
                year.setBackgroundResource(R.color.touming);
                year_text.setTextColor(getResources().getColor(R.color.qian));
                jidu.setBackgroundResource(R.color.touming);
                jidu_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.GONE);
                shu2.setVisibility(View.GONE);
                shu3.setVisibility(View.VISIBLE);
//                choseDate = 1;
//                http(choseDate);
            }
        });
        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year.setBackgroundResource(R.drawable.qian);
                year_text.setTextColor(getResources().getColor(R.color.shen));
                month.setBackgroundResource(R.color.touming);
                month_text.setTextColor(getResources().getColor(R.color.qian));
                day.setBackgroundResource(R.color.touming);
                day_text.setTextColor(getResources().getColor(R.color.qian));
                jidu.setBackgroundResource(R.color.touming);
                jidu_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.VISIBLE);
                shu2.setVisibility(View.GONE);
                shu3.setVisibility(View.GONE);
//                choseDate = 3;
//                http(choseDate);
            }
        });
        jidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jidu.setBackgroundResource(R.drawable.qian);
                jidu_text.setTextColor(getResources().getColor(R.color.shen));
                month.setBackgroundResource(R.color.touming);
                month_text.setTextColor(getResources().getColor(R.color.qian));
                year.setBackgroundResource(R.color.touming);
                year_text.setTextColor(getResources().getColor(R.color.qian));
                day.setBackgroundResource(R.color.touming);
                day_text.setTextColor(getResources().getColor(R.color.qian));
                shu1.setVisibility(View.VISIBLE);
                shu2.setVisibility(View.VISIBLE);
                shu3.setVisibility(View.GONE);
//                choseDate = 2;
//                http(choseDate);
            }
        });
    }

    private void ShowTopPopwindow() {
        //显示排序弹窗
        topPopupWindows = new TopPopupWindows(Pop4.this,myMenusOnClick);
        topPopupWindows.showAsDropDown(ChoseModelBut,0,0);
    }
    private View.OnClickListener myMenusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            topPopupWindows.dismiss();
            switch (v.getId()) {
                //柱状图
                case R.id.zhu_layout:
                    ChoseModelName.setText("柱状图");

                    jiatu.setImageResource(R.drawable.zhuzhuang);
                    break;
                //折线图
                case R.id.zhexian_layout:
                    ChoseModelName.setText("折线图");
                    jiatu.setImageResource(R.drawable.zhexian);

                    break;
            }

        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.pop4;
    }
}
