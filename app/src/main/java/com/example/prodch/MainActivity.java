package com.example.prodch;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.example.prodch.databinding.ActivityMainBinding;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.view.MenuItem;

import java.util.Objects;


public class MainActivity extends AppCompatActivity  {

private ActivityMainBinding binding;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public ItemTouchHelper itemtouch;
    private MenuItem item;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("myTag","Start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();










        //menu.addListener();

        // to make the Navigation drawer icon always appear on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


     /*binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());*/
    }

    /**
     * A native method that is implemented by the 'prodch' native library,
     * which is packaged with this application.
     */



    @Override
    public boolean onOptionsItemSelected(final @NonNull MenuItem item) {
        //list selection

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            Log.i("myTag","Drawer");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public native String stringFromJNI();

    // Used to load the 'prodch' library on application startup.
    static {
        System.loadLibrary("prodch");
    }


}