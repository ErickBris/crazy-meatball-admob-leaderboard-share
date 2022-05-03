package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

/**
 * Created by Guille on 28/7/15.
 */
public class RunningUpdate {

    public static int last_send, possible_crash, score;

    public static float pixels_fall;

    public static FPSLogger logger;

    public static void update() {


        pixels_fall = GeneralStorage.pixels_second_fall * Gdx.graphics.getDeltaTime();

        //If pause button has been pressed
        if(Gdx.input.getX()>=GeneralStorage.pause_sprite.getX() && Gdx.input.getX()
                <=GeneralStorage.pause_sprite.getX() + GeneralStorage.pause_sprite.getWidth() &&
                Gdx.input.getY()>=GeneralStorage.h - GeneralStorage.pause_sprite.getY()
                        - GeneralStorage.pause_sprite.getHeight() && Gdx.input.getY()<= GeneralStorage.h - GeneralStorage.pause_sprite.getY())
            GameScreen.state = GameScreen.GameState.PAUSE;

        GeneralStorage.meatball.move();


        for(Obstacle obstacle: GeneralStorage.obstacles) {
            obstacle.move();

        }


        GeneralStorage.meatball.check_colision();

        if(GeneralStorage.obstacles.get(last_send).rectangles.get(0).sp.getY() <= GeneralStorage.h - GeneralStorage.separation_obstacles){

            if(last_send == GeneralStorage.obstacles.size()-1)
                last_send = 0;
            else last_send ++;

            GeneralStorage.obstacles.get(last_send).moving = true;

        }

        GeneralStorage.obstacles.get(possible_crash).change_possible();


    }


    public static void increase_difficulty(){

        if(score%7 == 0)
            if(GeneralStorage.time_fall > 1.7f){
                GeneralStorage.time_fall -= 0.1f;
                GeneralStorage.pixels_second_fall = GeneralStorage.h/GeneralStorage.time_fall;
            }




    }


    public static void prepare_game(){

        score = 0;


        for(int i=0; i<GeneralStorage.obstacles.size(); i++){

            GeneralStorage.obstacles.get(i).initilize_rectangles();

        }

        GeneralStorage.obstacles.get(0).moving = true;

        last_send = 0;

        possible_crash = 0;

        GeneralStorage.meatball.initialize();

        GeneralStorage.time_fall = 2.4f;

        GeneralStorage.pixels_second_fall = GeneralStorage.h/GeneralStorage.time_fall;

        GeneralStorage.smoke1.reset();

        GeneralStorage.boom1.setPosition(10000, 10000);
        GeneralStorage.boom2.setPosition(10000,10000);
        GeneralStorage.boom3.setPosition(10000,10000);

    }


    public static void finish_game(){


        GameScreen.state = GameScreen.GameState.GAMEOVER;
        GameOverDraw.time = GameOverDraw.time_original;

        if(score > GeneralStorage.prefs.getInteger("best",0)) {
            GeneralStorage.prefs.putInteger("best", score);
        }

        GeneralStorage.prefs.putInteger("games",GeneralStorage.prefs.getInteger("games", 0) + 1);
        GeneralStorage.prefs.flush();

        GameScreen.actionResolver.submitScore(score, GeneralStorage.prefs.getInteger("games",0));

    }


}