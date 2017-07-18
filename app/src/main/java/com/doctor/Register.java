package com.doctor;




import android.app.AlertDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.doctor.R;


public class Register extends ActionBarActivity implements DatePickerDialog.OnDateSetListener {
    View rootView;
    boolean show=true;
    int status;
    String namevalue,mailidvalue,passwordvalue,confirmpasswordvalue;
    String status11;
    ProgressDialog pd;
    private CoordinatorLayout coordinatorLayout;
    Button bookticket,Register;
    TextView login,usernameerr,mailerr,pwderr,comfirmpwderr;
    CheckBox checkBox;
    AutoCompleteTextView gendervalue;

    String loginStatus;
    int Year, Month, Day;

    public  static String OPERATION_NAME = "UserRegistration";
    EditText mail,username,password,confirmpwd,dob;
    List<String> categories;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Calendar calendar;
        calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

       /* getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);*/
        bookticket=(Button)findViewById(R.id.bookticket);
        Register=(Button)findViewById(R.id.button3);
        categories=new ArrayList<>();
        categories.add("male");
        categories.add("female");
        categories.add("dont want to say");
        login=(TextView)findViewById(R.id.Register);

      usernameerr=(TextView)findViewById(R.id.usernameerr);
        mailerr=(TextView)findViewById(R.id.emailerr);
        pwderr=(TextView)findViewById(R.id.passerr);
        comfirmpwderr=(TextView)findViewById(R.id.confirmpaserr);
        gendervalue=(AutoCompleteTextView)findViewById(R.id.gender);

