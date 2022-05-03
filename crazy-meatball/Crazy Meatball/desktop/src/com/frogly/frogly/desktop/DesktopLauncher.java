package com.frogly.frogly.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.guillocrack.crazymeatball.ActionResolver;
import com.guillocrack.crazymeatball.GameScreen;

public class DesktopLauncher implements ActionResolver {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GameScreen(this), config);
	}

	@Override
	public void showOrLoadInterstital() {

	}

	@Override
	public void signIn() {

	}

	@Override
	public void signOut() {

	}

	@Override
	public void submitScore(long score) {

	}

	@Override
	public void showScores() {

	}

	@Override
	public boolean isSignedIn() {
		return false;
	}

	@Override
	public void share(Integer points) {

	}

	@Override
	public void rate() {

	}

	@Override
	public int getBannerHeight() {
		return 0;
	}

	@Override
	public void initializeLeaderboard() {

	}
}
