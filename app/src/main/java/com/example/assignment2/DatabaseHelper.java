//package com.example.assignment2;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.renderscript.ScriptGroup;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.security.PublicKey;
//
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//    Context mcontex;
//    String dbName;
//    String dbPath;
//    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, null, version);
//        this.dbName = name;
//        this.mcontex = context;
//        this.dbPath = "data/data/" + "demo.importdatabasedemo" + "/database/";
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//
//    public void CheckDb(){
//        SQLiteDatabase checkDb = null;
//        String filePath = dbPath + dbName;
//        try{
//            checkDb = SQLiteDatabase.openDatabase(filePath,null,0);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if (checkDb != null){
//            Toast.makeText(mcontex, "database alrrady exists", Toast.LENGTH_SHORT).show();
//        }else{
//            CopyDatabase();
//        }
//    }
//    public void CopyDatabase(){
//        this.getReadableDatabase();
//        try{
//            InputStream ios = mcontex.getAssets().open(dbName);
//            OutputStream os = new FileOutputStream(dbName + dbPath);
//
//            byte[] buffer = new byte[1024];
//
//            int len;
//            while ((len = ios.read(buffer) > 0)){
//                os.write(buffer, 0, len);
//            }
//            os.flush();
//            ios.close();
//            os.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Log.d("CopyDb", "Database Copied");
//    }
//    public void OpenDatabase(){
//        String filePath = dbPath + dbName;
//        SQLiteDatabase.openDatabase(filePath, null,0);
//
//        databaseHelper = new DatabaseHelper(this, )
//    }
//}
