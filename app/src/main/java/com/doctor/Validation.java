package com.doctor;

/**
 * Created by vanaja on 1/6/2017.
 */


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Validation {

    private static final String REQUIRED_MSG = "required";
    private static final String onlystring = "numbers symbols not allowed";
    private static final String gender = "gender";
    private static final String bordingpt = "Please Select BoardingPoint";
    private static final String name = "Please Enter your Name";
    private static final String ticketmsg = "Please Enter ticket/PNR numbber";
    private static final String largestring = "length must less than 35 char";
    private static final String notString = "select date";
    private static final String cityfrmt = "Enter City";

    private static final String datefrmt = "please select journey date";
    private static final String emailFormat = "Enter correct mail";
    private static final String mobileFormat = "Enter valid mobile no";
    private static final String passwordFormat = "Enter correct Password";

    /*public static boolean hasText(EditText editText, TextView skillserror) {
        boolean flag = true;
        String text = editText.getText().toString().trim();
        int len = text.length();
        // length 0 means there is no text
        if (len == 0) {
            skillserror.setText(REQUIRED_MSG);
            return false;
        } else if (len > 35) {
            skillserror.setText(largestring);

            return false;
        }
        return true;*/
	   /*     else
	        {char c;
	        	for(int i=0;i<len;i++)
	        	{

	        		c=text.charAt(i);
	        		if((c>=65&&c<=90)||(c>=97&&c<=122))
	        		{
	        			Log.d("character", "char value"+c);
	        			flag=true;
	        		}
	        		else
	        		{
	        			skillserror.setText(onlystring);
	        			flag=false;
	        			i=len;
	        		}
	        	}
	       	 return flag;

	        }*/



    public static boolean isSelected(Spinner spincheck, Context context) {
        // TODO Auto-generated method stub
        String st = spincheck.getSelectedItem().toString();

        Log.d(REQUIRED_MSG, "spinner choosen value" + st);
        if (st == "selectDepartment") {
            TextView errorText = (TextView) spincheck.getSelectedView();
           /* errorText.setText("anything here, just to add the icon");*/
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText(bordingpt);
spincheck.requestFocus();
            return false;

        }

        return true;

    }

    public static boolean isChecked(EditText toggle) {
        // TODO Auto-generated method stub
        String text = toggle.getText().toString().trim();
        toggle.setText(null);
        int len = text.length();
        // length 0 means there is no text
        if (len == 0) {
            toggle.setText(REQUIRED_MSG);
            return false;
        } else if (text.equalsIgnoreCase("male") || text.equalsIgnoreCase("female")) {
            return true;
        } else {
            toggle.setText(gender);
            return false;
        }
    }

    public static boolean isDate(EditText doj, TextView dateerror) {
        // TODO Auto-generated method stub
        String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String em =doj.getText().toString();
        if (em.matches(EMAIL_REGEX)) {
            dateerror.setText("");
            return true;
        } else {
           /* dateerror.setText(emailFormat);*/
            doj.requestFocus();
            return false;
        }
    }

    public static boolean isMobile(EditText mobile, TextView mobileerror) {
        String text = mobile.getText().toString().trim();

        int len = text.length();
        boolean flag = false;
        if (len != 10) {
            /*mobileerror.setText(mobileFormat);*/
            mobile.requestFocus();
            return false;
        }
        mobileerror.setText("");
        return true;


    }

    public static boolean isMobile123(EditText mobile) {
        String text = mobile.getText().toString().trim();

        int len = text.length();
        boolean flag = false;
        if (len != 10) {
           /* mobile.setError(mobileFormat);*/
            mobile.requestFocus();
            return false;
        }

        return true;


    }


    public static boolean isPassword(EditText password, TextView passworderror) {
        String PASS_REGEX = "^([a-zA-Z0-9@*#]{1,15})$";
        String em = password.getText().toString();
        if (em.matches(PASS_REGEX)) {
         /*   passworderror.setText("");*/
            return true;
        } else {
          /*  passworderror.setText(passwordFormat);*/
            password.requestFocus();
            return false;
        }
    }
    public static boolean isPassword1(EditText newpwd, TextView newerror) {
        String PASS_REGEX = "^([a-zA-Z0-9@*#]{1,15})$";
        String em = newpwd.getText().toString();
        if (em.matches(PASS_REGEX)) {
            newerror.setText("");
            return true;
        } else {
            /*newerror.setText(passwordFormat);*/
            newpwd.requestFocus();
            return false;
        }
    }
    public static boolean isPassword2(EditText confirmpwd, TextView cpperroorr) {
        String PASS_REGEX = "^([a-zA-Z0-9@*#]{1,15})$";
        String em = confirmpwd.getText().toString();
        if (em.matches(PASS_REGEX)) {
          cpperroorr.setText("");
            return true;
        } else {
         /*  cpperroorr.setText(passwordFormat);*/
            confirmpwd.requestFocus();
            return false;
        }
    }

    public static boolean isEmail(EditText emailidedit, TextView emailiderr) {
        // TODO Auto-generated method stub
        String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String em = emailidedit.getText().toString();
        if (em.matches(EMAIL_REGEX)) {
            emailiderr.setText("");
            return true;
        } else {
    /*    emailiderr.setText(emailFormat);*/
            emailiderr.requestFocus();
            return false;
        }
    }

    public static boolean isEmail123(EditText emailidedit) {
        // TODO Auto-generated method stub
        String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String em = emailidedit.getText().toString();
        if (em.matches(EMAIL_REGEX)) {

            return true;
        } else {
           /* emailidedit.setError(emailFormat);*/
            emailidedit.requestFocus();
            return false;
        }
    }


    public static boolean isEmail1(EditText emailidedit, TextView emailid) {
        // TODO Auto-generated method stub
        String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String em = emailidedit.getText().toString();
        if (em.matches(EMAIL_REGEX)) {
            emailid.setText("");
            return true;
        } else {
          /*  emailid.setText(emailFormat);*/
            return false;
        }
    }
    public static boolean isCity(EditText email, TextView emailerror) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
            /*emailerror.setText(cityfrmt);*/
            email.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean isDate1(EditText email, TextView emailerror) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
            emailerror.setText(datefrmt);
            email.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean hasText(EditText email, TextView emailerror) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
          /*  emailerror.setText(REQUIRED_MSG);*/
            email.requestFocus();
            return false;
        }
        return true;
    }
    public static boolean hasText1(EditText email) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
           /* email.setError(REQUIRED_MSG);*/
            email.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean isName(EditText email, TextView emailerror) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
          /*  emailerror.setText(name);*/
            email.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean isTicket(EditText email, TextView emailerror) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
           /* emailerror.setText(ticketmsg);*/
            return false;
        }
        return true;
    }

    public static boolean isBoardingpt(EditText email, TextView emailerror) {
        // Tint len=text.length();ODO Auto-generated method stub
        int len = email.length();
        String em = email.getText().toString();
        if (len == 0) {
           /* emailerror.setText(bordingpt);*/
            return false;
        }
        return true;
    }
}

  /*  public static boolean isEmail1(EditText email, TextView errormail) {
        // TODO Auto-generated method stub
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String em=email.getText().toString();
        if(em.matches(EMAIL_REGEX))
        {
            errormail.setText("");
            return true;
        }
        else
        {
            errormail.setText(emailFormat);
            return false;
        }*//*
    }*/


