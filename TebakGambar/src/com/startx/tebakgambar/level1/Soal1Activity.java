package com.startx.tebakgambar.level1;

import com.startx.tebakgambar.R;
import com.startx.tebakgambar.R.drawable;
import com.startx.tebakgambar.R.id;
import com.startx.tebakgambar.R.layout;
import com.startx.tebakgambar.R.menu;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class Soal1Activity extends Activity {
	EditText jawaban;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soal1);
		jawaban=(EditText)findViewById(R.id.isisoal1);
		jawaban.setFilters(new InputFilter[] { new InputFilter.AllCaps()});
		
	}
	public void CekJawaban1(View v){
		String jawabanbenar1 = "MOUSE KOMPUTER";
		String jawabanbenar11 = "MOUSEKOMPUTER";
		String jawabanuser=jawaban.getText().toString();
		if (jawabanuser.equals(jawabanbenar1)){
			Toast.makeText(getApplicationContext(), "Jawaban anda benar", Toast.LENGTH_LONG).show();
			Intent i= new Intent(getApplicationContext(),Soal2Activity.class);
			startActivity(i);
			finish();
		}else if (jawabanuser.equals(jawabanbenar11)){
				Toast.makeText(getApplicationContext(), "Jawaban anda benar", Toast.LENGTH_LONG).show();
				Intent i= new Intent(getApplicationContext(),Soal2Activity.class);
				startActivity(i);
				finish();
		}else if (jawabanuser.trim().equals("")){
			jawaban_kosong();
		}else {
			jawaban_salah();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.soal1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void jawaban_salah(){
		AlertDialog.Builder salah=new AlertDialog.Builder(Soal1Activity.this);
		salah.setTitle("Salah");
		salah.setMessage("Jawaban anda salah");
		salah.setIcon(R.drawable.gagal);
		
		salah.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				jawaban.setText("");
			}
		});
		salah.show();
	}
	public void jawaban_kosong(){
		AlertDialog.Builder kosong=new AlertDialog.Builder(Soal1Activity.this);
		kosong.setTitle("Kosong");
		kosong.setMessage("Jawaban anda masih kosong");
		kosong.setIcon(R.drawable.gagal);
		
		kosong.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				jawaban.requestFocus();
			}
		});
		kosong.show();
	}
	public void backtomenu(){
		AlertDialog.Builder pesan= new AlertDialog.Builder(this);
		pesan.setMessage("Kembali ke menu?")
		.setCancelable(false)
		.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		})
		.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		}).show();
	}
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			if(keyCode==KeyEvent.KEYCODE_BACK){
				backtomenu();
			}
			return super.onKeyDown(keyCode, event);
		}
}
