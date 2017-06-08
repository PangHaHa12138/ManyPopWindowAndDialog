package com.panghaha.it.manypopwindowanddialog;

/**
 * Created by pang on 2017/3/28.
 *
 * 重写的一个Activity 的基类，在基类中实现了一个TooBar 用TooBar来展示一个标题
 * 同时定义一个Back按钮，点击的时候退出当前的Activity
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public abstract class BaseToobarChangeStateActivity extends AppCompatActivity {

    private static final String TAG = BaseToobarChangeStateActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private RelativeLayout acceptjob_tag,sendjob_tag;
    private TextView acceptjob_text,sendjob_text,chosemodelname;
    private LinearLayout chosemodelview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mToolbar = (Toolbar) findViewById(R.id.base_toobar);
        acceptjob_tag = (RelativeLayout) findViewById(R.id.acceptjob_tag);
        sendjob_tag = (RelativeLayout) findViewById(R.id.sendjob_tag);
        acceptjob_text = (TextView) findViewById(R.id.acceptjob_text);
        sendjob_text = (TextView) findViewById(R.id.sendjob_text);
        chosemodelname = (TextView) findViewById(R.id.chosemodelname);
        chosemodelview = (LinearLayout) findViewById(R.id.chosemodelview);

       /*
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("Title");
        toolbar.setSubtitle("Sub Title");
        */

        if (mToolbar != null) {
            //将Toolbar显示到界面
            setSupportActionBar(mToolbar);
            //设置默认的标题不显示
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * 判断是否有Toolbar,并默认显示返回按钮
         */
        if(null != getToolbar() && isShowBacking()){
            showBack();
        }
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        checkNetwork();
//    }
//
//    private boolean checkNetwork() {
//        if (!NetworkUtils.checkNetwork(this)) {
//            ToastUtil.showToast("手机无可用网络");
//        }
//        return true;
//    }

    public TextView getSendjob_text(){
        return sendjob_text;
    }

    public TextView getAcceptjob_text(){
        return acceptjob_text;
    }
    public RelativeLayout getAcceptjob_tag(){
        return acceptjob_tag;
    }
    public RelativeLayout getSendjob_tag(){
        return sendjob_tag;
    }
   public TextView getChoseModelName(){
       return chosemodelname;
   }
    public LinearLayout getChoseModelBut(){
        return chosemodelview;
    }

    /**
     * this Activity of tool bar.
     * 获取头部.
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.base_toobar);
    }

    /**
     * 版本号小于21的后退按钮图片
     */
    private void showBack(){
        //setNavigationIcon必须在setSupportActionBar(toolbar);方法后面加入
        getToolbar().setNavigationIcon(R.drawable.ic_back);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 是否显示后退按钮,默认显示,可在子类重写该方法.
     * @return
     */
    protected boolean isShowBacking(){
        return true;
    }

    /**
     * this activity layout res
     * 设置layout布局,在子类重写该方法.
     * @return res layout xml id
     */
    protected abstract int getLayoutId();



}
