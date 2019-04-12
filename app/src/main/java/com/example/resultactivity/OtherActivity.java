package com.example.resultactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);

        initView();
        Intent intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        textView.setText(a + " + " + b + " = " + " ? ");
    }

    private void initView() {
        button = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.msg);
        editText = (EditText)findViewById(R.id.Test_three);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        int three = Integer.parseInt(editText.getText().toString());
        intent.putExtra("three", three);
//    在意图跳转的目的地界面调用这个方法把Activity想要返回的数据返回到主Activity，
//　　第一个参数：当Activity结束时resultCode将归还在onActivityResult()中，一般为RESULT_CANCELED , RESULT_OK该值默认为-1。
//　　第二个参数：一个Intent对象，返回给主Activity的数据。在intent对象携带了要返回的数据，使用putExtra( )方法

        setResult(2, intent);
        finish();
    }
}
