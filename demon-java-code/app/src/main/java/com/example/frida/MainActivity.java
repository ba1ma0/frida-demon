package com.example.frida;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        System.out.println("开始等待监听事件");
        //监听普通方法
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击按钮1时触发点击事件
                System.out.println("成功监听到了普通方法");
                Toast.makeText(MainActivity.this,String.valueOf(Utils.getCalc(1234,4444)),Toast.LENGTH_LONG).show();
            }
        });
        //监听构造方法
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击按钮2时触发点击事件
                System.out.println("成功监听到了构造方法");
                Toast.makeText(MainActivity.this,Utils.getMoney().getInfo(),Toast.LENGTH_LONG).show();
            }
        });
        //监听重载方法
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //点击按钮3时触发点击事件
                System.out.println("成功监听到了重载方法");
                Toast.makeText(MainActivity.this,Utils.test(1234),Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
