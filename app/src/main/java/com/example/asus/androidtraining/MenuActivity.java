package com.example.asus.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 0, "first");
        menu.add(1, 2, 0, "second");
        menu.add(1, 3, 0, "third");
        menu.add(1, 4, 0, "forth");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:makeToast("1");break;
            case 2:makeToast("2");break;
            case 3:makeToast("3");break;
            case 4:makeToast("4");break;

        }
        return super.onOptionsItemSelected(item);
    }
    public void makeToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
