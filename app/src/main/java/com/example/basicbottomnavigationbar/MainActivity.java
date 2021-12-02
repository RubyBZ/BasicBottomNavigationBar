package com.example.basicbottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.basicbottomnavigationbar.fragments.HomeFragment;
import com.example.basicbottomnavigationbar.fragments.PersonFragment;
import com.example.basicbottomnavigationbar.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    PersonFragment personFragment;
    HomeFragment homeFragment;
    SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.person);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.person:
                personFragment = new PersonFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerFragment, personFragment)
                        .commit();
                return true;

            case R.id.home:
                homeFragment = new HomeFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerFragment, homeFragment)
                        .commit();
                return true;

            case R.id.settings:
                settingsFragment = new SettingsFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerFragment, settingsFragment)
                        .commit();
                return true;
        }
        return false;
    }
}