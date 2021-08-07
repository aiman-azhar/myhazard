package com.hamizan.newsandmaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity {
    //initialize variable
    DrawerLayout drawerLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        //assign map

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void ClickMenu(View view){
        //open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo (View view){
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickNews (View view){
        //redirect activity to news
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickMap(View view){
        //recreate activity
        recreate();
    }


    public void ClickExit(View view){
        //close app
        MainActivity.exit(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}