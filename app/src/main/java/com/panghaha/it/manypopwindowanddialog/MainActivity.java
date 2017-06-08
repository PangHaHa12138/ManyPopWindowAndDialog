package com.panghaha.it.manypopwindowanddialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.panghaha.it.manypopwindowanddialog.View.BottomDialog;
import com.panghaha.it.manypopwindowanddialog.View.BottomPopupOption;
import com.panghaha.it.manypopwindowanddialog.View.CenterDialog;
import com.panghaha.it.manypopwindowanddialog.View.MyDialog;
import com.panghaha.it.manypopwindowanddialog.View.PhotoPopupWindows;
import com.panghaha.it.manypopwindowanddialog.View.UpdataDialog;

public class MainActivity extends AppCompatActivity {

    Button pop1,pop2,pop3,pop4,dialog1,dialog2,dialog3,dialog4;
    PhotoPopupWindows popMenus,popMenus2;
    private CenterDialog centerDialog;

    private BottomDialog bottomDialog;

    private MyDialog myDialog;
    private UpdataDialog updataDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pop1 = (Button) findViewById(R.id.pop1);
        pop2 = (Button) findViewById(R.id.pop2);
        pop3 = (Button) findViewById(R.id.pop3);
        pop4 = (Button) findViewById(R.id.pop4);
        dialog1 = (Button) findViewById(R.id.dialog1);
        dialog2 = (Button) findViewById(R.id.dialog2);
        dialog3 = (Button) findViewById(R.id.dialog3);
        dialog4 = (Button) findViewById(R.id.dialog4);

        centerDialog = new CenterDialog(MainActivity.this,R.layout.dialog_layout,new int[]{R.id.dialog_cancel, R.id.dialog_sure});

        bottomDialog = new BottomDialog(MainActivity.this,R.layout.dialog_layout,new int[]{R.id.dialog_cancel,R.id.dialog_sure});
        updataDialog = new UpdataDialog(MainActivity.this,R.layout.dialog_updataversion,
                new int[]{R.id.dialog_sure});
        pop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomPopupOption bottomPopupOption = new BottomPopupOption(MainActivity.this);
                bottomPopupOption.setItemText("拍照","相册");
                bottomPopupOption.showPopupWindow();
                bottomPopupOption.setItemClickListener(new BottomPopupOption.onPopupWindowItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        switch (position){
                            case 0:
                                Toast.makeText(MainActivity.this,"拍照",Toast.LENGTH_SHORT).show();
                                bottomPopupOption.dismiss();//点击项目消失的方法
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this,"相册",Toast.LENGTH_SHORT).show();
                                bottomPopupOption.dismiss();//点击项目消失的方法
                                break;
                        }
                    }
                });
            }
        });
        pop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopMenu();//可自定义布局的popwindow 扩展性极强 底部弹出
            }
        });
        pop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopMenu2();//居中
            }
        });
        pop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Pop4.class);
                startActivity(i);
            }
        });
        dialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                centerDialog.show();
                centerDialog.setOnCenterItemClickListener(new CenterDialog.OnCenterItemClickListener() {
                    @Override
                    public void OnCenterItemClick(CenterDialog dialog, View view) {
                        centerDialog.dismiss();
                        switch (view.getId()){
                            case R.id.dialog_sure:
                                Toast.makeText(MainActivity.this,"确定退出",Toast.LENGTH_SHORT).show();

                                break;
                        }
                    }
                });
            }
        });
        dialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                bottomDialog.show();
                bottomDialog.setOnBottomMenuItemClickListener(new BottomDialog.OnBottomMenuItemClickListener() {
                    @Override
                    public void onBottomMenuItemClick(BottomDialog dialog, View view) {
                        bottomDialog.dismiss();
                        switch (view.getId()){
                            case R.id.dialog_sure:
                                Toast.makeText(MainActivity.this,"确定退出",Toast.LENGTH_SHORT).show();

                                break;
                        }
                    }
                });


            }
        });
        dialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog = new MyDialog(MainActivity.this);
                myDialog.show();
                myDialog.setWindowAlpa(true);
                myDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        myDialog.setWindowAlpa(false);
                    }
                });
                //拍照
                myDialog.set_paizhao_OnclickListener(new MyDialog.onPaizhao_OnclickListener() {
                    @Override
                    public void paizhao_onClick() {

                        Toast.makeText(MainActivity.this,"拍照",Toast.LENGTH_SHORT).show();

                        myDialog.dismiss();
                        myDialog.setWindowAlpa(false);
                    }
                });
                //相册
                myDialog.set_xiangce_OnclickListener(new MyDialog.onXiangce_OnclickListener() {
                    @Override
                    public void xiangce_onClick() {

                        Toast.makeText(MainActivity.this,"相册",Toast.LENGTH_SHORT).show();

                        myDialog.dismiss();
                    }
                });

            }
        });
        dialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updataDialog.show();
                updataDialog.setOnCenterItemClickListener(new UpdataDialog.OnCenterItemClickListener() {
                    @Override
                    public void OnCenterItemClick(UpdataDialog dialog, View view) {
                        switch (view.getId()){
                            case R.id.dialog_sure:

                                Toast.makeText(MainActivity.this,"开启下载更新...",Toast.LENGTH_SHORT).show();
                                updataDialog.dismiss();
                                break;
                        }
                    }
                });

            }
        });
    }


    //展示弹窗 popuwindow 为底部弹出的窗口进行按钮的监听。
    private void showPopMenu() {
        //弹窗与虚拟键重合
//        popMenus.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        popMenus = new PhotoPopupWindows(MainActivity.this, myMenusOnClick);
        popMenus.showAtLocation(MainActivity.this.findViewById(R.id.main_activity),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener myMenusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus.dismiss();
            switch (v.getId()) {
                //图表统计
                case R.id.tubiaotongji:
                    Toast.makeText(MainActivity.this,"图表统计",Toast.LENGTH_SHORT).show();
                    break;
                //任务搜索
                case R.id.renwusousu:
                    Toast.makeText(MainActivity.this,"任务搜索",Toast.LENGTH_SHORT).show();
                    break;
                //排序
                case R.id.paixu:
                    Toast.makeText(MainActivity.this,"排序",Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };

    //展示弹窗 popuwindow 为底部弹出的窗口进行按钮的监听。
    private void showPopMenu2() {
        //弹窗与虚拟键重合
//        popMenus.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        popMenus2 = new PhotoPopupWindows(MainActivity.this, myMenusOnClick2);
        popMenus2.showAtLocation(MainActivity.this.findViewById(R.id.main_activity),
                Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    private View.OnClickListener myMenusOnClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popMenus2.dismiss();
            switch (v.getId()) {
                //图表统计
                case R.id.tubiaotongji:
                    Toast.makeText(MainActivity.this,"图表统计",Toast.LENGTH_SHORT).show();
                    break;
                //任务搜索
                case R.id.renwusousu:
                    Toast.makeText(MainActivity.this,"任务搜索",Toast.LENGTH_SHORT).show();
                    break;
                //排序
                case R.id.paixu:
                    Toast.makeText(MainActivity.this,"排序",Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };
}
