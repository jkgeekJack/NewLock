package com.jkgeekjack.newlock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private Button button;
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        button1= (Button) findViewById(R.id.button2);
        button2= (Button) findViewById(R.id.button3);
        //点击跳转时将lock值设为假
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                editor.putBoolean("lock",false);
                editor.commit();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
                editor.putBoolean("lock",false);
                editor.commit();
            }
        });
        //点击finish时将lock值设为假
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("lock",false);
                editor.commit();
                finish();
            }
        });
    }

}
