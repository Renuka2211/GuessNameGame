package com.boda.renuka.guessnamegame;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by renuka on 27/8/18.
 */

public class HowToPlayActivity extends AppCompatActivity {
    private TextView txtStep1,txtStep2,txtStep3,txtStep4,txtStart;

    private Typeface typeface;

    private Animation blinkAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        init();
        setTypeFaceForTextViews();

        txtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HowToPlayActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });

    }

    private void setTypeFaceForTextViews() {
        txtStep1.setTypeface(typeface);

        txtStep2.setTypeface(typeface);

        txtStep3.setTypeface(typeface);

        txtStep4.setTypeface(typeface);

        typeface = Typeface.createFromAsset(getAssets(), "fonts/fadetogr.ttf");


        txtStart.setTypeface(typeface);

    }

    private void init() {
        txtStep1 = (TextView) findViewById(R.id.txtStep1);

        txtStep2 = (TextView) findViewById(R.id.txtStep2);

        txtStep3 = (TextView) findViewById(R.id.txtStep3);

        txtStep4 = (TextView) findViewById(R.id.txtStep4);

        txtStart = (TextView) findViewById(R.id.txtStart);

        typeface = Typeface.createFromAsset(getAssets(), "fonts/column_font.ttf");

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blinking_animation);

        txtStart.clearAnimation();
        txtStart.startAnimation(blinkAnimation);

    }
}
