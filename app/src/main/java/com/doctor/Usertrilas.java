package com.doctor;

/**
 * Created by vanaja on 6/6/2017.
 */

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;


import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import com.doctor.R;

//Implementing the interface OnTabSelectedListener to our MainActivity
//This interface would help in swiping views
public class Usertrilas extends Fragment /*implements TabLayout.OnTabSelectedListener*/{
    int status;
    String status11,useridval;
    private CoordinatorLayout coordinatorLayout;
    //This is our tablayout
    public static TabLayout tabLayout;
    String username;
    int currentPage=0;
    //This is our viewPager
    public static ViewPager viewPager;
    ViewPager mPager;
    private static final Integer[] XMEN = {R.drawable.asana1, R.drawable.asana2, R.drawable.asana3, R.drawable.asana4};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    public Usertrilas()
    {
        this.username=username;

    }

    static View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home1, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Adding toolbar to the activity

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(R.color.transparent);
        Session sess=new Session(getActivity());
        String username=sess.getUsername();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(username);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.cordlay);

        NetworkUtil utils = new NetworkUtil();
        status = NetworkUtil. getConnectivityStatus(getActivity());
        status11 = NetworkUtil.getConnectivityStatusString(getActivity());

        if(status != 0){

        }else{
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Fragment fragment = new Usertrilas();
                            FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();
                        }
                    });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), R.color.red));

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            snackbar.show();
        }


        //Initializing the tablayout
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method setupViewPager(viewPager);

        viewPager = (ViewPager)rootView. findViewById(R.id.pager);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);



      /*  tabLayout.addTab(tabLayout.newTab().setText("Past"));
        tabLayout.addTab(tabLayout.newTab().setText("Upcomming"));
        tabLayout.addTab(tabLayout.newTab().setText("Cancelled"));*/
        // tabLayout.addTab(tabLayout.newTab().setText("Failed"));

        //   tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager


        //Creating our pager adapter
        // Pager adapter = new Pager(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        //viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        //   tabLayout.setOnTabSelectedListener(this);


        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {   Log.i("tag", "onKey Back listener is working!!!");
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    return true;
                }
                return false;
            }
        } );
init();
        return  rootView;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        //adapter.addFrag(new Videolist(), "Freetrail");
        adapter.addFrag(new Videolist(), "Premium");
       /* adapter.addFrag(new u(), "Categories");*/
     //   adapter.addFrag(new Login(), "Login");
       /* adapter.addFrag(new FiveFragment(), "FIVE");
        adapter.addFrag(new SixFragment(), "SIX");
        adapter.addFrag(new SevenFragment(), "SEVEN");
        adapter.addFrag(new EightFragment(), "EIGHT");
        adapter.addFrag(new NineFragment(), "NINE");
        adapter.addFrag(new TenFragment(), "TEN");*/
        viewPager.setAdapter(adapter);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
       /* getActivity().setTitle("Vanaja gollapally");*/

    }

   /* @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }*/

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position).toLowerCase();
        }
    }
    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager)rootView.findViewById(R.id.pager1);
        mPager.setAdapter(new MyAdapter(getActivity(), XMENArray));
        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

}
