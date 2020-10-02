package com.example.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Game_summary_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_summary_activity);
        Intent intent=getIntent();
        ArrayList<String> message=intent.getStringArrayListExtra(MainActivity.MSG);
        StringBuffer summary_string = new StringBuffer();
        summary_string.append("=>");
        for (String s : message)
        {
            summary_string.append(s);
            summary_string.append("\n=>");
        }

        TextView textView=findViewById(R.id.sumarry_page_id);
        textView.setText(summary_string);
    }
}