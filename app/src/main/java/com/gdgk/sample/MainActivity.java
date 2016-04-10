package com.gdgk.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdgk.sample.model.User;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    TextView mIdTxtView, mNameTxtView, mLevelTxtView, mExpTxtView;
    ImageView mMaleImg, mFemaleImg, mAvatarImg;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_exercise);

        findViews();
        mUser = new User("http://i.imgur.com/Hpa45dF.jpg","0001","騎豬撞學校", User.MALE, 5, 1500);
        setUserData();

    }

    private void findViews(){
        mIdTxtView = (TextView) findViewById(R.id.view_id);
        mNameTxtView = (TextView) findViewById(R.id.view_name);
        mLevelTxtView = (TextView) findViewById(R.id.view_level);
        mExpTxtView = (TextView)findViewById(R.id.view_exp);
        mMaleImg = (ImageView)findViewById(R.id.img_male);
        mFemaleImg = (ImageView)findViewById(R.id.img_female);
        mAvatarImg = (ImageView)findViewById(R.id.img_avatar);
    }

    private void setUserData(){
        mIdTxtView.setText(mUser.getId());
        mNameTxtView.setText(mUser.getName());
        mLevelTxtView.setText("Lv." + mUser.getLevel());
        mExpTxtView.setText(""+mUser.getExp());

        if(mUser.isGender()==User.MALE){
            mFemaleImg.setVisibility(View.GONE);
            mMaleImg.setVisibility(View.VISIBLE);
        }else{
            mMaleImg.setVisibility(View.GONE);
            mFemaleImg.setVisibility(View.VISIBLE);
        }

        loadImgUrl(mAvatarImg, mUser.getAvatar());
    }

    private void loadImgUrl(ImageView view, String path){
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
        setUserData();
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
