package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;

/**
 * Created by Guille on 29/8/15.
 */
public class SplashDraw {


    public static float time;


    public static void draw(){


        com.guillocrack.crazymeatball.GameScreen.batch.begin();

        com.guillocrack.crazymeatball.GameScreen.splash.draw(com.guillocrack.crazymeatball.GameScreen.batch);


        time += Gdx.graphics.getDeltaTime();

        if(time > 2.0f){

            GeneralStorage.load();
            com.guillocrack.crazymeatball.MenuStorage.load();

            com.guillocrack.crazymeatball.GameScreen.state = com.guillocrack.crazymeatball.GameScreen.GameState.MENU;

        }

        com.guillocrack.crazymeatball.GameScreen.batch.end();

    }

}
