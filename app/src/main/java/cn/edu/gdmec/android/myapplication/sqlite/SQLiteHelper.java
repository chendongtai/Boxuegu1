package cn.edu.gdmec.android.myapplication.sqlite;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import android.os.Build;





public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 3;
    public static String DB_NAME="bxg.db";
    public static final String U_USERINFO = "userinfo";
    public static final String U_VIDEO_PLAY_LIST = "videoplaylist";
    public SQLiteHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建个人信息表
        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_USERINFO + "("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"userName VARCHAR, "   // 用户名
                +"nickName VARCHAR, "   //昵称
                +"sex VARCHAR, "        //性别
                +"signature VARCHAR,"    //签名
                +"qq VARCHAR"//qq
                +")");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_VIDEO_PLAY_LIST + "("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"userName VARCHAR, "
                +"chapterId INT, "
                +"videoId INT, "
                +"videoPath VARCHAR, "
                +"title VARCHAR, "
                +"secondTitle VARCHAR"
                +")");
    }//当数据库版本号增加时才会调用下面的方法

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ U_USERINFO);
        db.execSQL("DROP TABLE IF EXISTS "+ U_VIDEO_PLAY_LIST);
        onCreate(db);
    }
}