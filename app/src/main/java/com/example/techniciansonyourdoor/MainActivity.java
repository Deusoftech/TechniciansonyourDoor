package com.example.techniciansonyourdoor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.techniciansonyourdoor.AboutFragment;
import com.example.techniciansonyourdoor.HelpFragment;
import com.example.techniciansonyourdoor.HomeFragment;
import com.example.techniciansonyourdoor.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Technicians");
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment =null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment =new HomeFragment();

                    break;
                case R.id.nav_help:
                    selectedFragment =new HelpFragment();
                    break;
                case R.id.nav_about:
                    selectedFragment =new AboutFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

