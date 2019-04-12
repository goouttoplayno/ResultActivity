package com.example.resultactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText one, two, result;
    private Button button;
    private final static int REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        one = (EditText)findViewById(R.id.Text_one);
        two = (EditText)findViewById(R.id.Text_two);
        result = (EditText)findViewById(R.id.Text_result);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

//    　　第一个参数：这个整数requestCode用于与startActivityForResult中的requestCode中值进行比较判断，是以便确认返回的数据是从哪个Activity返回的。
//        第二个参数：这整数resultCode是由子Activity通过其setResult()方法返回。适用于多个activity都返回数据时，来标识到底是哪一个activity返回的值。
//        第三个参数：一个Intent对象，带有返回的数据。可以通过data.getXxxExtra( );方法来获取指定数据类型的数据，
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2){
            if (requestCode == REQUESTCODE){
                int three = data.getIntExtra("three", 0);
                result.setText(String.valueOf(three));
            }
        }
    }

    @Override
    public void onClick(View v) {
        int a = Integer.parseInt(one.getText().toString());
        int b = Integer.parseInt(two.getText().toString());

        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        startActivityForResult(intent, REQUESTCODE);
//        第一个参数：一个Intent对象，用于携带将跳转至下一个界面中使用的数据，使用putExtra(A,B)方法，此处存储的数据类型特别多，基本类型全部支持。
//　　    第二个参数：如果> = 0,当Activity结束时requestCode将归还在onActivityResult()中。以便确定返回的数据是从哪个Activity中返回，用来标识目标activity
    }
}
