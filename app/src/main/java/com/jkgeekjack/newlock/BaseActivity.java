package com.jkgeekjack.newlock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2016/6/7.
 */
public class BaseActivity extends AppCompatActivity {
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences=getSharedPreferences("sp",MODE_PRIVATE);//sp为sharepreference名字
        editor=sharedPreferences.edit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //如果lock值是false是真的就弹出锁屏，假的话就设为真
        if (sharedPreferences.getBoolean("lock",false)){
            startActivity(new Intent(BaseActivity.this,LockActivity.class));
            editor.putBoolean("lock",false);
            editor.commit();
        }else {
            editor.putBoolean("lock",true);
            editor.commit();
        }

    }

    //按返回键时将lock设为假
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            editor.putBoolean("lock",false);
            editor.commit();
        }
        return super.onKeyDown(keyCode, event);
    }
}
//    public <T>void mstartActivity (Class<T> tClass ){
//        startActivity(new Intent(BaseActivity.this,tClass));
//        editor.putBoolean("inner",false);
//        editor.commit();
//    }
//
//    public void mfinish(){
//        editor.putBoolean("lock",false);
//        editor.commit();
//        finish();
//    }