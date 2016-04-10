package com.gdgk.sample.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class User extends BaseObservable{
    public final static boolean MALE = true;
    public final static boolean FEMALE = false;
    public String avatarUrl, id, name;
    public boolean gender;
    public int level, exp;

    public User(String avatarUrl, String id, String name, boolean gender, int level, int exp) {
        this.avatarUrl = avatarUrl;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.exp = exp;
    }

    public String getAvatar() {
        return avatarUrl;
    }

    public void setAvatar(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Bindable
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
//        notifyPropertyChanged(BR.exp);
    }
}
