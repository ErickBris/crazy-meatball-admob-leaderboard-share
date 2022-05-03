package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;


/**
 * Created by Guille on 22/8/15.
 */
public class MenuDraw {

    public static GlyphLayout layout;
    public static String text;
    public static Float separation, origin_h = GeneralStorage.h*0.72f;

    public static void draw() {


        Gdx.gl.glClearColor(GeneralStorage.background_color.r, GeneralStorage.background_color.g,GeneralStorage.background_color.b,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GeneralStorage.batch.begin();

        MenuStorage.title.draw(GeneralStorage.batch);

        if(layout==null)
            layout = new GlyphLayout();

        text = "High Score: " + String.valueOf(GeneralStorage.prefs.getInteger("best",0));
        layout.setText(GeneralStorage.menuFont, text);
        separation = (GeneralStorage.h*0.3f - layout.height*3)/4;

        GeneralStorage.menuFont.draw(GeneralStorage.batch, text, (GeneralStorage.w - layout.width) / 2, origin_h - separation);

        text = "Games Played: " + String.valueOf(GeneralStorage.prefs.getInteger("games",0));
        layout.setText(GeneralStorage.menuFont, text);

        GeneralStorage.menuFont.draw(GeneralStorage.batch, text, (GeneralStorage.w - layout.width)/2,
               origin_h - layout.height - separation*2);

        text = "Score: " + String.valueOf(RunningUpdate.score);
        layout.setText(GeneralStorage.menuFont, text);

        GeneralStorage.menuFont.draw(GeneralStorage.batch, text, (GeneralStorage.w - layout.width)/2,
                origin_h - layout.height*2 - separation*3);



        MenuStorage.play_button.draw();
        MenuStorage.ranking_button.draw();
        MenuStorage.rate_button.draw();
        MenuStorage.sound_button.draw();
        MenuStorage.share_button.draw();




        GeneralStorage.batch.end();


    }


}
