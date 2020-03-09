package com.boda.renuka.guessnamegame;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by renuka on 17/8/18.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> colList1,colList2,colList3,colList4,colList5,colList6;

    private ArrayList<Integer> sequenceList;

    private ArrayList<String> colList_second1,colList_second2,colList_second3,colList_second4,colList_second5;

    private TextView tvCol_1,tvCol_2,tvCol_3,tvCol_4,tvCol_5;

    private Animation slideUpAnimation, slideDownAnimation;

    private HashMap<Integer,ArrayList<String>> clickMap;

    private int clickNum = 0;

    private String name = "";

    private Button btnBack,btnOk,btnCancel;

    private RelativeLayout llGuideScreenLayout;

    private TextView txtxGotIt,txtGuideText,txtSkip,txtNameTitle,txtName;

    private ImageView ivSwipdown;

    private Typeface typeface;

    private Animation blinkAnimation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        populateData();
        setOnclickListerner();
        dataWrapping();
        setToolbar();
        setTypeFaceToTextviews();



    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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
                txtGuideText.setText("Swipe down the column which contains first letter of name");
                txtxGotIt.setText("Next");

            }
        });
    }

    private void dataWrapping() {
        if(!distinctValues(sequenceList))
        {
            int currentCol = sequenceList.get(0);


            switch (currentCol)
            {
                case 1:
                  /*  colList_second1.add("A");
                    colList_second2.add("G");
                    colList_second3.add("M");
                    colList_second4.add("S");
                    colList_second5.add("Y");*/


                    tvCol_1.setText(colList_second1.get(0));
                    tvCol_2.setText(colList_second2.get(0));
                    tvCol_3.setText(colList_second3.get(0));
                    tvCol_4.setText(colList_second4.get(0));
                    tvCol_5.setText(colList_second5.get(0));





                    tvCol_1.setText(tvCol_1.getText()+"\n\n\nB\n\n\nH\n\n\nN\n\n\nT\n\n\nZ");
                    tvCol_3.setText("C\n\n\nI\n\n\nO\n\n\nU\n\n\n"+tvCol_3.getText());
                    tvCol_4.setText("E\n\n\nK\n\n\nQ\n\n\n"+tvCol_4.getText()+"\n\n\nW\n\n\n");
                    tvCol_5.setText("F\n\n\nL\n\n\n"+tvCol_5.getText()+"\n\n\nX\n\n\n");
                    tvCol_2.setText("F\n\n\nL\n\n\n"+tvCol_2.getText()+"\n\n\nX\n\n\n");

                    break;
                case 2:
                   /* colList_second1.add("B");
                    colList_second2.add("H");
                    colList_second3.add("N");
                    colList_second4.add("T");
                    colList_second5.add("Z");*/
                    tvCol_1.setText(colList_second1.get(0));
                    tvCol_2.setText(colList_second2.get(0));
                    tvCol_3.setText(colList_second3.get(0));
                    tvCol_4.setText(colList_second4.get(0));
                    tvCol_5.setText(colList_second5.get(0));


                    tvCol_1.setText("A\n\n\nG\n\n\nM\n\n\n"+tvCol_1.getText()+"\n\n\nS\n\n\nY");
                    tvCol_3.setText("C\n\n\nI\n\n\n"+tvCol_3.getText()+"\n\n\nO\n\n\nU\n\n\n");
                    tvCol_4.setText("E\n\n\n"+tvCol_4.getText()+"\n\n\nK\n\n\nQ\n\n\nW\n\n\n");
                    tvCol_2.setText("F\n\n\n"+tvCol_2.getText()+"\n\n\nL\n\n\nR\n\n\nX\n\n\n");
                    tvCol_5.setText("E\n\n\n"+tvCol_5.getText()+"\n\n\nK\n\n\nQ\n\n\nW\n\n\n");


                    break;
                case 3:
                    /*colList_second1.add("C");
                    colList_second2.add("I");
                    colList_second3.add("O");
                    colList_second4.add("U");
                    colList_second5.add("");*/

                    tvCol_1.setText(colList_second1.get(0));
                    tvCol_2.setText(colList_second2.get(0));
                    tvCol_3.setText(colList_second3.get(0));
                    tvCol_4.setText(colList_second4.get(0));
                    tvCol_5.setText(colList_second5.get(0));


                    tvCol_1.setText("A\n\n\nG\n\n\nM\n\n\n"+tvCol_1.getText()+"\n\n\nS\n\n\nY");
                    tvCol_3.setText("B\n\n\nH\n\n\nN\n\n\nT\n\n\nZ\n\n\n"+tvCol_3.getText());
                    tvCol_4.setText("A\n\n\nG\n\n\nM\n\n\n"+tvCol_4.getText()+"\n\n\nS\n\n\nY");

                    tvCol_5.setText("E\n\n\nK\n\n\nQ\n\n\n"+tvCol_5.getText()+"\n\n\nW\n\n\n");
                    tvCol_2.setText("F\n\n\nL\n\n\n"+tvCol_2.getText()+"\n\n\nR\n\n\nX\n\n\n");
                    break;
                case 4:
                   /* colList_second1.add("D");
                    colList_second2.add("J");
                    colList_second3.add("P");
                    colList_second4.add("V");
                    colList_second5.add("");*/

                    tvCol_1.setText(colList_second1.get(0));
                    tvCol_2.setText(colList_second2.get(0));
                    tvCol_3.setText(colList_second3.get(0));
                    tvCol_4.setText(colList_second4.get(0));
                    tvCol_5.setText(colList_second5.get(0));

                    tvCol_1.setText(tvCol_1.getText()+"\n\n\nA\n\n\nG\n\n\nM\n\n\nS\n\n\nY");
                    tvCol_3.setText("B\n\n\nH\n\n\n"+tvCol_3.getText()+"\n\n\nN\n\n\nT\n\n\nZ");
                    tvCol_5.setText("F\n\n\nL\n\n\nR\n\n\nX\n\n\n"+tvCol_5.getText()+"\n\n\n");
                    tvCol_4.setText("E\n\n\nK\n\n\nQ\n\n\nW\n\n\n"+tvCol_4.getText()+"\n\n\n");
                    tvCol_2.setText("F\n\n\nL\n\n\nR\n\n\nX\n\n\n"+tvCol_2.getText());

                    break;
                case 5:
                    /*colList_second1.add("E");
                    colList_second2.add("K");
                    colList_second3.add("Q");
                    colList_second4.add("W");
                    colList_second5.add("");*/

                    tvCol_1.setText(colList_second1.get(0));
                    tvCol_2.setText(colList_second2.get(0));
                    tvCol_3.setText(colList_second3.get(0));
                    tvCol_4.setText(colList_second4.get(0));
                    tvCol_5.setText(colList_second5.get(0));

                    tvCol_1.setText("A\n\n\nG\n\n\nM\n\n\n"+tvCol_1.getText()+"\n\n\nS\n\n\nY");
                    tvCol_3.setText("B\n\n\nH\n\n\nN\n\n\nT\n\n\n"+tvCol_3.getText()+"\n\n\nZ");
                    tvCol_5.setText("D\n\n\nJ\n\n\n"+tvCol_5.getText()+"\n\n\nP\n\n\nV\n\n\n");
                    tvCol_2.setText("F\n\n\nL\n\n\nR\n\n\nX\n\n\n"+tvCol_2.getText()+"\n\n\n");
                    tvCol_4.setText("A\n\n\nG\n\n\nM\n\n\n"+tvCol_4.getText()+"\n\n\nS\n\n\nY");
                    break;
                case 6:
                    /*colList_second1.add("F");
                    colList_second2.add("L");
                    colList_second3.add("R");
                    colList_second4.add("X");
                    colList_second5.add("");*/

                    tvCol_1.setText(colList_second1.get(0));
                    tvCol_2.setText(colList_second2.get(0));
                    tvCol_3.setText(colList_second3.get(0));
                    tvCol_4.setText(colList_second4.get(0));
                    tvCol_5.setText(colList_second5.get(0));

                    tvCol_1.setText("A\n\n\nG\n\n\nM\n\n\nS\n\n\nY"+tvCol_1.getText());
                    tvCol_3.setText(tvCol_3.getText()+"\n\n\nB\n\n\nH\n\n\nN\n\n\nT\n\n\nZ");
                    tvCol_5.setText("D\n\n\nJ\n\n\nP\n\n\nV\n\n\n"+tvCol_5.getText());
                    tvCol_2.setText(tvCol_2.getText()+"\n\n\nE\n\n\nK\n\n\nQ\n\n\nW\n\n\n");
                    tvCol_4.setText(tvCol_4.getText()+"\n\n\nE\n\n\nK\n\n\nQ\n\n\nW\n\n\n");
                    break;
            }
        }
        else {
            if(!sequenceList.contains(1))
            {
                wrapDataHiddenValues(1);
            }
            else if(!sequenceList.contains(2)){
                wrapDataHiddenValues(2);
            }
            else if(!sequenceList.contains(3)){
                wrapDataHiddenValues(3);
            }
            else if(!sequenceList.contains(4)){
                wrapDataHiddenValues(4);
            }
            else if(!sequenceList.contains(5)){
                wrapDataHiddenValues(5);
            }
            else if(!sequenceList.contains(6)){
                wrapDataHiddenValues(6);
            }



        }
    }

    private void wrapDataHiddenValues(int currentCol) {
        switch (currentCol)
        {
            case 1:
                  /*  colList_second1.add("A");
                    colList_second2.add("G");
                    colList_second3.add("M");
                    colList_second4.add("S");
                    colList_second5.add("Y");*/


               /* tvCol_1.setText(colList_second1.get(0));
                tvCol_2.setText(colList_second2.get(0));
                tvCol_3.setText(colList_second3.get(0));
                tvCol_4.setText(colList_second4.get(0));
                tvCol_5.setText(colList_second5.get(0));*/

                tvCol_1.setText(tvCol_1.getText()+"\n\n\n"+"A");
                tvCol_3.setText("G"+"\n\n\n"+tvCol_3.getText());
                tvCol_4.setText("M"+"\n\n\n"+tvCol_4.getText());
                tvCol_5.setText(tvCol_5.getText()+"\n\n\n"+"S");
                tvCol_2.setText("Y"+"\n\n\n"+tvCol_2.getText());

                break;
            case 2:
                   /* colList_second1.add("B");
                    colList_second2.add("H");
                    colList_second3.add("N");
                    colList_second4.add("T");
                    colList_second5.add("Z");*/

                tvCol_1.setText("B\n\n\n"+tvCol_1.getText());
                tvCol_3.setText("H\n\n\n"+tvCol_3.getText());
                tvCol_4.setText(tvCol_4.getText()+"\n\n\nN");
                tvCol_2.setText("T\n\n\n"+tvCol_2.getText());
                tvCol_5.setText(tvCol_5.getText()+"\n\n\nZ");


                break;
            case 3:
                    /*colList_second1.add("C");
                    colList_second2.add("I");
                    colList_second3.add("O");
                    colList_second4.add("U");
                    colList_second5.add("");*/

                tvCol_1.setText("C\n\n\n"+tvCol_1.getText());
                tvCol_3.setText("I\n\n\n"+tvCol_3.getText());
                tvCol_4.setText(tvCol_4.getText()+"\n\n\nU");

                tvCol_5.setText("O\n\n\n"+tvCol_5.getText());
                tvCol_2.setText(tvCol_2.getText()+"\n\n\n");
                break;
            case 4:
                   /* colList_second1.add("D");
                    colList_second2.add("J");
                    colList_second3.add("P");
                    colList_second4.add("V");
                    colList_second5.add("");*/


                tvCol_1.setText(tvCol_1.getText()+"\n\n\nD");
                tvCol_3.setText("J\n\n\n"+tvCol_3.getText());
                tvCol_5.setText(tvCol_5.getText()+"\n\n\nP");
                tvCol_4.setText("V\n\n\n"+tvCol_4.getText());
                tvCol_2.setText("\n\n\n"+tvCol_2.getText());

                break;
            case 5:
                    /*colList_second1.add("E");
                    colList_second2.add("K");
                    colList_second3.add("Q");
                    colList_second4.add("W");
                    colList_second5.add("");*/

                tvCol_1.setText("E\n\n\n"+tvCol_1.getText());
                tvCol_3.setText(tvCol_3.getText()+"\n\n\nK");
                tvCol_5.setText("Q\n\n\n"+tvCol_5.getText());
                tvCol_2.setText(tvCol_2.getText()+"\n\n\nW");
                tvCol_4.setText("\n\n\n"+tvCol_4.getText());
                break;
            case 6:
                    /*colList_second1.add("F");
                    colList_second2.add("L");
                    colList_second3.add("R");
                    colList_second4.add("X");
                    colList_second5.add("");*/


                tvCol_1.setText(tvCol_1.getText()+"\n\n\nF\n\n\n");
                tvCol_3.setText("L\n\n\n"+tvCol_3.getText());
                tvCol_5.setText("R\n\n\n"+tvCol_5.getText());
                tvCol_2.setText("\n\n\n"+tvCol_2.getText());
                tvCol_4.setText(tvCol_4.getText()+"\n\n\nX");
                break;
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




    }
    private void setOnclickListerner() {
        tvCol_1.setOnClickListener(this);

        tvCol_2.setOnClickListener(this);

        tvCol_3.setOnClickListener(this);

        tvCol_4.setOnClickListener(this);

        tvCol_5.setOnClickListener(this);

        btnBack.setOnClickListener(this);

        txtxGotIt.setOnClickListener(this);

        txtSkip.setOnClickListener(this);
    }

    private void populateDataInView(ArrayList<String> colData,TextView txtView) {
        String textToSet = "";
        for(int i = 0;i < colData.size();i++)
        {
            if(!textToSet.contains(colData.get(i)))
                textToSet = textToSet+colData.get(i)+"\n\n\n";
        }
        txtView.setText(textToSet);

        Log.d("test",colData.size()+" "+colData);

        if(txtView.getText().toString().trim().equals(""))
        {
            txtView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        }

    }

    private void populateData() {
        for(int i = 1;i <= sequenceList.size();i++)
        {
            switch (sequenceList.get(i-1))
            {
                case 1:
                    colList_second1.add("A");
                    colList_second2.add("G");
                    colList_second3.add("M");
                    colList_second4.add("S");
                    colList_second5.add("Y");
                    break;
                case 2:
                    colList_second1.add("B");
                    colList_second2.add("H");
                    colList_second3.add("N");
                    colList_second4.add("T");
                    colList_second5.add("Z");
                    break;
                case 3:
                    colList_second1.add("C");
                    colList_second2.add("I");
                    colList_second3.add("O");
                    colList_second4.add("U");
                    colList_second5.add("");
                    break;
                case 4:
                    colList_second1.add("D");
                    colList_second2.add("J");
                    colList_second3.add("P");
                    colList_second4.add("V");
                    colList_second5.add("");
                    break;
                case 5:
                    colList_second1.add("E");
                    colList_second2.add("K");
                    colList_second3.add("Q");
                    colList_second4.add("W");
                    colList_second5.add("");
                    break;
                case 6:
                    colList_second1.add("F");
                    colList_second2.add("L");
                    colList_second3.add("R");
                    colList_second4.add("X");
                    colList_second5.add("");
                    break;
            }


        }
        populateDataInView(colList_second1,tvCol_1);
        populateDataInView(colList_second2,tvCol_2);
        populateDataInView(colList_second3,tvCol_3);
        populateDataInView(colList_second4,tvCol_4);
        populateDataInView(colList_second5,tvCol_5);
        Log.d("cl1",colList_second1.toString());
        Log.d("cl2",colList_second2.toString());
        Log.d("cl3",colList_second3.toString());
        Log.d("cl4",colList_second4.toString());
        Log.d("cl5",colList_second5.toString());
    }



    private void init()
    {
        sequenceList = new ArrayList<>();

        if(getIntent().getExtras()!= null)
        {
            sequenceList = getIntent().getExtras().getIntegerArrayList("sequence");
        }
        Log.d("SecondActivity: ",sequenceList.toString());

        colList1 = new ArrayList<>();

        colList2 = new ArrayList<>();

        colList3 = new ArrayList<>();

        colList4 = new ArrayList<>();

        colList5 = new ArrayList<>();

        colList6 = new ArrayList<>();


        colList_second1 = new ArrayList<>();

        colList_second2 = new ArrayList<>();

        colList_second3 = new ArrayList<>();

        colList_second4 = new ArrayList<>();

        colList_second5 = new ArrayList<>();

        clickMap = new HashMap<>();

        tvCol_1 = (TextView) findViewById(R.id.tvClmn1);

        tvCol_2 = (TextView) findViewById(R.id.tvClmn2);

        tvCol_3 = (TextView) findViewById(R.id.tvClmn3);

        tvCol_4 = (TextView) findViewById(R.id.tvClmn4);

        tvCol_5 = (TextView) findViewById(R.id.tvClmn5);

        btnBack = (Button) findViewById(R.id.btnBack);



        slideDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);

        blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blinking_animation);

        llGuideScreenLayout = (RelativeLayout) findViewById(R.id.llguide_screen);

        ivSwipdown = (ImageView) findViewById(R.id.ivSwipdown);

        txtxGotIt = (TextView) findViewById(R.id.txtGotIt);

        txtGuideText = (TextView) findViewById(R.id.txtGuideText);

        txtSkip = (TextView) findViewById(R.id.txtSkip);




        typeface = Typeface.createFromAsset(getAssets(), "fonts/guide_text.ttf");

        btnBack.setTypeface(typeface);

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
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {


        try {
            Log.d("cl1",colList_second1.toString());
            Log.d("cl2",colList_second2.toString());
            Log.d("cl3",colList_second3.toString());
            Log.d("cl4",colList_second4.toString());
            Log.d("cl5",colList_second5.toString());
            Log.d("name",name);
            Log.d("clickNum",clickNum+"");
            /*if(clickNum == sequenceList.size())
            {
                Toast.makeText(SecondActivity.this,"We Guessed the name, name in your mind is "+name,Toast.LENGTH_SHORT).show();
            }
            else */{
                switch (v.getId()) {
                    case R.id.tvClmn1:
                        Log.d("Onclick called", "Test");
                        tvCol_1.clearAnimation();
                        tvCol_1.startAnimation(slideDownAnimation);

                        if (clickNum == 0) {
                            name = name + colList_second1.get(0);
                            clickNum++;
                        }
                        else {
                            name = name + colList_second1.get(clickNum);
                            clickNum++;

                        }
                        if(clickNum == sequenceList.size())
                        {
                            //Toast.makeText(SecondActivity.this,"We Guessed the name, name in your mind is "+name,Toast.LENGTH_SHORT).show();
                            showDialog(SecondActivity.this,name);
                        }
                        Log.d("name ddd ",name+" clickNum: "+clickNum+" colList_second1: "+colList_second1);
                        break;

                    case R.id.tvClmn2:
                        tvCol_2.clearAnimation();
                        tvCol_2.startAnimation(slideDownAnimation);
                        if (clickNum == 0) {
                            name = name + colList_second2.get(0);
                            clickNum++;
                        } else {
                            name = name + colList_second2.get(clickNum);
                            clickNum++;

                        }
                        Log.d("name ddd ",name+" clickNum: "+clickNum+" colList_second2: "+colList_second2);
                        if(clickNum == sequenceList.size())
                        {
                            // Toast.makeText(SecondActivity.this,"We Guessed the name, name in your mind is "+name,Toast.LENGTH_SHORT).show();
                            showDialog(SecondActivity.this,name);
                        }
                        break;

                    case R.id.tvClmn3:
                        tvCol_3.clearAnimation();
                        tvCol_3.startAnimation(slideDownAnimation);
                        if (clickNum == 0) {
                            name = name + colList_second3.get(0);
                            clickNum++;
                        } else {
                            name = name + colList_second3.get(clickNum);
                            clickNum++;

                        }
                        Log.d("name ddd ",name+" clickNum: "+clickNum+" colList_second3: "+colList_second3);
                        if(clickNum == sequenceList.size())
                        {
                            //Toast.makeText(SecondActivity.this,"We Guessed the name, name in your mind is "+name,Toast.LENGTH_SHORT).show();
                            showDialog(SecondActivity.this,name);
                        }
                        break;

                    case R.id.tvClmn4:
                        tvCol_4.clearAnimation();
                        tvCol_4.startAnimation(slideDownAnimation);
                        if (clickNum == 0) {
                            name = name + colList_second4.get(0);
                            clickNum++;
                        } else {
                            name = name + colList_second4.get(clickNum);
                            clickNum++;

                        }
                        if(clickNum == sequenceList.size())
                        {
                            //Toast.makeText(SecondActivity.this,"We Guessed the name, name in your mind is "+name,Toast.LENGTH_SHORT).show();
                            showDialog(SecondActivity.this,name);
                        }
                        Log.d("name ddd ",name+" clickNum: "+clickNum+" colList_second4: "+colList_second4);

                        break;
                    case R.id.tvClmn5:
                        tvCol_5.clearAnimation();
                        tvCol_5.startAnimation(slideDownAnimation);
                        if (clickNum == 0) {
                            name = name + colList_second5.get(0);
                            clickNum++;
                        } else {
                            name = name + colList_second5.get(clickNum);
                            clickNum++;

                        }
                        if(clickNum == sequenceList.size())
                        {
                            //Toast.makeText(SecondActivity.this,"We Guessed the name, name in your mind is "+name,Toast.LENGTH_SHORT).show();
                            showDialog(SecondActivity.this,name);
                        }
                        Log.d("name ddd ",name+" clickNum: "+clickNum+" colList_second5: "+colList_second5);

                        break;
                    case R.id.btnBack:
                        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
                        startActivity(intent);
                        break;
                    case R.id.txtGotIt:
                        if(txtxGotIt.getText().toString().equalsIgnoreCase("Next") && txtGuideText.getText().toString().equalsIgnoreCase("Swipe down the column which contains first letter of name"))
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean distinctValues(ArrayList<Integer> arr){
        HashSet<Integer> dataSet = new HashSet<>();
        for(int i=0;i<arr.size();i++)
        {
            dataSet.add(arr.get(i));
        }
        Log.d("dataSet: ",dataSet.toString());
        if(dataSet.size() == 1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public void showDialog(Context context, String name)
    {

        final Dialog dialog = new Dialog(SecondActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alertdialog_layout);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        txtNameTitle = (TextView) dialog.findViewById(R.id.txtNameTitle);

        txtName = (TextView) dialog.findViewById(R.id.txtName);

        typeface = Typeface.createFromAsset(getAssets(), "fonts/column_font.ttf");

        txtNameTitle.setTypeface(typeface);
        txtName.setTypeface(typeface);

        Button btnOk = (Button) dialog.findViewById(R.id.btnOk);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/guide_text.ttf");
        btnOk.setTypeface(typeface);
        //Button btncancel = (Button) dialog.findViewById(R.id.btnCancel);

        txtName.clearAnimation();
        txtName.startAnimation(blinkAnimation);

        txtName.setText(" \" "+name+" \"");

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(SecondActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        });

        dialog.show();

    }
}
