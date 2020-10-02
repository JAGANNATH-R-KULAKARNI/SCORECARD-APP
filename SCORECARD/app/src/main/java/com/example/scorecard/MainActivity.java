package com.example.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    ArrayList<String>  info=new ArrayList<String>();
    public static final String MSG="com.example.scorecard.MSG";
    int points_team_a=0;
    int points_team_b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void display(boolean num)
    {
        TextView comments_jag=(TextView) findViewById(R.id.comments);

        String team_a_com="1 points for TEAM A";
        String team_b_com="1 points for TEAM B";

        if(num)
        {

            if(points_team_a < points_team_b)
            {
                int asd=points_team_b-points_team_a;
                comments_jag.setText(team_a_com +", but still TEAM A lags behind TEAM B by "+asd);
                info.add(team_a_com +", but still TEAM A lags behind TEAM B by "+asd);
            }
            else if(points_team_a > points_team_b)
            {
                int asd=points_team_a-points_team_b;
                comments_jag.setText(team_a_com +", TEAM A leads by "+asd);
                info.add(team_a_com +", TEAM A leads by "+asd);
            }
            else
            {
                comments_jag.setText(team_a_com +", Score Levels ");
                info.add(team_a_com +", Score Levels ");
            }
        }
        else
        {
            if(points_team_b < points_team_a)
            {
                int asd=points_team_a-points_team_b;
                comments_jag.setText(team_b_com +", but still TEAM B lags behind TEAM A by "+asd);
                info.add(team_b_com +", but still TEAM B lags behind TEAM A by "+asd);
            }
            else if(points_team_b > points_team_a)
            {
                int asd=points_team_b-points_team_a;
                comments_jag.setText(team_b_com +", TEAM B leads by "+asd);
                info.add(team_b_com +", TEAM B leads by "+asd);
            }
            else
            {
                comments_jag.setText(team_b_com +", Score Levels ");
                info.add(team_b_com +", Score Levels ");
            }
        }

    }


    public void increment_team_a(View view)
    {
        TextView points_text_view_a = (TextView) findViewById(R.id.team_a_points);
    points_team_a++;
    if(points_team_a==15 && points_team_b<15) {
        TextView comments_jag = (TextView) findViewById(R.id.comments);
        points_text_view_a.setText("" + points_team_a);
        comments_jag.setText("TEAM A wins ! Congrats !");
        info.add("TEAM A wins ! Congrats !");
    }
      if(points_team_b<15 && points_team_a<15) {
          points_text_view_a.setText("" + points_team_a);
          display(true);
      }
    }

    public void increment_team_b(View view)
    {
        TextView points_text_view_b = (TextView) findViewById(R.id.team_b_points);
        points_team_b++;
        if(points_team_b==15 && points_team_a<15) {
            TextView comments_jag = (TextView) findViewById(R.id.comments);
            points_text_view_b.setText("" + points_team_b);
            comments_jag.setText("TEAM B wins ! Congrats !");
            info.add("TEAM B wins ! Congrats !");
        }
        if(points_team_b<15 && points_team_a<15) {
            points_text_view_b.setText("" + points_team_b);
            display(false);
        }
    }

    public void reset_eve(View view)
    {
        points_team_a=0;
        points_team_b=0;
        TextView points_text_view_a=(TextView) findViewById(R.id.team_a_points);
        points_text_view_a.setText(""+points_team_a);
        TextView points_text_view_b=(TextView) findViewById(R.id.team_b_points);
        points_text_view_b.setText(""+points_team_b);
        TextView comments_jag=(TextView) findViewById(R.id.comments);
        comments_jag.setText("Let Us Play :)");
    }

    public void Game_summary(View view)
    {
        Intent intent=new Intent(this,Game_summary_activity.class);
        intent.putExtra(MSG,info);
        startActivity(intent);
    }
}
