package com.example.asus.androidtraining;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    RadioGroup fruit_wrap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        fruit_wrap = (RadioGroup) findViewById(R.id.fruit_wrap);
        this.bindView();
    }

    private void bindView() {
        fruit_wrap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radio_apple:
                        Toast.makeText(ViewActivity.this, "APPLE",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_banana:
                        Toast.makeText(ViewActivity.this, "BANANA",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
