package com.sunnyrao.game2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int score = 0;
	private TextView  tvScore;
	
	private static MainActivity mainActivity = null;
	
	public static MainActivity getMainActivity() {
		return mainActivity;
	}
	
	public MainActivity() {
		mainActivity = this;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		tvScore = (TextView) findViewById(R.id.tvScore);
	}
	
	public void clearScore(){
		score = 0;
		showScore();
	}
	
	public void addScore(int s){
		score += s;
		showScore();
	}
	
	private void showScore(){
		tvScore.setText(score+"");
	}	
}
