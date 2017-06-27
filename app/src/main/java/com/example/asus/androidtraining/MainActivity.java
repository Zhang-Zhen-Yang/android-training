package com.example.asus.androidtraining;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button animationDemo;
    Button mediaPlayerDemo;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bindAction();
    }

    private void bindAction() {
        animationDemo.setOnClickListener(this);
        mediaPlayerDemo.setOnClickListener(this);
    }

    private void initView() {
        animationDemo = (Button) findViewById(R.id.animationDemo);
        mediaPlayerDemo  = (Button) findViewById(R.id.mediaPlayerDemo);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.animationDemo:
                startActivity(new Intent(context,AnimationActivity.class));
                break;
            case R.id.mediaPlayerDemo:
                startActivity(new Intent(context,MediaPlayerActivity.class));
                break;
            default :break;

        }
    }
}
