package com.example.depremapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNav = findViewById(R.id.bottom_nav);

        if(savedInstanceState == null){

            fragmentManager = getSupportFragmentManager();
            sesFragment sesFragment = new sesFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,sesFragment)
                    .commit();
        }

        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){

                    case R.id.deprem:
                        fragment = new depremFragment();
                        break;
                    case R.id.ara:
                        fragment = new araFragment();
                        break;
                    case R.id.ses:
                        fragment = new sesFragment();
                        break;
                    case R.id.fener:
                        fragment = new fenerFragment();
                        break;

                }
                if(fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();


                }else{
                    Log.e(TAG,"Katman yaratma hatası");
                }
            }
        });
    }

}