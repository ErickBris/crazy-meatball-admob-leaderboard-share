package com.guillocrack.crazymeatball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ApplicationAdapter {

	public enum GameState{SPLASH, MENU, RUNNING, GAMEOVER, PAUSE}

	public static GameState state;

	public static ActionResolver actionResolver;

	public static Sprite splash;

	public static SpriteBatch batch;

	public GameScreen(ActionResolver a){

		actionResolver = a;
	}

	@Override
	public void create () {

		batch = new SpriteBatch();

		Texture t = new Texture("splash.png");
		t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		splash = new Sprite(t);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		splash.setPosition(0, 0);

		SplashDraw.time = 0.0f;

		state = GameState.SPLASH;




	}

	@Override
	public void render() {

		switch (state){

			case SPLASH:

				SplashDraw.draw();

				break;

			case MENU:

				MenuUpdate.update();

				MenuDraw.draw();

				break;


			case RUNNING:

				RunningDraw.draw();

				RunningUpdate.update();



				break;


			case GAMEOVER:

			GameOverDraw.draw();


				break;


			case PAUSE:

				PauseUpdate.update();

				PauseDraw.draw();

		}



	}

}






