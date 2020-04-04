package com.jam.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton(View view){
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void onAbout(View view){
        Toast.makeText(this,"仅供娱乐",Toast.LENGTH_LONG).show();
    }
}
