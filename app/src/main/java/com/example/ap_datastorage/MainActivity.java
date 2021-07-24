package com.example.ap_datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button registerBtn,loginBtn;
    private EditText et_UserName,et_PassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提取编辑框中输入的用户名和密码，将它们写入到文件中。
                String Uname=et_UserName.getText().toString();
                String Pwd=et_PassWord.getText().toString();
                if(UserInfoIO.saveUserInfo(Uname,Pwd,MainActivity.this)){
                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                }
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Uname=et_UserName.getText().toString();
                String Pwd=et_PassWord.getText().toString();
                Map<String,String> userMap=UserInfoIO.getuserInfo(MainActivity.this);
                if(Uname.equals(userMap.get("username"))&&Pwd.equals(userMap.get("password"))){
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void init() {
        registerBtn=findViewById(R.id.register);
        loginBtn=findViewById(R.id.login);
        et_UserName=findViewById(R.id.Uname);
        et_PassWord=findViewById(R.id.Pwd);
    }
}