package com.boda.renuka.guessnamegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.lang.reflect.Type;

import static java.security.AccessController.getContext;

/**
 * Created by renuka on 25/8/18.
 */

public class HomeActivty extends AppCompatActivity {
    private TextView txtTitle,txtVersion,txtGo;

    private Typeface typeface;

    private Animation blinkAnimation;

    private SharedPreferences sharedPreferences;

    private static String HOW_TOPLAYFLAG_SHOWN = "";

    public static final String PREFS_GAME ="com.boda.renuka.guessnamegame.how.to.play";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        Drawable img = getResources().getDrawable( R.drawable.arrow );
        img.setBounds( 0, 0, 60, 60 );
        txtGo.setCompoundDrawables( null, null, img, null );
        setTypefacetotextviews();
        setAnimationToGo();
        setOnclickListner();
    }

    private void setOnclickListner() {
        txtGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent;

                if (sharedPreferences.getString(HOW_TOPLAYFLAG_SHOWN,"").equals("")) {
                    sharedPreferences.edit().putString(HOW_TOPLAYFLAG_SHOWN, "true").commit();
                    intent = new Intent(HomeActivty.this,HowToPlayActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);

                }
                else {
                    intent = new Intent(HomeActivty.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);

                }

            }
        });
    }

    private void setAnimationToGo() {
        txtGo.clearAnimation();
        txtGo.startAnimation(blinkAnimation);
    }

    private void setTypefacetotextviews() {
        txtTitle.setTypeface(typeface);

        txtVersion.setTypeface(typeface);

        txtGo.setTypeface(typeface);
    }

    private void init() {
        typeface = Typeface.createFromAsset(getAssets(), "fonts/fadetogr.ttf");

        txtTitle = (TextView) findViewById(R.id.txtTitle);

        txtVersion = (TextView) findViewById(R.id.txtVersion);

        txtGo = (TextView) findViewById(R.id.txtGo);

        sharedPreferences = getSharedPreferences(PREFS_GAME,MODE_PRIVATE);

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blinking_animation);
    }
}
