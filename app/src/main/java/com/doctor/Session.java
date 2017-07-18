package com.doctor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session
{

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
       
    }
public boolean iscontain(String key)	
{
	return prefs.contains(key);
}

    public void setUserId(int userid) {
        prefs.edit().putInt("userid",userid).commit();

    }
    public int getUserId()
    {
        int userid = prefs.getInt("userid",0);
        return userid;
    }
    public void setPassword(String password) {
        prefs.edit().putString("password", password).commit();

    }
    public String getPassword() {
        String password = prefs.getString("password","");
        return password;
    }
    public void setUsername(String usename) {
        prefs.edit().putString("username", usename).commit();

    }
    public String getUsername() {
        String usename = prefs.getString("username","");
        return usename;
    }
    public void setMailid(String mailid) {
        prefs.edit().putString("mailid", mailid).commit();

    }
    public String getMailid() {
        String usename = prefs.getString("mailid","");
        return usename;
    }



    public void setAdminUserId(int userid) {
        prefs.edit().putInt("userid",userid).commit();

    }
    public int getAdminUserId()
    {
        int userid = prefs.getInt("userid",0);
        return userid;
    }
    public void setAdminPassword(String password) {
        prefs.edit().putString("password", password).commit();

    }
    public String getAdminPassword() {
        String password = prefs.getString("password","");
        return password;
    }
    public void setAdminUsername(String usename) {
        prefs.edit().putString("username", usename).commit();

    }
    public String getAdminUsername() {
        String usename = prefs.getString("username","");
        return usename;
    }
    public void setAdminMailid(String mailid) {
        prefs.edit().putString("mailid", mailid).commit();

    }
    public String getAdminMailid() {
        String usename = prefs.getString("mailid","");
        return usename;
    }
    public void setDob(String dob) {
        prefs.edit().putString("dob", dob).commit();

    }
    public String getDob() {
        String usename = prefs.getString("dob","");
        return usename;
    }
    public void setGender(String gender) {
        prefs.edit().putString("gender", gender).commit();

    }
    public String getGender() {
        String usename = prefs.getString("gender","");
        return usename;
    }
    public void setLogin(String login) {
        prefs.edit().putString("login", login).commit();

    }
    public String getLogin() {
        String usename = prefs.getString("login","");
        return usename;
    }

   /* public  void setRegid(String regid)
    {
        prefs.edit().putString("regid", regid).commit();
    }
    public void setUsername(String usename) {
        prefs.edit().putString("username", usename).commit();
        
    }
    public void setRegion(int region) {
        prefs.edit().putInt("region", region).commit();
        
    }
    public void setCountry(String country) {
        prefs.edit().putString("country", country).commit();
        
    }
    public void setCitynames(String citynames) {
        prefs.edit().putString("citynames", citynames).commit();
        
    }

    public void setTv2(String text) {
        prefs.edit().putString("text", text).commit();
        
    }
    public String getRegid()
    {
        String regid=prefs.getString("regid","");
        return  regid;
    }
    public String getTv2() {
        String usename = prefs.getString("text","");
        return usename;
    }
    public String getUsername() {
        String usename = prefs.getString("username","");
        return usename;
    }
    public int getRegion() {
        int region = prefs.getInt("region", 2);
        return region;
    }
    public String getCityNames() {
        String citynames = prefs.getString("citynames","");
        return citynames;
    }
    public String getCountry() {
        String country = prefs.getString("country","India");
        return country;
    }
    public String getPassword() {
        String password = prefs.getString("password","");
        return password;
    }
    public void setCity(String key,String value) {
        prefs.edit().putString(key,value).commit();
        
    }
    public String getCity(String key) {
        String usename = prefs.getString(key,"");
        return usename;
    }
    public void setfname(String key,String value) {
        prefs.edit().putString(key,value).commit();

    }
    public String getfname(String key) {
        String fname = prefs.getString(key,"");
        return fname;
    }*/
}
