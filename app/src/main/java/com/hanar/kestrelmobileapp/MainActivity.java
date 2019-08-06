package com.hanar.kestrelmobileapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MotionEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

@SuppressLint("ClickableViewAccessibility")

public class MainActivity extends AppCompatActivity {
    private boolean isFront;
    private Button frontBackButton;
    private TransitionDrawable td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        frontBackButton = findViewById(R.id.frontBackButton);
        ImageView kestrelImage = findViewById(R.id.kestrel);

        td = new TransitionDrawable(new Drawable[]{
                getResources().getDrawable(R.drawable.kestrelfront),
                getResources().getDrawable(R.drawable.kestrelback)
        });
        kestrelImage.setImageDrawable(td);

        isFront = true;
        frontBackButton.setText(R.string.front_button);

        frontBackButton.setOnClickListener((v) -> changeFrontBackImage());
    }

    private void changeFrontBackImage() {
        if (isFront) {
            td.startTransition(500);
            frontBackButton.setText(R.string.back_Button);
        } else {
            td.reverseTransition(500);
            frontBackButton.setText(R.string.front_button);
        }
        isFront = !isFront;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
