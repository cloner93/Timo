package com.example.cloner93.time_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

public class Db extends SQLiteOpenHelper {
    ArrayList<HashMap<String,String>> projectlist;
    public Db(Context context)
    {
        super(context, "DB1.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table tbl_a (t_date varchar(20),t_nakh varchar(20),t_price varchar(20),t_day varchar(20),t_month varchar(20),t_dayW varchar(20),t_grop varchar(2))"
        );
        db.execSQL(
                "create table tbl_b (t_date varchar(20),t_nakh varchar(20),dd varchar(5))"
        );
        db.execSQL(
                "create table tbl_wall (t_date varchar(80))"
        );
        Log.i("DATABASE IS CREATE", "oooooooooo");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tbl_user");
        onCreate(db);
    }
    public boolean insertTb1 (String t_d,String t_n,String t_p,String t_da,String t_m,String t_dw,String t_g)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("t_date", t_d);
        contentValues.put("t_nakh", t_n);
        contentValues.put("t_price", t_p);
        contentValues.put("t_day", t_da);
        contentValues.put("t_month", t_m);
        contentValues.put("t_dayW", t_dw);
        contentValues.put("t_grop", t_g);

        db.insert("tbl_a", null, contentValues);
        return true;
    }
    public boolean insertTb2 (String Id,String p,String d)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("t_date", Id);
        contentValues.put("t_nakh", p);
        contentValues.put("dd", d);
        db.insert("tbl_b", null, contentValues);
        return true;
    }
    public boolean insertTb3 (String Id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("t_date", Id);
        db.insert("tbl_wall", null, contentValues);
        return true;
    }
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete("tbl_a", null, null);
        db.close();

        Log.d("tbll", "Deleted all user info from sqlite");
    }
    public void deleteUp() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete("tbl_wall", null, null);
        db.close();

        Log.d("tbll", "Deleted all user info from sqlite");
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "tbl_a");
        return numRows;
    }
    public int numberOfRows4(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "tbl_b");
        return numRows;
    }
    public int numberOfRows2(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "tbl_wall");
        return numRows;
    }
    public Integer deltb1 (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tb2", "id=?", new String[]{Integer.toString(id)});
        return db.delete("tb1",
                "id = ? ",
                new String[] { Integer.toString(id) });

    }
    public Integer deltb2(Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tb2",
                "idd = ? ",
                new String[] { Integer.toString(id) });
    }
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM  tbl_a" ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("t_date", cursor.getString(0));
            user.put("t_nakh", cursor.getString(1));
            user.put("t_price", cursor.getString(2));
            user.put("t_day", cursor.getString(3));
            user.put("t_month", cursor.getString(4));
            user.put("t_dayW", cursor.getString(5));
            user.put("t_grop", cursor.getString(6));



        }
        cursor.close();
        db.close();
        // return user
        Log.d("tag", "Fetching user from Sqlite: " + user.toString());

        return user;
    }
    public  int iso(String s){
        String selectQuery = "SELECT  * FROM  tbl_b where dd="+s;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return 0;
        }
        return 1;
    }
    public ArrayList<HashMap<String,String>> getaward() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM  tbl_b" ;
        projectlist=new ArrayList<HashMap<String,String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.moveToFirst()) {
            do {
                user.put("name", cursor.getString(0));
                user.put("img", cursor.getString(1));
                projectlist.add(user);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        // return user
        Log.d("tag", "Fetching user from Sqlite: " + user.toString());

        return projectlist;
    }
    public ArrayList<String> getAllCotacts()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from tbl_wall", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(0));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<HashMap<String,String>> getmass() {

        String selectQuery = "SELECT  * FROM  tbl_wall" ;
        projectlist=new ArrayList<HashMap<String,String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> user = new HashMap<String, String>();
                user.put("mass", cursor.getString(0));
                Log.d("tag", "Fetching user from Sqlite: " + user.toString());
                projectlist.add(user);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        // return user
        //Log.d("tag", "Fetching user from Sqlite: " + user.toString());

        return projectlist;
    }
    public  String [] getAll2(){
        String tt;
        int count=0;
        SQLiteDatabase oo = this.getReadableDatabase();
        Cursor pa =  oo.rawQuery( "select * from tbl_wall", null );
        String [] items = new String[pa.getCount()];
        if(pa.moveToFirst()){
            do{
                String lis=pa.getString(0);
                items[count]=lis;
                count++;

            }while(pa.moveToNext());
            pa.close();
        }

        return items;
    }
    public  String [] getAll1() {
        String tt;
        int count = 0;
        SQLiteDatabase oo = this.getReadableDatabase();
        Cursor pa = oo.rawQuery("select * from tbl_b", null);
        String[] items = new String[pa.getCount()];
        if (pa.moveToFirst()) {
            do {
                String lis = pa.getString(0);
                items[count] = lis;
                count++;

            } while (pa.moveToNext());
            pa.close();
        }

        return items;
    }
    public  String [] getAll11() {
        String tt;
        int count = 0;
        SQLiteDatabase oo = this.getReadableDatabase();
        Cursor pa = oo.rawQuery("select * from tbl_b", null);
        String[] items = new String[pa.getCount()];
        if (pa.moveToFirst()) {
            do {
                String lis = pa.getString(1);
                items[count] = lis;
                count++;

            } while (pa.moveToNext());
            pa.close();
        }

        return items;
    }
    public int getProCount(String id) {
        String countQuery = "SELECT  * FROM tbl_pro WHERE pid='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

}
