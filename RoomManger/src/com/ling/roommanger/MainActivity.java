package com.ling.roommanger;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	TextView tx;
	Button b1;
	EditText begin, end;
	int beginnum;
	int endnum;
	SharedPreferences preference;
	SharedPreferences.Editor editor;
	private static final int ITEM1 = Menu.FIRST;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		begin = (EditText) findViewById(R.id.editText1);
		end = (EditText) findViewById(R.id.editText2);
		b1 = (Button) findViewById(R.id.button2);

		preference = getSharedPreferences("data", MODE_PRIVATE);
		editor = preference.edit();
		beginnum = preference.getInt("begin", 0);
		endnum = preference.getInt("end", 0);

		begin.setText("" + beginnum);
		end.setText("" + endnum);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				beginnum = Integer.parseInt(begin.getText().toString());
				endnum = Integer.parseInt(end.getText().toString());
				int num = endnum - beginnum+1;
				if (num < 0 ||num > 30) {
					AlertDialog.Builder builder = new Builder(MainActivity.this);
					builder.setTitle("无法支持的数量");
					builder.setMessage("针对您输入的房间编号，本程序无法支持。。。");
					builder.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									begin.setText("");
									end.setText("");
								}
							});
					builder.setCancelable(true);
					builder.show();

				} else {
					Intent intent = new Intent(MainActivity.this,
							SecondActivity.class);
					Bundle b = new Bundle();
					b.putInt("begin", beginnum);
					b.putInt("end", endnum);
					intent.putExtra("data", b);
					startActivity(intent);
					finish();
				}

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
		super.onDestroy();

		preference = getSharedPreferences("data", MODE_PRIVATE);
		editor = preference.edit();
		editor.putInt("begin", beginnum);
		editor.putInt("end", endnum);
		editor.commit();
		// Log.i("LICH","Dest");

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ITEM1:
			AlertDialog.Builder builder = new Builder(MainActivity.this);
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
