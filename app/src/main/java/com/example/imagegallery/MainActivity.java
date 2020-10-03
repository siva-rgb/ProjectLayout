package com.example.imagegallery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageButton btn;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        btn=findViewById(R.id.fabVideo);
        fab=findViewById(R.id.imgBtn);

        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setViewPager(ViewPager viewPager)
    {
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(),2);
        viewPageAdapter.addFragment(new ImageFragment(),"Image");
        viewPageAdapter.addFragment(new VideoFragment(),"Video");
        viewPager.setAdapter(viewPageAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.profileId:
                Intent intent =new Intent(MainActivity.this,AdminProfileActivity.class);
                startActivity(intent);

                return true;

            case R.id.logout:

        }
        return false;
    }
}