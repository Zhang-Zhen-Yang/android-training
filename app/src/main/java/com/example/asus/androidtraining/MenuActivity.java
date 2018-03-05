package com.example.asus.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private TextView contextText;
    private Button popup_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findView();
    }

    private void findView() {
        contextText = (TextView) findViewById(R.id.contextText );
        registerForContextMenu(contextText);

        popup_menu = (Button) findViewById(R.id.popup_menu);
        popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, popup_menu);
                popupMenu.getMenuInflater().inflate(R.menu.content_nemu, popupMenu.getMenu());
                popupMenu.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.content_nemu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      /*  menu.add(1, 1, 0, "first");
        menu.add(1, 2, 0, "second");
        menu.add(1, 3, 0, "third");
        menu.add(1, 4, 0, "forth");
        return super.onCreateOptionsMenu(menu);*/
     getMenuInflater().inflate(R.menu.content_nemu, menu); return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:makeToast("1");break;
            case 2:makeToast("2");break;
            case 3:makeToast("3");break;
            case 4:makeToast("4");break;
            case R.id.first:makeToast("first");break;
            case R.id.second:makeToast("second");break;

        }
        return super.onOptionsItemSelected(item);
    }
    public void makeToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
