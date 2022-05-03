package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/**
 * Created by Guille on 28/7/15.
 */
public class RunningDraw {


    public static GlyphLayout layout;


    public static void draw(){


        Gdx.gl.glClearColor(com.guillocrack.crazymeatball.GeneralStorage.background_color.r, com.guillocrack.crazymeatball.GeneralStorage.background_color.g, com.guillocrack.crazymeatball.GeneralStorage.background_color.b,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        com.guillocrack.crazymeatball.GeneralStorage.batch.begin();

        com.guillocrack.crazymeatball.GeneralStorage.pause_sprite.draw(com.guillocrack.crazymeatball.GeneralStorage.batch);

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
    }


}
