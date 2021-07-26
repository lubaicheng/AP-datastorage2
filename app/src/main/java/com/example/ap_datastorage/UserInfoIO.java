package com.example.ap_datastorage;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserInfoIO {
    //用户数据的写入
    public static boolean saveUserInfo(String username, String password, Context context){
           //openFileOutput(要操作的文件类型，文件的访问模式)
        String msg=null;
        FileOutputStream fos=null;
        try {
            //获取文件输出流对象fos
            fos=context.openFileOutput("MyData.txt",Context.MODE_PRIVATE);
            msg=username+":"+password;
            //getBytes()将字符串转换为0和1样式的字节。
            fos.write(msg.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //用户数据的读取
    public static Map<String,String> getuserInfo(Context context){
        //获取文件输入流
        FileInputStream fis=null;
        try {
            //获取文件输入流对象fis
            fis=context.openFileInput("MyData.txt");
            //将输入流的对象中的数据转换为字节码的形式，fis.available()返回去取文件中数据的长度
            byte[] buffer=new byte[fis.available()];
            //读取的内容存放到buffer里
            fis.read(buffer);
            //将获取的字节码转换为字符串
            String msg=new String(buffer);
            //"2:3:4:5".split(":")//将返回[”2“，”3“，”4“，“5”]，
            //将字符串以”：“分割后形成一个数组的形式
            String[] userinfo=msg.split(":");
            Map<String,String> userMap=new HashMap<>();
            userMap.put("username",userinfo[0]);
            userMap.put("password",userinfo[1]);
            return userMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
