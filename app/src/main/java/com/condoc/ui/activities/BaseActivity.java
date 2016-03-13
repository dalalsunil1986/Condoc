package com.condoc.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.condoc.CondocApp;
import com.condoc.core.PreferencesManager;

import javax.inject.Inject;

/**
 * Created by Jo on 3/13/2016.
 * Has all the necessary functionality that should be available to each activity
 */
public class BaseActivity extends AppCompatActivity {
    @Inject
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //provides the necessary dependencies for this activity.
        CondocApp.get(this).getComponent().inject(this);

        /*
        Logs the user out if they aren't logged in.
         */
        if(!preferencesManager.isLoggedIn())
        {
            Intent intent=new Intent(this,LoginRegisterActivity.class);
            startActivity(intent);
        }


    }
}
