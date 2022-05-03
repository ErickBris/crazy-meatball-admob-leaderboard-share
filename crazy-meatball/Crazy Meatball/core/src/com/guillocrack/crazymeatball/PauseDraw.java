package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/**
 * Created by Guille on 29/8/15.
 */
public class PauseDraw {

    public static GlyphLayout layout;

    public static void draw(){


        Gdx.gl.glClearColor(GeneralStorage.background_color.r, GeneralStorage.background_color.g,GeneralStorage.background_color.b,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);

        GeneralStorage.batch.begin();



        //Drawing both buttons
        MenuStorage.home_button.sp.draw(GeneralStorage.batch);
        MenuStorage.play_pause_button.sp.draw(GeneralStorage.batch);


        if(layout==null)
            layout = new GlyphLayout();

        layout.setText(GeneralStorage.pauseFont, "PAUSE");

        //Drawing PAUSE
        GeneralStorage.pauseFont.draw(GeneralStorage.batch, "PAUSE",
                (float) ((GeneralStorage.w - layout.width)/2), (float) (GeneralStorage.h*0.75));


        GeneralStorage.batch.end();

    }

}
