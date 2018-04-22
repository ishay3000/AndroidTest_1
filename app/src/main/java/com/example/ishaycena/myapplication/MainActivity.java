package com.example.ishaycena.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout ln = new LinearLayout(getApplicationContext());
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        params.leftMargin = 200;
//        params.topMargin = 200;
//
//        ln.setLayoutParams(params);
//
//        Button btn = new Button(this);
//        btn.setLayoutParams(params);
//        btn.setText("Click Me!");
//        ln.addView(btn);
//
//        LinearLayout mainLayout = findViewById(R.id.lnMain);
//
//        mainLayout.addView(ln);
//
//        Log.d("MyLog", String.valueOf(ln.isShown()));

        LinearLayout mainLayout = findViewById(R.id.lnMain);

        LinearLayout[] layouts = new LinearLayout[3];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        Button[][] btnArr = new Button[3][3];

        final int orgLeft = 70;
        final int orgTop = 100;
        final int incTop = 20;
        final int incLeft = 1;

        params.topMargin = orgTop;
        params.leftMargin = orgLeft;


        for (int i = 0; i < layouts.length; i++) {
            layouts[i] = new LinearLayout(this);
            layouts[i].setOrientation(LinearLayout.HORIZONTAL);
            layouts[i].setLayoutParams(params);

            for (int j = 0; j < btnArr.length; j++) {
                btnArr[i][j] = new Button(this);
                btnArr[i][j].setLayoutParams(params);
                btnArr[i][j].setText(String.format(Locale.ENGLISH, "%d - %d", i + 1, j + 1));

                layouts[i].addView(btnArr[i][j]);

                // incrementing left margin after every button added
                params.leftMargin += incLeft;
            }
            // moving the row a little bit to the bottom
            params.topMargin += incTop;
            mainLayout.addView(layouts[i]);

            params.leftMargin = orgLeft;
        }

    }
}
