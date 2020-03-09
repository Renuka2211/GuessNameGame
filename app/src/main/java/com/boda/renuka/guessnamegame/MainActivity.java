package com.boda.renuka.guessnamegame;

import android.animation.Animator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.GestureDetector.OnGestureListener;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Animation blinkAnimation, slideDownAnimation;
    private TextView tvCol_1,tvCol_2,tvCol_3,tvCol_4,tvCol_5,tvCol_6;
    ArrayList<String> colList1,colList2,colList3,colList4,colList5,colList6;
    ArrayList<Integer> sequenceList;
    FloatingActionButton fabtnOk;
    ImageView ivSwipdown;
    private static String APP_INSTALLED_FLAG = "";
    private SharedPreferences sharedPreferences;
    public static final String PREFS_GAME ="com.boda.renuka.guessnamegame";
    private RelativeLayout llGuideScreenLayout;
    private TextView txtxGotIt,txtGuideText,txtSkip;
    Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListeners();
        setToolbar();
        setTypeFaceToTextviews();
        if (sharedPreferences.getString(APP_INSTALLED_FLAG,"").equals("")) {
            sharedPreferences.edit().putString(APP_INSTALLED_FLAG, "true").commit();
            llGuideScreenLayout.setVisibility(View.VISIBLE);
            ivSwipdown.clearAnimation();
            ivSwipdown.startAnimation(slideDownAnimation);
            txtGuideText.setText("Swipe down the column which contains first letter of the name");
            txtxGotIt.setText("Next");

        }
        else {
            llGuideScreenLayout.setVisibility(View.GONE);
        }
    }

    private void setTypeFaceToTextviews() {
        typeface = Typeface.createFromAsset(getAssets(), "fonts/guide_text.ttf");

        txtxGotIt.setTypeface(typeface);
        txtGuideText.setTypeface(typeface);
        txtSkip.setTypeface(typeface);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/column_font.ttf");
        tvCol_1.setTypeface(typeface);
        tvCol_2.setTypeface(typeface);
        tvCol_3.setTypeface(typeface);
        tvCol_4.setTypeface(typeface);
        tvCol_5.setTypeface(typeface);
        tvCol_6.setTypeface(typeface);


    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        TextView title= (TextView) findViewById(R.id.title);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/fadetogr.ttf");

        title.setTypeface(typeface);
        ImageView ivHelp= (ImageView) findViewById(R.id.ivHelp);
        //title.setTypeface(typeface);
        title.setText("Guess Name");
        ivHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llGuideScreenLayout.setVisibility(View.VISIBLE);
                ivSwipdown.clearAnimation();
                ivSwipdown.startAnimation(slideDownAnimation);
                txtGuideText.setText("Swipe down the column which contains first letter of the name");
                txtxGotIt.setText("Next");

            }
        });
    }

    private void setListeners() {
        tvCol_1.setOnClickListener(this);

        tvCol_2.setOnClickListener(this);

        tvCol_3.setOnClickListener(this);

        tvCol_4.setOnClickListener(this);

        tvCol_5.setOnClickListener(this);

        tvCol_6.setOnClickListener(this);

        fabtnOk.setOnClickListener(this);

        txtxGotIt.setOnClickListener(this);

        txtSkip.setOnClickListener(this);
    }


    private void init() {
        tvCol_1 = (TextView) findViewById(R.id.tvClmn1);

        tvCol_2 = (TextView) findViewById(R.id.tvClmn2);

        tvCol_3 = (TextView) findViewById(R.id.tvClmn3);

        tvCol_4 = (TextView) findViewById(R.id.tvClmn4);

        tvCol_5 = (TextView) findViewById(R.id.tvClmn5);

        tvCol_6 = (TextView) findViewById(R.id.tvClmn6);

        fabtnOk = (FloatingActionButton) findViewById(R.id.fbtnOk);

        slideDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blinking_animation);

        sharedPreferences = getSharedPreferences(PREFS_GAME,MODE_PRIVATE);

        llGuideScreenLayout = (RelativeLayout) findViewById(R.id.llguide_screen);

        ivSwipdown = (ImageView) findViewById(R.id.ivSwipdown);

        txtxGotIt = (TextView) findViewById(R.id.txtGotIt);

        txtGuideText = (TextView) findViewById(R.id.txtGuideText);

        txtSkip = (TextView) findViewById(R.id.txtSkip);

        txtSkip.clearAnimation();

        txtSkip.startAnimation(blinkAnimation);

        colList1 = new ArrayList<>();

        colList2 = new ArrayList<>();

        colList3 = new ArrayList<>();

        colList4 = new ArrayList<>();

        colList5 = new ArrayList<>();

        colList6 = new ArrayList<>();

        sequenceList = new ArrayList<>();

        colList1.add("A");
        colList1.add("G");
        colList1.add("M");
        colList1.add("S");
        colList1.add("Y");

        colList2.add("B");
        colList2.add("H");
        colList2.add("N");
        colList2.add("T");
        colList2.add("Z");

        colList3.add("C");
        colList3.add("I");
        colList3.add("O");
        colList3.add("U");

        colList4.add("D");
        colList4.add("J");
        colList4.add("P");
        colList4.add("V");

        colList5.add("E");
        colList5.add("K");
        colList5.add("Q");
        colList5.add("W");

        colList6.add("F");
        colList6.add("L");
        colList6.add("R");
        colList6.add("X");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tvClmn1:
                Log.d("Onclick called","Test");
                tvCol_1.clearAnimation();
                tvCol_1.startAnimation(slideDownAnimation);
                sequenceList.add(1);

                break;

            case R.id.tvClmn2:
                tvCol_2.clearAnimation();
                tvCol_2.startAnimation(slideDownAnimation);
                sequenceList.add(2);

                break;

            case R.id.tvClmn3:
                tvCol_3.clearAnimation();
                tvCol_3.startAnimation(slideDownAnimation);
                sequenceList.add(3);

                break;

            case R.id.tvClmn4:
                tvCol_4.clearAnimation();
                tvCol_4.startAnimation(slideDownAnimation);
                sequenceList.add(4);

                break;
            case R.id.tvClmn5:
                tvCol_5.clearAnimation();
                tvCol_5.startAnimation(slideDownAnimation);
                sequenceList.add(5);

                break;
            case R.id.tvClmn6:
                tvCol_6.clearAnimation();
                tvCol_6.startAnimation(slideDownAnimation);
                sequenceList.add(6);

                break;
            case R.id.fbtnOk:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putIntegerArrayListExtra("sequence",sequenceList);
                Log.d("sequenceList:: "+sequenceList,sequenceList.toString());
                finish();
                startActivity(intent);


                break;
            case R.id.txtGotIt:
                if(txtxGotIt.getText().toString().equalsIgnoreCase("Next") && txtGuideText.getText().toString().equalsIgnoreCase("Swipe down the column which contains first letter of the name"))
                {
                    txtGuideText.setText("Swipe down the column which contains second letter of name");
                }
                else if(txtxGotIt.getText().toString().equalsIgnoreCase("Next") && txtGuideText.getText().toString().equalsIgnoreCase("Swipe down the column which contains second letter of name"))
                {
                    txtGuideText.setText("Swipe down the column which contains third letter and continue the same process until last letter of name");
                    txtxGotIt.setText("Got It...");
                }
                else if(txtxGotIt.getText().toString().equals("Got It...") && txtGuideText.getText().toString().equalsIgnoreCase("Swipe down the column which contains third letter and continue the same process until last letter of name"))
                {
                    llGuideScreenLayout.setVisibility(View.GONE);
                }

            break;

            case R.id.txtSkip:

                llGuideScreenLayout.setVisibility(View.GONE);

                break;
            default:
                break;



        }
    }
}
