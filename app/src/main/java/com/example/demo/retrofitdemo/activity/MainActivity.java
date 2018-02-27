package com.example.demo.retrofitdemo.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demo.retrofitdemo.App;
import com.example.demo.retrofitdemo.R;
import com.example.demo.retrofitdemo.databinding.ActivityMainBinding;
import com.example.demo.retrofitdemo.fragment.MoviesFragment;

public class MainActivity extends BaseActivityBinding<ActivityMainBinding> {

    @Override
    protected int defineLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeComponents() {
        App.updateRetrofitInstance(true);

        getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        replaceFragment(R.id.activity_main_flMain, getFragmentManager(), new MoviesFragment(), false, false);
    }
}