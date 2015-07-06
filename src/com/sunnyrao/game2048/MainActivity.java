package com.sunnyrao.game2048;

import com.sunnyrao.game2048.view.AnimLayer;
import com.sunnyrao.game2048.view.GameView;

import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int score = 0;
	private TextView tvScore, tvBestScore;
	private LinearLayout root = null;
	private Button btnNewGame;
	private GameView gameView;
	private AnimLayer animLayer = null;

	private static MainActivity mainActivity = null;
	public static final String SP_KEY_BEST_SCORE = "bestScore";

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
		root = (LinearLayout) findViewById(R.id.container);
		root.setBackgroundColor(0xfffaf8ef);

		tvScore = (TextView) findViewById(R.id.tvScore);
		tvBestScore = (TextView) findViewById(R.id.tvBestScore);
		gameView = (GameView) findViewById(R.id.gameView);

		btnNewGame = (Button) findViewById(R.id.btnNewGame);
		btnNewGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameView.startGame();
			}
		});

		animLayer = (AnimLayer) findViewById(R.id.animLayer);
	}

	public void clearScore() {
		score = 0;
		showScore();
	}

	public void addScore(int s) {
		score += s;
		showScore();
		int maxScore = Math.max(score, getBestScore());
		saveBestScore(maxScore);
		showBestScore(maxScore);
	}

	public void saveBestScore(int s) {
		Editor e = getPreferences(MODE_PRIVATE).edit();
		e.putInt(SP_KEY_BEST_SCORE, s);
		e.commit();
	}

	public int getBestScore() {
		return getPreferences(MODE_PRIVATE).getInt(SP_KEY_BEST_SCORE, 0);
	}

	public void showBestScore(int s) {
		tvBestScore.setText(s + "");
	}

	public AnimLayer getAnimLayer() {
		return animLayer;
	}

	private void showScore() {
		tvScore.setText(score + "");
	}
}
