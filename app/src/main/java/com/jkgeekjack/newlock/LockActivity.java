package com.jkgeekjack.newlock;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LockActivity extends Activity implements View.OnClickListener {
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv0;
    private TextView tvCancle;
    private ImageView ivCircle1;
    private ImageView ivCircle2;
    private ImageView ivCircle3;
    private ImageView ivCircle4;
    private String insertPwd;
    private List<ImageView> circles=new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        initView();
        initListener();
    }
    private void initListener() {
        tv0.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        tvCancle.setOnClickListener(this);
    }
    private void initView() {
        tv0= (TextView) findViewById(R.id.tv0);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        tv5= (TextView) findViewById(R.id.tv5);
        tv6= (TextView) findViewById(R.id.tv6);
        tv7= (TextView) findViewById(R.id.tv7);
        tv8= (TextView) findViewById(R.id.tv8);
        tv9= (TextView) findViewById(R.id.tv9);
        tv0= (TextView) findViewById(R.id.tv0);
        tvCancle= (TextView) findViewById(R.id.tvCancle);
        ivCircle1= (ImageView) findViewById(R.id.ivCircle1);
        ivCircle2= (ImageView) findViewById(R.id.ivCircle2);
        ivCircle3= (ImageView) findViewById(R.id.ivCircle3);
        ivCircle4= (ImageView) findViewById(R.id.ivCircle4);
        circles.add(ivCircle1);
        circles.add(ivCircle2);
        circles.add(ivCircle3);
        circles.add(ivCircle4);
        clearCircle();
        insertPwd="";
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv0:addToPwd(0);break;
            case R.id.tv1:addToPwd(1);break;
            case R.id.tv2:addToPwd(2);break;
            case R.id.tv3:addToPwd(3);break;
            case R.id.tv4:addToPwd(4);break;
            case R.id.tv5:addToPwd(5);break;
            case R.id.tv6:addToPwd(6);break;
            case R.id.tv7:addToPwd(7);break;
            case R.id.tv8:addToPwd(8);break;
            case R.id.tv9:addToPwd(9);break;
            case R.id.tvCancle:
                if (insertPwd.length()>0){
                    insertPwd=insertPwd.substring(0,insertPwd.length()-1);
                }
                updateUi();
                break;
        }
    }
    //每输入一位刷新一次UI
    public void addToPwd(int num){
        insertPwd+=num;
        updateUi();
        //满4位确认是否为正确密码
        if (insertPwd.length()==4){
            comfirmPwd();
        }
    }
    private void comfirmPwd() {
        String pwd="1234";
        if (pwd.equals(insertPwd)){
            Toast.makeText(LockActivity.this,"密码正确",Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(LockActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
        }
        insertPwd="";
        clearCircle();
    }
    //清空圆点
    private void clearCircle() {
        for (ImageView circle:circles){
            circle.setVisibility(View.INVISIBLE);
        }
    }
    public void updateUi(){
        clearCircle();
        for (int i=0;i<insertPwd.length();i++){
            circles.get(i).setVisibility(View.VISIBLE);
        }
    }
    //如果是在锁界面点击返回则不产生反应
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
