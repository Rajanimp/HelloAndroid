package com.example.rajani.helloandroid;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.animation.ArgbEvaluator;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textMessage;
    TextView phoneNumber;
    TextView webPage;
    TextView addressOnMap;
    TextView androidNanodegree;
    TextView fullStackNanodegree;
    TextView webNanodegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMessage = findViewById(R.id.tv_jobs);
        phoneNumber = findViewById(R.id.tv_phone);
        webPage = findViewById(R.id.tv_website);
        addressOnMap = findViewById(R.id.tv_address);

        androidNanodegree = findViewById(R.id.tv_android_dev);
        fullStackNanodegree = findViewById(R.id.tv_full_stack_dev);
        webNanodegree = findViewById(R.id.tv_mobile_dev);

        Log.e("MainActivity", "Before stripUnderlines");

        if (phoneNumber != null) {
            StringUtil.stripUnderlines((Spannable) phoneNumber.getText());
        }

        if (webPage != null) {
            StringUtil.stripUnderlines((Spannable) webPage.getText());
        }

        if (addressOnMap != null) {
            StringUtil.stripUnderlines((Spannable) addressOnMap.getText());
        }

        Log.e("MainActivity", "After stripUnderlines");

        addTextViewListeners();
    }

    private void addTextViewListeners() {
        androidNanodegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://in.udacity.com/course/android-basics-nanodegree-by-google--nd803"));
                startActivity(browserIntent);
            }
        });

        fullStackNanodegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://in.udacity.com/course/full-stack-web-developer-nanodegree--nd004"));
                startActivity(browserIntent);
            }
        });

        webNanodegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://in.udacity.com/course/front-end-web-developer-nanodegree--nd001"));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        animateText();
    }

    public void animateText() {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ObjectAnimator colorAnim = ObjectAnimator.ofObject(textMessage, "textColor", new ArgbEvaluator(), Color.parseColor("#FFFFFF"), Color.parseColor("#3F51B5"));
                    colorAnim.setDuration(8000);
                    colorAnim.setInterpolator(new AccelerateInterpolator());
                    colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                    colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                    colorAnim.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
