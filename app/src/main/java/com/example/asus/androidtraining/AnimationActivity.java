package com.example.asus.androidtraining;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
        bindAction();
    }

    private void bindAction() {
        img.setImageResource(R.drawable.animation_list);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationDrawable aniDrawable = (AnimationDrawable) img.getDrawable();
                aniDrawable.start();

            }
        });
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.animationList);
        btn = (Button) findViewById(R.id.animationListActionButton);
    }
}
