package cn.edu.gdmec.android.myapplication.utils;



        import android.content.Context;
        import android.content.SharedPreferences;

public class AnalysisUtils {
    //从SharedPreferences中读取登录用户名
    public static String readLoginUserName(Context context){
        SharedPreferences sp = context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        String userName = sp.getString("loginUserName","");
        return userName;
    }

    public static boolean readLoginStatus(Context context){
        SharedPreferences sp = context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        Boolean isLogin = sp.getBoolean("isLogin",false);
        return isLogin;
    }
    public static void clearLoginStatus(Context context){
        SharedPreferences sp = context.getSharedPreferences("islogin",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("islogin",false);
        editor.putString("loginUserName","");
    }
}