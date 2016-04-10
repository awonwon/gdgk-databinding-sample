package com.gdgk.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.gdgk.sample.model.StoreItem;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {
    RecyclerView mRcyList;
    List<StoreItem> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_exercise);

        findViews();
        setStoreData();
        setRcyListAdapter();

    }

    private void findViews(){
        mRcyList = (RecyclerView) findViewById(R.id.rcy_list);
    }

    private void setStoreData(){
        mItems = new ArrayList<StoreItem>();
        mItems.add(new StoreItem("紅色藥水",10));
        mItems.add(new StoreItem("黃色藥水",20));
        mItems.add(new StoreItem("藍色藥水",30));
        mItems.add(new StoreItem("白色藥水",50));
        mItems.add(new StoreItem("綠色藥水",20));
    }

    private void setRcyListAdapter(){
        StoreListAdapter adapter = new StoreListAdapter(this, mItems);
        mRcyList.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
