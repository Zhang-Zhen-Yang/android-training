package com.example.asus.androidtraining;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button animationDemo;
    Button mediaPlayerDemo;
    Button menuDemo;
    Button viewDemo;
    Button listViewDemo;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bindAction();
        getSupportActionBar().hide();
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
    }

    private void bindAction() {
        animationDemo.setOnClickListener(this);
        mediaPlayerDemo.setOnClickListener(this);
        menuDemo.setOnClickListener(this);
        viewDemo.setOnClickListener(this);
        listViewDemo.setOnClickListener(this);
    }

    private void initView() {
        animationDemo = (Button) findViewById(R.id.animationDemo);
        mediaPlayerDemo  = (Button) findViewById(R.id.mediaPlayerDemo);
        menuDemo  = (Button) findViewById(R.id.menuDemo);
        viewDemo  = (Button) findViewById(R.id.viewDemo);
        listViewDemo  = (Button) findViewById(R.id.listViewDemo);
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
            case R.id.menuDemo:
                Toast.makeText(this, "apple", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context,MenuActivity.class));
                break;
            case R.id.viewDemo:
                startActivity(new Intent(context,ViewActivity.class));
                break;
            case R.id.listViewDemo:
                startActivity(new Intent(context,ListViewActivity.class));
                break;
            default :break;

        }
    }
}
