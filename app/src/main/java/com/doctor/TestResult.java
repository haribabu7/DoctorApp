package com.doctor;

/**
 * Created by Hari Babu on 17-07-2017.
 */

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.doctor.R;

public class TestResult extends AppCompatActivity {
    private ProgressBar mProgressBar;
    TextView result;
    int value;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testresult);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff9933")));
        bar.setTitle(Html.fromHtml("<font color='#000000'>Adress Details </font>"));
        bar.setDisplayShowHomeEnabled(false);
        View mActionBarView = getLayoutInflater().inflate(R.layout.backbtn1, null);
        bar.setCustomView(mActionBarView);
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        TextView t1 = (TextView) findViewById(R.id.textView1);
        t1.setText("Test Result");

        ImageButton ib = (ImageButton) findViewById(R.id.backbutton);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                overridePendingTransition(R.anim.enter, R.anim.exit);



            }
        });

        mProgressBar=(ProgressBar)findViewById(R.id.circle_progress_bar);
        result=(TextView)findViewById(R.id.result);

         value= getIntent().getIntExtra("percentage",0);
        result.setText("your affected with "+value+"% Toods Sysdrome");
        new Thread(new Runnable() {
            int i = 0;
            int progressStatus = 0;

            public void run() {
                while (progressStatus < value) {
                    progressStatus += 5;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    handler.post(new Runnable() {
                        public void run() {
                            mProgressBar
                                    .setProgress(progressStatus);
                            i++;
                        }
                    });
                }
            }
        }).start();
    }

}
