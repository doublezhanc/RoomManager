package com.ling.roommanger;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class SecondActivity extends Activity {
	ToggleButton[] room = new ToggleButton[30];
	Button b1, b2;
	final boolean[] check = new boolean[30];
	private static final int ITEM1 = Menu.FIRST;
	boolean flag = false;
	boolean stop = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.add);

		room[0] = (ToggleButton) findViewById(R.id.toggleButton1);
		room[1] = (ToggleButton) findViewById(R.id.toggleButton2);
		room[2] = (ToggleButton) findViewById(R.id.toggleButton3);
		room[3] = (ToggleButton) findViewById(R.id.toggleButton4);
		room[4] = (ToggleButton) findViewById(R.id.toggleButton5);
		room[5] = (ToggleButton) findViewById(R.id.toggleButton6);
		room[6] = (ToggleButton) findViewById(R.id.toggleButton7);
		room[7] = (ToggleButton) findViewById(R.id.toggleButton8);
		room[8] = (ToggleButton) findViewById(R.id.toggleButton9);
		room[9] = (ToggleButton) findViewById(R.id.toggleButton10);
		room[10] = (ToggleButton) findViewById(R.id.toggleButton11);
		room[11] = (ToggleButton) findViewById(R.id.toggleButton12);
		room[12] = (ToggleButton) findViewById(R.id.toggleButton13);
		room[13] = (ToggleButton) findViewById(R.id.toggleButton14);
		room[14] = (ToggleButton) findViewById(R.id.toggleButton15);
		room[15] = (ToggleButton) findViewById(R.id.toggleButton16);
		room[16] = (ToggleButton) findViewById(R.id.toggleButton17);
		room[17] = (ToggleButton) findViewById(R.id.toggleButton18);
		room[18] = (ToggleButton) findViewById(R.id.toggleButton19);
		room[19] = (ToggleButton) findViewById(R.id.toggleButton20);
		room[20] = (ToggleButton) findViewById(R.id.toggleButton21);
		room[21] = (ToggleButton) findViewById(R.id.toggleButton22);
		room[22] = (ToggleButton) findViewById(R.id.toggleButton23);
		room[23] = (ToggleButton) findViewById(R.id.toggleButton24);
		room[24] = (ToggleButton) findViewById(R.id.toggleButton25);
		room[25] = (ToggleButton) findViewById(R.id.toggleButton26);
		room[26] = (ToggleButton) findViewById(R.id.toggleButton27);
		room[27] = (ToggleButton) findViewById(R.id.toggleButton28);
		room[28] = (ToggleButton) findViewById(R.id.toggleButton29);
		room[29] = (ToggleButton) findViewById(R.id.toggleButton30);
		

		b1 = (Button) findViewById(R.id.Button1);
		b2 = (Button) findViewById(R.id.Button2);
		Intent intent = getIntent();
		Bundle bundle = intent.getBundleExtra("data");
		final int beginnum = bundle.getInt("begin");
		final int endnum = bundle.getInt("end");

		final int num = endnum - beginnum + 1;

		
		// room[0].set
		for (int i = 0; i < num; i++) {
			int temp = beginnum + i;
			room[i].setText("room:" + temp);
			check[i] = false;
		}
		
			

		for (int i = 0; i < num; i++) {
			final int t = i;
			room[i].setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					// TODO Auto-generated method stub
					if (isChecked) {
						check[t] = true;

					} else {
						check[t] = false;

					}
				}

			});
			
			room[i].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (!check[t]) {
						room[t].setText("room:" + (beginnum + t));
					}
				}
			});

		}

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				flag = false;
				String result = "";
				for (int i = 0; i < num; i++) {
					if (!check[i]) {
						flag = true;
						result = result + (beginnum + i) + "/";
					} else {

					}

				}
				result = result + " 人数不齐";
				AlertDialog.Builder builder = new Builder(SecondActivity.this);
				builder.setTitle("情况统计：");
				if (flag)
					builder.setMessage(result);
				else
					builder.setMessage("全部人齐!");
				builder.setPositiveButton("确定", null);
				builder.setCancelable(true);
				builder.show();
			}

		});

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		menu.add(0, ITEM1, 0, "关于");
		return true;
	}

	@Override
	public void onDestroy() {
		stop = true;
		super.onDestroy();
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ITEM1:
			AlertDialog.Builder builder = new Builder(SecondActivity.this);
			builder.setTitle("关于本软件");
			builder.setMessage("本软件为  张洪超  专为  刘颖  方便查寝制作，在没有获得本人同意前，任何人不得传播使用，否则后果自负！");
			builder.setCancelable(true);
			builder.setPositiveButton("确定", null);
			builder.show();
			break;
		}
		return true;
	}

}
