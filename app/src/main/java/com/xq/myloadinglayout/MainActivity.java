package com.xq.myloadinglayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xq.myloadinglayout.activity.LoadingActivity1;
import com.xq.myloadinglayout.activity.LoadingActivity2;
import com.xq.myloadinglayout.activity.LoadingActivity3;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.btn1).setOnClickListener(this);
        this.findViewById(R.id.btn2).setOnClickListener(this);
        this.findViewById(R.id.btn3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, LoadingActivity1.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, LoadingActivity2.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, LoadingActivity3.class));
                break;
        }
    }
}
