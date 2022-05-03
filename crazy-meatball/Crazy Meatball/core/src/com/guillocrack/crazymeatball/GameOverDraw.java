package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Guille on 29/8/15.
 */
public class GameOverDraw {

    public static GlyphLayout layout;
    public static float time_original = 1.8f, time;

    public static void draw(){


        Gdx.gl.glClearColor(com.guillocrack.crazymeatball.GeneralStorage.background_color.r, com.guillocrack.crazymeatball.GeneralStorage.background_color.g, com.guillocrack.crazymeatball.GeneralStorage.background_color.b,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        com.guillocrack.crazymeatball.GeneralStorage.batch.begin();


        com.guillocrack.crazymeatball.GeneralStorage.meatball.draw();

        if(layout == null)
            layout = new GlyphLayout();

        layout.setText(com.guillocrack.crazymeatball.GeneralStorage.scoreFont, String.valueOf(RunningUpdate.score));


        //Drawing score
        com.guillocrack.crazymeatball.GeneralStorage.scoreFont.draw(com.guillocrack.crazymeatball.GeneralStorage.batch, String.valueOf(RunningUpdate.score),
                (com.guillocrack.crazymeatball.GeneralStorage.w - layout.width) / 2, (float) (com.guillocrack.crazymeatball.GeneralStorage.h * 0.95));





        for(com.guillocrack.crazymeatball.Obstacle obstacle: com.guillocrack.crazymeatball.GeneralStorage.obstacles) {
            obstacle.draw();

        }

        com.guillocrack.crazymeatball.GeneralStorage.boom1.draw(com.guillocrack.crazymeatball.GeneralStorage.batch, Gdx.graphics.getDeltaTime());
        com.guillocrack.crazymeatball.GeneralStorage.boom2.draw(com.guillocrack.crazymeatball.GeneralStorage.batch, Gdx.graphics.getDeltaTime());
        com.guillocrack.crazymeatball.GeneralStorage.boom3.draw(com.guillocrack.crazymeatball.GeneralStorage.batch, Gdx.graphics.getDeltaTime());

        com.guillocrack.crazymeatball.GeneralStorage.batch.end();


        time -= Gdx.graphics.getDeltaTime();
        if(time<0) {
            com.guillocrack.crazymeatball.GameScreen.state = com.guillocrack.crazymeatball.GameScreen.GameState.MENU;

            //Showing the interstitial after 0.3 seconds
            if (MathUtils.random(0, 101) <= com.guillocrack.crazymeatball.C.interstitial_percentage) {


                //Showing interstitial
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        // Do your work
                        com.guillocrack.crazymeatball.GameScreen.actionResolver.showOrLoadInterstital();
                    }
                }, (float) 0.3);

            }

        }

    }


}
