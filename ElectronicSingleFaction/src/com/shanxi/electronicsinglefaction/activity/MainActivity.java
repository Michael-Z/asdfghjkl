package com.shanxi.electronicsinglefaction.activity;

import com.shanxi.electronicsinglefaction.R;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements
OnCheckedChangeListener {
private RadioButton lastRadioButton;
private TabHost mHost;
private RadioButton radioButton0;
private RadioButton radioButton2;
private RadioButton radioButton3;
private RadioButton radioButton5;
private RadioGroup radioderGroup;
EditText mSearchText;
ImageButton mSearchButton;
LinearLayout mSearchLinear;

public void getButtonDrawable(RadioButton paramRadioButton) {
}

public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
switch (paramInt) {
case R.id.radio_button0:
	this.mHost.setCurrentTabByTag("ONE");
	this.radioButton0.setBackgroundResource(R.drawable.cm_ck_home_btn_bg_s);
	this.lastRadioButton = this.radioButton0;
	return;
case R.id.radio_button2:
	this.radioButton0
			.setBackgroundResource(R.drawable.cm_ck_toolbar_bkg);
	this.lastRadioButton = this.radioButton2;
	this.mHost.setCurrentTabByTag("THREE");
	return;
case R.id.radio_button3:
	this.radioButton0.setBackgroundResource(R.drawable.cm_ck_toolbar_bkg);
	this.lastRadioButton = this.radioButton3;
	this.mHost.setCurrentTabByTag("FOUR");
	return;
case R.id.radio_button5:
	this.radioButton0.setBackgroundResource(R.drawable.cm_ck_toolbar_bkg);
	this.mHost.setCurrentTabByTag("SIX");
	return;
default:
	return;
}
}

@Override
public void onCreate(Bundle paramBundle) {
super.onCreate(paramBundle);
setContentView(R.layout.main);

this.mHost = getTabHost();
this.mHost.addTab(this.mHost.newTabSpec("ONE").setIndicator("ONE")
		.setContent(new Intent(this, TaskActivity.class)));
this.mHost.addTab(this.mHost.newTabSpec("THREE").setIndicator("THREE")
		.setContent(new Intent(this, AboutActivity.class)));
this.mHost.addTab(this.mHost.newTabSpec("FOUR").setIndicator("FOUR")
		.setContent(new Intent(this, ColleaguesPositionActivity.class)));
this.mHost.addTab(this.mHost.newTabSpec("SIX").setIndicator("SIX")
		.setContent(new Intent(this, SystemMessageActivity.class)));
this.radioButton0 = ((RadioButton) findViewById(getResources()
		.getIdentifier("radio_button0", "id", getPackageName())));
this.radioButton2 = ((RadioButton) findViewById(getResources()
		.getIdentifier("radio_button2", "id", getPackageName())));
this.radioButton3 = ((RadioButton) findViewById(getResources()
		.getIdentifier("radio_button3", "id", getPackageName())));
this.radioButton5 = ((RadioButton) findViewById(getResources()
		.getIdentifier("radio_button5", "id", getPackageName())));
this.radioderGroup = ((RadioGroup) findViewById(getResources()
		.getIdentifier("cm_ck_main_radio", "id", getPackageName())));
this.lastRadioButton = this.radioButton0;
this.radioderGroup.setOnCheckedChangeListener(this);

}

//提示用户网络异常	
public void alertNetError(final Context context)
{
AlertDialog.Builder ab=new AlertDialog.Builder(context);
ab.setTitle("网络异常");
ab.setMessage("网络连接异常，请设置网络或退出程序");
ab.setPositiveButton("设置网络", new DialogInterface.OnClickListener() {
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		context.startActivity(new 
	             Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)); 
	    dialog.cancel();
	}
});
ab.setNegativeButton("退出程序", new DialogInterface.OnClickListener() {
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
	    android.os.Process.killProcess(android.os.Process.myPid());
	}
});
ab.create().show();
}

}
