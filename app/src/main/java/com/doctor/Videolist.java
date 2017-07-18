package com.doctor;

/**
 * Created by vanaja on 6/1/2017.
 */

import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.doctor.R;


public class Videolist extends android.support.v4.app.Fragment{
View rootview;

    RelativeLayout rl,rlrv,one,two,three,four,five;
    int status;
    String  status11;String login;

    /*  String[] videoFileList = {
            "/sdcard/Video/Android 2.0 Official Video_low.mp4",
            "/sdcard/Video/Android 2.2 Official Video_low.mp4",
            "/sdcard/Video/Android 2.3 Official Video_low.mp4",
            "/sdcard/Video/Android 3.0 Preview_low.mp4",
            "/sdcard/Video/Android Demo_low.mp4",
            "/sdcard/Video/Android in Spaaaaaace!.mp4",
            "/sdcard/Video/Android in Spaaaaaace!_low.mp4",
            "/sdcard/Video/What is an Android phone-_low.mp4"
    };
*/
    public Videolist() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
      rootview =  inflater.inflate(R.layout.row, container, false);
      /*  rl=(RelativeLayout)rootview.findViewById(R.id.rl);
        rlrv=(RelativeLayout)rootview.findViewById(R.id.rlrv);*/
        one=(RelativeLayout)rootview.findViewById(R.id.rl);
        two=(RelativeLayout)rootview.findViewById(R.id.rl11);
        three=(RelativeLayout)rootview.findViewById(R.id.rl12);
        four=(RelativeLayout)rootview.findViewById(R.id.rl3);
        five=(RelativeLayout)rootview.findViewById(R.id.rl121);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(R.color.transparent);
       // ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Freetrail");
        NetworkUtil utils = new NetworkUtil();
        status = NetworkUtil.getConnectivityStatus(getActivity());
        status11 = NetworkUtil.getConnectivityStatusString(getActivity());
        Session sess=new Session(getActivity());
         login=sess.getLogin();

        if (status != 0) {

        } else {
            Snackbar snackbar = Snackbar.make(rlrv, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.content_frame, new Videolist());
                            ft.commit();
                        }
                    });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red));

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            snackbar.show();
        }
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.rl:



                       /* FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.content_frame, new Freetrail());
                        ft.addToBackStack(null) ;
                        ft.commit();*/
 /*Intent intent1 = new Intent(getActivity(), Freevideolist.class);
    startActivity(intent1);*/


  //  Freevideo fd= new Freevideo(getContext());
    /*getActivity().overridePendingTransition(R.anim.enter, R.anim.exit);*/
if(login.equals("true"))
{ /*Intent intent1 = new Intent(getActivity(), PatientTest.class);
    startActivity(intent1);*/
    android.support.v4.app.Fragment fragment = new PatientTest();
    if (fragment != null) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }


}
     else
{
    Toast.makeText(getActivity(),"Please login for Testing",Toast.LENGTH_LONG).show();
}

                        break;
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.rl11:
                        if(login.equals("true"))
                        {
                            Toast.makeText(getActivity(),"These tests are coming soon",Toast.LENGTH_LONG).show();
                        }
                       else
                        {
                            Toast.makeText(getActivity(),"Please login for Testing",Toast.LENGTH_LONG).show();
                        }

                        break;
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.rl12:

                        if(login.equals("true"))
                        {
                            Toast.makeText(getActivity(),"These tests are coming soon",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Please login for Testing",Toast.LENGTH_LONG).show();
                        }

                        break;
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.rl3:

                        if(login.equals("true"))
                        {
                            Toast.makeText(getActivity(),"These tests are coming soon",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Please login for Testing",Toast.LENGTH_LONG).show();
                        }

                        break;
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.rl121:

                        if(login.equals("true"))
                        {
                            Toast.makeText(getActivity(),"These tests are coming soon",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Please login for Testing",Toast.LENGTH_LONG).show();
                        }

                        break;
                }
            }
        });

       /* android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        myPlayerFragment = (PlayerFragment)fragmentManager.findFragmentById(R.id.playerfragment);
        myVideoListFragment = (VideoListFragment)fragmentManager.findFragmentById(R.id.videolistfragment);*/
return  rootview;
    }

}