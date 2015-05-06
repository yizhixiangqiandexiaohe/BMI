package com.stx.bmi;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText et_tall;
	private EditText et_weight;
	private long exitTime = 0;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_tall = (EditText) findViewById(R.id.et_tall);
		et_weight = (EditText) findViewById(R.id.et_weight);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void show(View view) {
		try {
			// 1.去除输入框中的值
			String inputTall = et_tall.getText().toString();
			String inputWeight = et_weight.getText().toString();
			// 2.数据转换
			float parseTall = Float.parseFloat(inputTall);
			int weight = Integer.parseInt(inputWeight);
			float tall = parseTall / 100;
			// 3.计算BMI指数
			float bmi = weight / (tall * tall);
			System.out.println(bmi);
			if (bmi < 18.5) {
				new AlertDialog.Builder(MainActivity.this).setTitle("大肖提醒您：")
						.setMessage("您的体型偏瘦，注意增加营养哦~").setPositiveButton("确定", null)
						.create().show();
			}else if(bmi>24.9){
				new AlertDialog.Builder(MainActivity.this).setTitle("大肖提醒您：")
				.setMessage("您的体型偏胖，需要加强锻炼哦~").setPositiveButton("确定", null)
				.create().show();
			}else{
				new AlertDialog.Builder(MainActivity.this).setTitle("大肖提醒您：")
				.setMessage("您的体型不错哦，请继续保持~").setPositiveButton("确定", null)
				.create().show();
			}
		} catch (Exception e) {
			new AlertDialog.Builder(MainActivity.this).setTitle("提示：")
					.setMessage("请正确输入!!!").setPositiveButton("确定", null)
					.create().show();
		}
	}
	  
	@Override  
	    public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        if (keyCode == KeyEvent.KEYCODE_BACK  
	                && event.getAction() == KeyEvent.ACTION_DOWN) {  
	  
	            if ((System.currentTimeMillis() - exitTime) > 2000) {  
	                Toast.makeText(getApplicationContext(), "再按一次退出程序",  
	                        Toast.LENGTH_SHORT).show();  
	                exitTime = System.currentTimeMillis();  
	            } else {  
	                finish();  
	                System.exit(0);  
	            }  
	            return true;  
	        }  
	        return super.onKeyDown(keyCode, event);  
	    }   
}
