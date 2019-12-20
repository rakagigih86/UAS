package com.uas.uas.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uas.uas.R;
import com.uas.uas.fragments.aboutusFragment;
import com.uas.uas.fragments.bestFragment;
import com.uas.uas.fragments.socialmediaFragment;
import com.uas.uas.fragments.tshirtFragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment (new bestFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = new bestFragment();
                break;
            case R.id.pizza:
                fragment = new tshirtFragment();
                break;


            case R.id.loc:
                fragment = new aboutusFragment();
                break;

        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void handleExplicitIntent(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void link1(View view) {
        String url = "https://catharsisempire.com/";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
