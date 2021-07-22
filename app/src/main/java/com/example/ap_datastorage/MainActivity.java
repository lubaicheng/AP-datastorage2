package com.example.ap_datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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