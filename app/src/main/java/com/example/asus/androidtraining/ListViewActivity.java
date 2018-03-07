package com.example.asus.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        findView();
        bindView();
    }

    private void bindView() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[] {"apple", "banana"});
        ArrayList alist = new ArrayList();
        titles = new String[]{
                "油大条先生",
                "AUZ低音走调帝",
                "3F团音乐社",
                "依依子_",
                "MU秋日",
                "AUZ低音走调帝",
        };
        String[] texts = new String[] {
                "【油大条解说】酒吞童子无解醉拳连招！搭配如此出装，堪称无解",
                "【高音翻唱】九儿(谭晶版) / 唢呐伴奏.ver【AUZ】",
                "【3F/古风原创】千秋岁【宫本清和】我在没有你的江南等你。【人声先行版】",
                "【MMD偶像梦幻祭】SCREAM【凛月・司・泉】",
                "【MU秋日】超绝硬核游戏！忍龙∑2最高难度攻略解说流程【P1】",
                "【AUZ ft.绮罗星·原创】花园中的灰姑娘（人声本家/PV附）"
        };
        for(int i = 0; i < titles.length ;i ++){
            Map map1 = new HashMap();
            try{
                map1.put("img", R.drawable.class.getField("img"+i).get(null));
                map1.put("title", titles[i]);
                map1.put("text", texts[i]);
                alist.add(map1);
            }catch(Exception e){
                e.printStackTrace();
            }

        };
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,alist,R.layout.my_listview_layout, new String[]{"img", "title", "text"},new int[]{R.id.img, R.id.title, R.id.text});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, titles[i].toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findView() {
        listView = (ListView) findViewById(R.id.listView);
    }
}
