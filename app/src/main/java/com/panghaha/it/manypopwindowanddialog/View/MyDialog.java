package com.panghaha.it.manypopwindowanddialog.View;

/**
 * Created by pang on 2017/4/4.
 *  自定义 dialog对话框
 */
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.panghaha.it.manypopwindowanddialog.R;


public class MyDialog extends Dialog {
    private LinearLayout xiangce;
    private LinearLayout paizhao;
    private Context mcontext;
    private onPaizhao_OnclickListener onpaizhao_onclickListener;//拍照按钮被点击了的监听器
    private onXiangce_OnclickListener onxiangce_onclickListener;//相册按钮被点击了的监听器

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param
     * @param
     */
    public void set_paizhao_OnclickListener(onPaizhao_OnclickListener paizhao_onclick) {

        this.onpaizhao_onclickListener = paizhao_onclick;
    }
    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param
     * @param
     */
    public void set_xiangce_OnclickListener( onXiangce_OnclickListener xiangce_onclick) {

        this.onxiangce_onclickListener = xiangce_onclick;
    }

    public MyDialog(Context context) {
        super(context, R.style.MyDialog);
        this.mcontext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_touxiang);
        //按空白处取消动画
        setCanceledOnTouchOutside(true);

        //初始化界面控件
        initView();
        //初始化界面控件的事件
        initEvent();
    }
    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置拍照 按钮被点击后，向外界提供监听
        paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onpaizhao_onclickListener != null) {
                    onpaizhao_onclickListener.paizhao_onClick();
                }
            }
        });
        //设置相册 按钮被点击后，向外界提供监听
        xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onxiangce_onclickListener != null) {
                    onxiangce_onclickListener.xiangce_onClick();
                }
            }
        });
    }



    /**
     * 初始化界面控件
     */
    private void initView() {

        xiangce = (LinearLayout) findViewById(R.id.xiangce);
        paizhao = (LinearLayout) findViewById(R.id.paizhao);

        
    }

    /**
     * 动态设置Activity背景透明度
     *
     * @param isopen
     */
    public void setWindowAlpa(boolean isopen) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        final Window window = ((Activity) mcontext).getWindow();
        final WindowManager.LayoutParams lp = window.getAttributes();
        window.setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ValueAnimator animator;
        if (isopen) {
            animator = ValueAnimator.ofFloat(1.0f, 0.5f);
        } else {
            animator = ValueAnimator.ofFloat(0.5f, 1.0f);
        }
        animator.setDuration(400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                lp.alpha = alpha;
                window.setAttributes(lp);
            }
        });
        animator.start();
    }


    /**
     * 设置确定按钮和取消被点击的接口
     * 相册 拍照
     */
    public interface onPaizhao_OnclickListener {
         void paizhao_onClick();
    }

    public interface onXiangce_OnclickListener {
         void xiangce_onClick();
    }
}
