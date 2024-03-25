package com.example.dewi_kajii;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentManager;
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.myDrawerLayout);
        navigationView = findViewById(R.id.nvView);
        toolbar = findViewById(R.id.toolbar); // Initialize the toolbar

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kebekerjaan");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupDrawerContent(navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.atraksi) {
            startActivity(new Intent(MainActivity.this, Atraksi.class));
        } else if (menuItem.getItemId() == R.id.paket_wisata) {
            startActivity(new Intent(MainActivity.this, PaketWisata.class));
        } else if (menuItem.getItemId() == R.id.katalog_ikan) {
            startActivity(new Intent(MainActivity.this, KatalogIkan.class));
        }else if (menuItem.getItemId() == R.id.homestay) {
            startActivity(new Intent(MainActivity.this, Homestay.class));
        }
    }

}
