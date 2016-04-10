package com.gdgk.sample;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.gdgk.sample.databinding.MainActivityDataBinding;
import com.gdgk.sample.model.User;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    User mUser;
    MainActivityDataBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_first_exercise);

        mUser = new User("http://i.imgur.com/Hpa45dF.jpg","0001","騎豬撞學校", User.MALE, 5, 1500);

        mBinding.setUser(mUser);
    }

    @BindingAdapter(value = {"app:imageUrl"}, requireAll = true)
    public static void loadImgUrl(ImageView view, String path){
        Picasso.with(view.getContext())
                .load(path)
                .fit()
                .centerCrop()
                .into(view);
    }

    public void onAddExpClick(View view){
        int exp = mUser.getExp();
        exp += 10;
        mUser.setExp(exp);
    }

    public void onIntoStoreClick(View view){
        startActivity(new Intent(this, StoreActivity.class));
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