        username=(EditText) findViewById(R.id.username);
        mail=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.passwrd1);
        confirmpwd=(EditText) findViewById(R.id.confrmpaswrd1);
        dob=(EditText) findViewById(R.id.dob);
      /* getSupportActionBar().setLogo(R.color.transparent);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Register");*/

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff9933")));
        bar.setTitle(Html.fromHtml("<font color='#000000'>Adress Details </font>"));
        bar.setDisplayShowHomeEnabled(false);
        View mActionBarView = getLayoutInflater().inflate(R.layout.backbtn1, null);
        bar.setCustomView(mActionBarView);
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        TextView t1 = (TextView) findViewById(R.id.textView1);
        t1.setText("     Register");

        ImageButton ib = (ImageButton) findViewById(R.id.backbutton);

        dob.setShowSoftInputOnFocus(false);
        gendervalue.setShowSoftInputOnFocus(false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Register.this, android.R.layout.simple_selectable_list_item, categories);
        gendervalue.setThreshold(1);


        gendervalue.setAdapter(adapter);

        gendervalue.setTextColor(Color.BLACK);


        ib.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      finish();
                                  }
                              });
                overridePendingTransition(R.anim.enter, R.anim.exit);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cordlay);

        NetworkUtil utils = new NetworkUtil();
        status = NetworkUtil. getConnectivityStatus(Register.this);
        status11 = NetworkUtil.getConnectivityStatusString(Register.this);

        if(status != 0){

        }else{
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new OnClickListener() {
                        @Override
                        public void onClick(View view) {

                           /* FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.content_frame, new Register());
                            ft.commit();*/

                        }
                    });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(Register.this, R.color.red));

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            snackbar.show();
        }


        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (password.getRight() - password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
if(show) {
    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.show, 0);
    show=false;
}
else {
    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.hide, 0);
    show=true;
}
                        return true;
                    }
                }
                return false;
            }
        });


        confirmpwd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (confirmpwd.getRight() - confirmpwd.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        if(show) {
                            confirmpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                            confirmpwd.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.show, 0);
                            show=false;
                        }
                        else {
                            confirmpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            confirmpwd.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.hide, 0);
                            show=true;
                        }
                        return true;
                    }
                }
                return false;
            }
        });




        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {

                if (hasfocus) {

                    mail.setBackgroundResource(R.drawable.edittext);
                    password.setBackgroundResource(R.drawable.edittext);
                    confirmpwd.setBackgroundResource(R.drawable.edittext);
                    username.setBackgroundResource(R.drawable.edittextfirst);

                } else {

                }

            }
        });

        mail.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {

                if (hasfocus) {
                    mail.setBackgroundResource(R.drawable.edittextfirst);
                    password.setBackgroundResource(R.drawable.edittext);
                    confirmpwd.setBackgroundResource(R.drawable.edittext);
                    username.setBackgroundResource(R.drawable.edittext);
                    /*mailerror.setText("");*/
                } else {

                }

            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {

                if (hasfocus) {
                    password.setBackgroundResource(R.drawable.edittextfirst);
                    mail.setBackgroundResource(R.drawable.edittext);
                    confirmpwd.setBackgroundResource(R.drawable.edittext);
                    username.setBackgroundResource(R.drawable.edittext);
                    /*mailerror.setText("");*/
                } else {

                }

            }
        });


        confirmpwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {

                if (hasfocus) {
                    confirmpwd.setBackgroundResource(R.drawable.edittextfirst);
                    password.setBackgroundResource(R.drawable.edittext);
                    mail.setBackgroundResource(R.drawable.edittext);
                    username.setBackgroundResource(R.drawable.edittext);
                    /*mailerror.setText("");*/
                } else {

                }

            }
        });



        username.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    mail.requestFocus();
                    username.clearFocus();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;

            }
        });


        mail.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                   /* InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(passwordedit.getWindowToken(), 0);*/
                    // Perform action on key press
                    password.requestFocus();
                    mail.clearFocus();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;

            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                   /* InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(passwordedit.getWindowToken(), 0);*/
                    // Perform action on key press
                    confirmpwd.requestFocus();
                    password.clearFocus();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;

            }
        });


        confirmpwd.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(confirmpwd.getWindowToken(), 0);
                    // Perform action on key press
                    Register.performClick();
                    confirmpwd.clearFocus();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;

            }
        });

        Register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button3:
                        if ( checkValidation () ) {
                            if(status!=0) {
                                Register.setBackgroundResource(R.drawable.button);
                                passwordvalue=password.getText().toString();
                                confirmpasswordvalue=confirmpwd.getText().toString();
                                mailidvalue=mail.getText().toString();
                                namevalue=username.getText().toString();

                                if(confirmpasswordvalue.equals(passwordvalue))
                                {
                                  /*  Registerasync regasync = new Registerasync();
                                    regasync.execute("");*/

Session sess=new Session(Register.this);
                                    sess.setUsername(username.getText().toString());
                                    sess.setMailid(mail.getText().toString());
                                    sess.setPassword(password.getText().toString());
                                    sess.setDob(dob.getText().toString());
                                    sess.setGender(gendervalue.getText().toString());
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            AlertDialogCreate();
                                            //Do something on UiThread
                                        }
                                    });
                                }
                                else
                                {
                                   runOnUiThread(new Runnable() {
                                        public void run() {
                                            showInputDialog2("Both passwords should mathch");
                                            //Do something on UiThread
                                        }
                                    });
                                   /* Toast.makeText(getActivity(),"Both passwords should mathc",Toast.LENGTH_LONG).show();*/

                                }

                            }
                            else
                            {
                                Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                                        .setAction("Retry", new OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                              /*  FragmentManager fm = getFragmentManager();
                                                FragmentTransaction ft = fm.beginTransaction();
                                                ft.replace(R.id.content_frame, new Register());
                                                ft.commit();*/
                                            }
                                        });
                                snackbar.setActionTextColor(Color.YELLOW);
                                snackbar.getView().setBackgroundColor(ContextCompat.getColor(Register.this, R.color.red));

                                View sbView = snackbar.getView();
                                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                                textView.setTextColor(Color.WHITE);

                                snackbar.show();




                            }


                            break;
                        }
                        else
                        {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    showInputDialog2("Please enter all fields properly");
                                    //Do something on UiThread
                                }
                            });
                        }

                }
            }});

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.Register:
                       /* FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.content_frame, new Login());
                        ft.addToBackStack(null);
                        ft.commit();*/
                        Intent i=new Intent(Register.this,Login.class);
                        startActivity(i);

                        break;
                }
            }
        });

        dob.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.dob:

                        datePickerDialog = DatePickerDialog.newInstance(Register.this, Year, Month, Day);

                        datePickerDialog.setThemeDark(false);

                        datePickerDialog.showYearPickerFirst(false);




                        datePickerDialog.setAccentColor(Color.parseColor("#009688"));

                        datePickerDialog.setTitle("Select Date");

                        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");


                        break;
                }
            }
        });

     /*   setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {   Log.i("tag", "onKey Back listener is working!!!");
                   *//* FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.content_frame, new Login());
                    ft.addToBackStack(null);
                    ft.commit();*//*

                    return true;
                }
                return false;
            }
        } );
        return rootView;*/

    }


   /* public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Register");

    }*/


    public void AlertDialogCreate(){

        new android.support.v7.app.AlertDialog.Builder(Register.this)


                .setMessage("You have Registered  Succesfully")
                .setPositiveButton("OK", null)

                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                       /* FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.content_frame, new Login());
                        ft.addToBackStack(null);
                        ft.commit();*/
                       /*Intent i=new Intent(Register.this,Login.class);
                        startActivity(i);*/
                       finish();

                        // Toast.makeText(MainActivity.this, "You Clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }



     @Override
     public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
         String date = "" + dayOfMonth + "/" + (monthOfYear+1) + "/" + year;
         dob.setText(date);
     }

    /*public void AlertDialogCreate1(){

        new android.support.v7.app.AlertDialog.Builder(getActivity())


                .setMessage(loginStatus)
                .setPositiveButton("OK", null)

                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // Toast.makeText(MainActivity.this, "You Clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
*/





    private boolean checkValidation() {
        boolean ret = true;


        if (!Validation.hasText(username,usernameerr)) ret = false;

        if (!Validation.isPassword(password,pwderr)) ret = false;
        if (!Validation.isPassword(confirmpwd,comfirmpwderr)) ret = false;
        if (!Validation.isEmail(mail,mailerr)) ret = false;
        if (!Validation.hasText(gendervalue,mailerr)) ret = false;
        if (!Validation.hasText(dob,mailerr)) ret = false;
        return ret;
    }
    protected void showInputDialog2(String msg) {

        LayoutInflater layoutInflater = LayoutInflater.from(Register.this);
        View promptView = layoutInflater.inflate(R.layout.customdailog, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Register.this);

        alertDialogBuilder.setView(promptView);


        final TextView message = (TextView) promptView.findViewById(R.id.message);


        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
            }
        });
        AlertDialog alert = alertDialogBuilder.create();

        alert.show();


        message.setText(msg);
        Button ok = alert.getButton(DialogInterface.BUTTON_POSITIVE);


    }

}
