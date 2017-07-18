package com.doctor;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.doctor.R;


public class Login extends Fragment {
    View rootView;
    int status;
    AlertDialog sendmailalert;
    String status11,emailid,mobilenum,password123,statuslogin,username,logintype,walletamt,userid;
    private CoordinatorLayout coordinatorLayout;
    String  result456,emailstring,mobilevalue;
    TextView emailerr, passerr, forgotpaswrd, register;
    private TextInputLayout email, password;
    private EditText emailedit, passwordedit;
    public  static String OPERATION_NAME = "LoginValidate";
    private Button login, Bookticketbtn;


    public Login()
    {
        //this.username=username;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.newlogin, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar)rootView. findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setLogo(R.color.transparent);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Login");

        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.cordlay);


        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.cordlay);
        login = (Button) rootView.findViewById(R.id.login);
        Bookticketbtn = (Button) rootView.findViewById(R.id.bookticket);

        //  email = (TextInputLayout) rootView.findViewById(R.id.emaillayout);
        emailedit = (EditText) rootView.findViewById(R.id.email);
        emailerr = (TextView) rootView.findViewById(R.id.emailerror);


        //  password = (TextInputLayout) rootView.findViewById(R.id.pwdlayout);
        passwordedit = (EditText) rootView.findViewById(R.id.pwd);
        passerr = (TextView) rootView.findViewById(R.id.pwderr);

        forgotpaswrd = (TextView) rootView.findViewById(R.id.fp);
        register = (TextView) rootView.findViewById(R.id.Register);


        NetworkUtil utils = new NetworkUtil();
        status = NetworkUtil.getConnectivityStatus(getActivity());
        status11 = NetworkUtil.getConnectivityStatusString(getActivity());

        if (status != 0) {

        } else {
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.content_frame, new Login());
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


        emailedit.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {

                if (hasfocus) {

                    passwordedit.setBackgroundResource(R.drawable.edittext);
                    emailedit.setBackgroundResource(R.drawable.edittextfirst);

                } else {

                }

            }
        });

        passwordedit.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {

                if (hasfocus) {

                    passwordedit.setBackgroundResource(R.drawable.edittextfirst);
                    emailedit.setBackgroundResource(R.drawable.edittext);
                    /*mailerror.setText("");*/
                } else {

                }

            }
        });


        emailedit.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    passwordedit.requestFocus();
                    emailedit.clearFocus();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;

            }
        });


        passwordedit.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(passwordedit.getWindowToken(), 0);
                    // Perform action on key press
                    login.performClick();
                    passwordedit.clearFocus();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.login:
                        if (checkValidation()) {
                            if (status != 0) {
                                passwordedit.setBackgroundResource(R.drawable.edittext);
                                emailedit.setBackgroundResource(R.drawable.edittextfirst);
                                login.setBackgroundResource(R.drawable.button);

                                com.doctor.Session sess=new com.doctor.Session(getActivity());
                               String mailid=sess.getMailid();
                               String password=sess.getPassword();
                                if(emailedit.getText().toString().equals(mailid)&&passwordedit.getText().toString().equals(password)||mailid.equals("hari@gmail.com")&&password.equals("hari"))
                                {
                                    if(mailid.equals("hari@gmail.com")&&password.equals("hari"))
                                    {
                                        sess.setGender("male");
                                        sess.setMailid("hari@gmail.com");
                                        sess.setUsername("haribabu");
                                        sess.setPassword("hari");
                                        sess.setDob("16/08/1993");

                                    }
                                    sess.setLogin("true");
                                    Intent intent=new Intent(getActivity(),Userclass.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    getActivity().runOnUiThread(new Runnable() {
                                        public void run() {
                                            showInputDialog2("Enter proper Credentials");
                                            //Do something on UiThread
                                        }
                                    });
                                }

                               /* Intent i = new Intent(getActivity(), Userclass.class);
                                startActivity(i);*/

                            } else {
                                Snackbar snackbar = Snackbar.make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                                        .setAction("Retry", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                FragmentManager fm = getFragmentManager();
                                                FragmentTransaction ft = fm.beginTransaction();
                                                ft.replace(R.id.content_frame, new Login());
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
                        }
                        break;
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.Register:
try {
   /* FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.content_frame, new Register());
    ft.addToBackStack(null) ;
    ft.commit();*/
   Intent i=new Intent(getActivity(),Register.class);
    startActivity(i);
}
catch (Exception e)
{
    e.printStackTrace();
}




                        break;
                }
            }
        });



        forgotpaswrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.fp:

                       /* showInputDialog();*/

                        break;
                }
            }
        });
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

        return rootView;

    }








    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Login");

    }

    private boolean checkValidation() {
        boolean ret = true;


        if (!Validation.isEmail(emailedit, emailerr)) ret = false;

        if (!Validation.isPassword(passwordedit, passerr)) ret = false;


        return ret;
    }

/*
    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.forgotpasswrd, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);

        @SuppressWarnings("unused")
        final EditText email11 = (EditText) promptView.findViewById(R.id.email);

        email11.setOnFocusChangeListener( new View.OnFocusChangeListener(){

            public void onFocusChange( View view, boolean hasfocus){

                if(hasfocus){

                    email11.setBackgroundResource( R.drawable.focus_border_style);
                }
                else{

                }

            } });
        email11.setOnClickListener(new View.OnClickListener()
                                   {
                                       @SuppressWarnings({ "static-access", "deprecation" })
                                       @Override
                                       public void onClick(View v) {
                                           switch (v.getId()) {
                                               case R.id.email:
                                                   int color=getResources().getColor(R.color.lightgrey);
                                                   Boolean isClicked = false;
                                                   isClicked = isClicked ? false : true;
                                                   if (isClicked) {
                                                       email11.setBackgroundResource(R.drawable.border);


                                                   } else {




                                                   }


                                                   break;

                                           } }}
        );


        final TextView message = (TextView) promptView.findViewById(R.id.message);
        final Button submit = (Button) promptView.findViewById(R.id.submit);
        final TextView errormail=(TextView)promptView.findViewById(R.id.emilerr);
         sendmailalert = alertDialogBuilder.create();


        float size = 14;




        sendmailalert.show();
        email11.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press


                    submit .performClick();
                    Log.e("Value", "Enter");
                    return true;
                }
                return false;


            }
        });





    }
*/




    protected void showInputDialog1() {

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.customdailog, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setView(promptView);


        final TextView message = (TextView) promptView.findViewById(R.id.message);


        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do things
            }
        });
        AlertDialog alert = alertDialogBuilder.create();

        alert.show();


        message.setText("Password sent to your emailid");
        Button ok = alert.getButton(DialogInterface.BUTTON_POSITIVE);


    }
    protected void showInputDialog2(String msg) {

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View promptView = layoutInflater.inflate(R.layout.customdailog, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

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


