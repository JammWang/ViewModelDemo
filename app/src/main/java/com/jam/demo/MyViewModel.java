package com.jam.demo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {

    private SavedStateHandle handle;
    private String key_exhaust = getApplication().getResources().getString(R.string.exhaust_level);
    private String key_social = getApplication().getResources().getString(R.string.social_level);
    private String shared_name = getApplication().getResources().getString(R.string.shared_name);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if(!(handle.contains(key_exhaust) && handle.contains(key_social))){
            loadData();
        }
    }

    public LiveData<Integer> getExhaustLevel() {
        return handle.getLiveData(key_exhaust);
    }

    public LiveData<Integer> getSocialLevel() {
        return handle.getLiveData(key_social);
    }

    public void saveData(){
        SharedPreferences shp = getApplication().getSharedPreferences(shared_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key_exhaust, getExhaustLevel().getValue());
        editor.putInt(key_social, getSocialLevel().getValue());
        editor.apply();
    }

    public void loadData(){
        SharedPreferences shp = getApplication().getSharedPreferences(shared_name, Context.MODE_PRIVATE);
        int exhaust_level = shp.getInt(key_exhaust, 5);
        int social_level = shp.getInt(key_social, 5);
        handle.set(key_exhaust, exhaust_level);
        handle.set(key_social, social_level);
    }
}
