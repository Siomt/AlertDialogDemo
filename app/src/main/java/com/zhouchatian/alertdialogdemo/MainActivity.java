package com.zhouchatian.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] single_list = {"男","女","未知"};
    String [] multi_list = {"Java","Php","Python","Kotlin","C","C++","Go"};
    String [] item_list = {"项目经理","测试","美工","程序猿","设计","产品","前台"};
    boolean [] chose = { false, false, true, false, true ,true,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.confirm_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmDialog();
            }
        });

        findViewById(R.id.single_choice_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleChoiceDialog();
            }
        });
        findViewById(R.id.multi_choice_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMultiChoiceDialog();
            }
        });

        findViewById(R.id.list_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListDialog();
            }
        });

        findViewById(R.id.custom_dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    /**
     * 确定对话框
     */
    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setMessage("确定要退出吗？");//设置内容
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "点击了取消按钮！",
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_LONG).show();
            }
        });
//        builder.setNeutralButton("退出", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "点击了退出按钮", Toast.LENGTH_LONG).show();
//            }
//        });
        builder.create();//获取dialog
        builder.show();//显示对话框
//        AlertDialog dialog = builder.create();//获取dialog
//        dialog.show();//显示对话框
    }

    /**
     * 单选对话框
     */
    private void showSingleChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("单选对话框");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        //第二个参数为默认选择那一个，从0开始
        builder.setSingleChoiceItems(single_list, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = single_list[i];
                Toast.makeText(MainActivity.this, "这个人是"+str+"！",
                        Toast.LENGTH_SHORT).show();
//                dialogInterface.dismiss();//隐藏dialog
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }

    /**
     * 显示多选按钮对话框
     */
    private void showMultiChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("计算机语言");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        //第二个参数如果全不选，可以传 null
        builder.setMultiChoiceItems(multi_list, chose, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "我选择"+multi_list[which]+"！",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "我取消了"+multi_list[which]+"了！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }

    /**
     * 显示列表对话框
     */
    private void showListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("部门列表");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "我点了"+item_list[which]+"！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }
    /**
     * 显示自定义对话框
     */
    private void showCustomDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_layout, null);
        view.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了登录", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("自定义对话框");//设置标题
//        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setView(view);
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }
}
