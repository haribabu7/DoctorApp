package com.doctor;

/**
 * Created by vanaja on 6/1/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.doctor.R;

public class Splash extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 6000;
    String username,password,walletamt,userid,firstname,mobilevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
              /*  Session sess=new Session(Splash.this);
                password=sess.getPassword();
                username=sess.getUsername();
                walletamt=sess.getWalletAmount();
                firstname=sess.getFirstName();
                userid=sess.getUserid();
                mobilevalue=  sess.getMobile();
                if(username.equals("")||password.equals("")) {*/
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
              /*  }
                else
                {
                    Bundle mBundle=new Bundle();
                    mBundle.putString("uname",username);
                    mBundle.putString("wamt",walletamt);
                    mBundle.putString("uid",userid);
                    mBundle.putString("firstname",firstname);
                    mBundle.putString("password",password);
                    mBundle.putString("mobile",mobilevalue);
                    Intent i = new Intent(Splash.this, Userhome.class);
                    i.putExtra("bvalues",mBundle);
                    startActivity(i);
                }
*/
                // close this activity

            }
        }, SPLASH_TIME_OUT);
    }

}

