package com.example.ap_datastorage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class UserInfo_SharePre {
    //用户数据的存储
    public static boolean saveUserInfo(String username, String password, Context context){
        //获取SharedPreferences对象，同时指定文件名称和访问的权限
        SharedPreferences sp=context.getSharedPreferences("MyData",Context.MODE_PRIVATE);
        //获取到SharedPreferences的编辑对象
        SharedPreferences.Editor editor=sp.edit();
        //通过编辑器进行数据的存储
        editor.putString("Uname",username);
        editor.putString("Pwd",password);
        editor.commit();
        return true;
    }
    //用户数据的读取
    public static Map<String,String> getUserInfo(Context context){
        //获取SharedPreferences对象，同时指定文件名称和访问的权限
        SharedPreferences sp=context.getSharedPreferences("MyData",Context.MODE_PRIVATE);
        String username=sp.getString("Uname","");
        String password=sp.getString("Pwd","");
        Map<String,String> userMap=new HashMap<>();
        userMap.put("Username",username);
        userMap.put("Password",password);
        return userMap;
    }
}
