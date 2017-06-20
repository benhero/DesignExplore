package com.benhero.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.benhero.design.module.activity.ModuleActivity;
import com.benhero.design.mvp.view.MvpActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主界面
 *
 * @author benhero
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.main_list);
        ListAdapter mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, ListContent.ITEMS);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position) {
            case 0:
                startMvp(MvpActivity.ENTER_A);
                break;
            case 1:
                startMvp(MvpActivity.ENTER_B);
                break;
            case 2:
                startMvp(MvpActivity.ENTER_C);
                break;
            case 3:
                startMvp(MvpActivity.ENTER_D);
                break;
            case 4:
                startActivity(new Intent(this, ModuleActivity.class));
                break;
            default:
                break;
        }
    }

    private void startMvp(int enter) {
        Intent intent = new Intent(MainActivity.this, MvpActivity.class);
        intent.putExtra(MvpActivity.EXTRA_ENTER, enter);
        startActivity(intent);
    }

    /**
     * ListContent
     */
    private static class ListContent {

        static List<ListItem> ITEMS = new ArrayList<>();

        static Map<String, ListItem> ITEM_MAP = new HashMap<>();

        static {
            addItem(new ListItem("1", "MVP A"));
            addItem(new ListItem("2", "MVP B"));
            addItem(new ListItem("3", "MVP C"));
            addItem(new ListItem("4", "MVP D"));
            addItem(new ListItem("5", "Module"));
        }

        private static void addItem(ListItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        /**
         * ListItem
         */
        static class ListItem {
            public String id;
            String content;

            ListItem(String id, String content) {
                this.id = id;
                this.content = content;
            }

            @Override
            public String toString() {
                return content;
            }
        }
    }

}
