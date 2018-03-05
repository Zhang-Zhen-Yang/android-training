package com.example.asus.androidtraining;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    //1
    ImageView img;
    //2
    TextView viewAnimatonText;
    ImageView viewAnimatonImg;
    //3
    ImageView valueAnimatorImg;
    TextView valueAnimatorText;
    //4
    ImageView valueAnimatorImgFromXml;
    TextView valueAnimatorTextFromXml;
    //4
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        bindAction();
    }

    private void bindAction() {

        //1
        img.setImageResource(R.drawable.animation_list);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationDrawable aniDrawable = (AnimationDrawable) img.getDrawable();
                aniDrawable.start();
            }
        });

        //2
        viewAnimation vanimation = new viewAnimation();
        vanimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                viewAnimatonText.setText("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewAnimatonText.setText("onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                viewAnimatonText.setText("onAnimationRepeat");
            }
        });
        viewAnimatonImg.startAnimation(vanimation);

        //3
        ValueAnimator anim = ValueAnimator.ofFloat(0,1.0f);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                valueAnimatorText.setText(String.valueOf(value));
                valueAnimatorImg.setScaleX(value);
                valueAnimatorImg.setScaleY(value);
                valueAnimatorImg.setPivotX(200);
                valueAnimatorImg.setPivotY(0.2f);
            }
        });
        anim.setDuration(10000);
        anim.start();
        //4
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.default_value);
        valueAnimatorImgFromXml.setPivotX(400);
        animator.setTarget(valueAnimatorImgFromXml);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                valueAnimatorTextFromXml.setText(String.valueOf(valueAnimator.getAnimatedValue()) );
            }
        });
        animator.start();

    }

    private void initView() {
        //1
        img = (ImageView) findViewById(R.id.animationList);
        btn = (Button) findViewById(R.id.animationListActionButton);

        //2
        viewAnimatonImg = (ImageView) findViewById(R.id.viewAnimatonImg);
        viewAnimatonText = (TextView) findViewById(R.id.viewAnimatonText);

        //3
        valueAnimatorImg = (ImageView) findViewById(R.id.valueAnimatorImg);
        valueAnimatorText = (TextView) findViewById(R.id.valueAnimatorText);
        //4
        valueAnimatorImgFromXml = (ImageView) findViewById(R.id.valueAnimatorImgFromXml);
        valueAnimatorTextFromXml = (TextView) findViewById(R.id.valueAnimatorTextFromXml);
    }
}

class viewAnimation extends Animation{
    int centerX;
    int centerY;
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        centerX = width/2;
        centerY = height/2;
        setDuration(5000);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        final Matrix matrix = t.getMatrix();
        matrix.setScale(interpolatedTime,interpolatedTime);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
    }
}
