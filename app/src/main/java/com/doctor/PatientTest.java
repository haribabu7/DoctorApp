package com.doctor;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.doctor.R;


public class PatientTest extends Fragment{
    int status;
    String status11;
    LinearLayout ll;
    EditText edit;

    boolean drugs=false,noclicked,yesclicked;
    Button testresult,no,yes;
    public PatientTest() {
        // Required empty public constructor
    }

    GridView grid;
    View rootview;
    String[] web = {
            "migrains",
            "backpain",
            "legpain",
            "diabetes",
            "headache",
            "legpain",
    } ;
    int[] imageId = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,


    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.diseasetest, container, false);
edit=(EditText)rootview.findViewById(R.id.diseasename);
        no=(Button) rootview.findViewById(R.id.no);
        yes=(Button) rootview.findViewById(R.id.yes);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Adding toolbar to the activity

        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(R.color.transparent);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Patients Test");

       /* ll=(LinearLayout)rootview.findViewById(R.id.ll) ;*/
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(R.color.transparent);
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");
        NetworkUtil utils = new NetworkUtil();
        status = NetworkUtil. getConnectivityStatus(getContext());
        status11 = NetworkUtil.getConnectivityStatusString(getActivity().getApplicationContext());
        grid = (GridView)rootview. findViewById(R.id.diseases);
        testresult=(Button)rootview.findViewById(R.id.testresult);

        if(status != 0){

        }else{
            /*Snackbar snackbar = Snackbar.make(ll, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Fragment fragment = new Categories();
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
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
       */ }
        no.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.no:
                        drugs=false;
                        if(noclicked)
                        {
                            no.setBackgroundColor(Color.parseColor("#1C8B98"));
                            yes.setBackgroundColor(Color.parseColor("#FF0000"));
                            noclicked=false;
                            yesclicked=true;
                        }
                        else
                        {
                            no.setBackgroundColor(Color.parseColor("#FF0000"));
                            yes.setBackgroundColor(Color.parseColor("#1C8B98"));
                            noclicked=true;
                            yesclicked=false;

                        }
                        break;
                }}
                });
        yes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.yes:
                        drugs=true;
                        if(yesclicked)
                        {
                            yes.setBackgroundColor(Color.parseColor("#1C8B98"));
                            no.setBackgroundColor(Color.parseColor("#FF0000"));
                            yesclicked=false;
                            noclicked=true;
                        }
                        else
                        {
                            yes.setBackgroundColor(Color.parseColor("#FF0000"));
                            no.setBackgroundColor(Color.parseColor("#1C8B98"));
                            yesclicked=true;
                            noclicked=false;

                        }
                        break;
                }}
        });
        testresult.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.testresult:
                        int age=0;
                        int diseasepercentage=0;
                        Session sess=new Session(getActivity());
                       String gender= sess.getGender();
                      String dobvalue=  sess.getDob();

                        if((yesclicked||noclicked)&&edit.getText()!=null)
                        {
                            if(edit.getText().toString().equals("migrains"))
                            {
                                diseasepercentage=diseasepercentage+25;
                            }
                            if(yesclicked)
                            {
                                diseasepercentage=diseasepercentage+25;
                            }
                            try {
                                Calendar now = Calendar.getInstance();
                                Calendar dob = Calendar.getInstance();
                            /*Calendar cal = Calendar.getInstance();*/
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                dob.setTime(sdf.parse(dobvalue));

                                if (dob.after(now)) {
                                    throw new IllegalArgumentException("Can't be born in the future");
                                }
                                int year1 = now.get(Calendar.YEAR);
                                int year2 = dob.get(Calendar.YEAR);
                                 age = year1 - year2;
                                int month1 = now.get(Calendar.MONTH);
                                int month2 = dob.get(Calendar.MONTH);
                                if (month2 > month1) {
                                    age--;
                                } else if (month1 == month2) {
                                    int day1 = now.get(Calendar.DAY_OF_MONTH);
                                    int day2 = dob.get(Calendar.DAY_OF_MONTH);
                                    if (day2 > day1) {
                                        age--;
                                    }
                                }
                            }

                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            if(age<=15)
                            {
                                diseasepercentage=diseasepercentage+25;
                            }
                            if(gender.equals("male"))
                            {
                                diseasepercentage=diseasepercentage+25;
                            }
                            Intent intent=new Intent(getActivity(),TestResult.class);
intent.putExtra("percentage",diseasepercentage);
                            startActivity(intent);
                        }
                        break;
                }}
        });

        CustomGrid adapter = new CustomGrid(getActivity(), web, imageId);
        grid = (GridView)rootview. findViewById(R.id.diseases);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(status!=0) {
                    edit.setText(web[position]);

                }
                else
                {
                /*    Snackbar snackbar = Snackbar.make(ll, "No internet connection!", Snackbar.LENGTH_LONG)
                            .setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    Fragment fragment = new Categories();
                                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
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

                    snackbar.show();*/

                }

            }
        });



        return rootview;
    }

}