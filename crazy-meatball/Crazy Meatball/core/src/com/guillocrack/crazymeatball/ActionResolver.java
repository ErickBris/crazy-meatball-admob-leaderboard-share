package com.guillocrack.crazymeatball;

//This interface is used to connect Core code with Android code

public interface ActionResolver {
	public void showOrLoadInterstital();

	public void signIn();

	public void signOut();

	public void submitScore(long score, long games);

	public void showScores();

	public boolean isSignedIn();

	public void share(Integer points);
	
	public void rate();

    public int getBannerHeight();

    public void initializeLeaderboard();

}
