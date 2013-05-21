package com.shanxi.electronicsinglefaction.activity;

import com.shanxi.electronicsinglefaction.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class TaskActivity extends TabActivity
implements RadioGroup.OnCheckedChangeListener
{
private RadioButton lastRadioButton;
private TabHost mHost;
private RadioGroup radioderGroup;
private RadioButton ratingButton0;
private RadioButton ratingButton1;
private RadioButton ratingButton2;

public void getBackgroup(RadioButton paramRadioButton)
{
  paramRadioButton.setBackgroundColor(Color.TRANSPARENT);
}

public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
{
  switch (paramInt)
  {
  default:
    return;
  case R.id.music_radio_button0:
    this.mHost.setCurrentTabByTag("RECOMMENDONE");
    getBackgroup(this.lastRadioButton);
    this.lastRadioButton = this.ratingButton0;
    this.lastRadioButton.setBackgroundResource(R.drawable.cm_ck_top_represent);
    return;
  case R.id.music_radio_button1:

  this.mHost.setCurrentTabByTag("RECOMMENDTWO");
  getBackgroup(this.lastRadioButton);
  this.lastRadioButton = this.ratingButton1;
  this.lastRadioButton.setBackgroundResource(R.drawable.cm_ck_top_represent);
  return;
  case R.id.music_radio_button2:
	  this.mHost.setCurrentTabByTag("RECOMMENDTHREE");
	  getBackgroup(this.lastRadioButton);
	  this.lastRadioButton = this.ratingButton2;
	  this.lastRadioButton.setBackgroundResource(R.drawable.cm_ck_top_represent);
	  return;
  }
}

protected void onCreate(Bundle paramBundle)
{
  super.onCreate(paramBundle);
  setContentView(R.layout.task_tab);
  this.mHost = getTabHost();
  this.mHost.addTab(this.mHost.newTabSpec("RECOMMENDONE").setIndicator("RECOMMENDONE").setContent(new Intent(this, NewTaskActivity.class)));
  this.mHost.addTab(this.mHost.newTabSpec("RECOMMENDTWO").setIndicator("RECOMMENDTWO").setContent(new Intent(this, StartTaskActivity.class)));
  this.mHost.addTab(this.mHost.newTabSpec("RECOMMENDTHREE").setIndicator("RECOMMENDTHREE").setContent(new Intent(this, FinishActivity.class)));
  this.radioderGroup = ((RadioGroup)findViewById(R.id.music_radio));
  this.ratingButton0 = ((RadioButton)findViewById(R.id.music_radio_button0));
  this.ratingButton1 = ((RadioButton)findViewById(R.id.music_radio_button1));
  this.ratingButton2 = ((RadioButton)findViewById(R.id.music_radio_button2));
  this.lastRadioButton = this.ratingButton0;
  this.radioderGroup.setOnCheckedChangeListener(this);
}
}
