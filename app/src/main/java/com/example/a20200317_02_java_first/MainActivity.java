package com.example.a20200317_02_java_first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20200317_02_java_first.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("버튼클릭", "입력 버튼 눌림");

                String input = binding.inputTxt.getText().toString();

                Log.d("입력값 확인", input);

                binding.appearTxt.setText(input);
                binding.inputTxt.setText("");

                binding.loginBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pw = binding.pwTxt.getText().toString();

                        if(pw.equals("1234")) {
                            Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "잘못된 비번입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
