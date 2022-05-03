package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import java.util.ArrayList;

/**
 * Created by Guille on 28/7/15.
 */
public class GeneralStorage {


    public static SpriteBatch batch;
    public static float w,h, ratio, height_obstacles, time_fall, pixels_second_fall, separation_obstacles;
    public static Texture meatball_texture, pixel;
    public static Albondiga meatball;
    public static ArrayList<Obstacle> obstacles;
    public static BitmapFont scoreFont, menuFont, pauseFont;
    public static Preferences prefs;
    public static Color color_fonts, color_bars, background_color;
    public static ParticleEffect smoke1, smoke2, boom1, boom2, boom3;
    public static Music background_music;
    public static Sound tomato_effect;
    public static Sprite pause_sprite;

    public static FreeTypeFontGenerator generator;

    public static void load(){


        batch = new SpriteBatch();

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        //Ratio is used for text size
        float ratio1 = (float) (w / 1080.0);
        float ratio2 = (float) (h / 1920.0);

        //The ratio is used for text size
        if (ratio1 > ratio2)
            ratio = ratio2;
        else
            ratio = ratio1;

        prefs = Gdx.app.getPreferences("Prefs");

        meatball_texture = new Texture("meatball.png");
        meatball_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        pixel = new Texture("pixel.png");
        pixel.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        meatball = new Albondiga();

        height_obstacles = h*0.015f;
        separation_obstacles = h * 0.3f;
        time_fall = 2.4f;
        pixels_second_fall = h/time_fall;




        color_bars = new Color(131/255f, 23/255f, 23/255f, 1.0f);
        color_fonts = new Color(91/255f, 32/255f, 16/255f, 1.0f);
        background_color = new Color(110/255f, 195/255f, 235/255f, 1.0f);


        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = (int) (150*ratio);

        FreeTypeFontParameter parameter2 = new FreeTypeFontParameter();
        parameter2.size = (int) (90*ratio);

        FreeTypeFontParameter parameter3 = new FreeTypeFontParameter();
        parameter3.size = (int) (140*ratio);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));

        scoreFont = generator.generateFont(parameter);
        scoreFont.setColor(color_fonts);

        menuFont = generator.generateFont(parameter2);
        menuFont.setColor(color_fonts);

        pauseFont = generator.generateFont(parameter3);
        pauseFont.setColor(color_fonts);


        obstacles = new ArrayList<Obstacle>();

        for(int i=0; i<5; i++){

            obstacles.add(new Obstacle());

        }


        smoke1 = new ParticleEffect();
        smoke1.load(Gdx.files.internal("effects/Estela"), Gdx.files.internal("effects"));
        smoke1.start();

        smoke2 = new ParticleEffect();
        smoke2.load(Gdx.files.internal("effects/Estela"), Gdx.files.internal("effects"));
        smoke2.start();

        boom1 = new ParticleEffect();
        boom1.load(Gdx.files.internal("effects/Boom"), Gdx.files.internal("effects"));
        boom1.start();

        boom2 = new ParticleEffect();
        boom2.load(Gdx.files.internal("effects/Boom"), Gdx.files.internal("effects"));
        //boom2.start();

        boom3 = new ParticleEffect();
        boom3.load(Gdx.files.internal("effects/Boom"), Gdx.files.internal("effects"));
       // boom3.start();


        com.guillocrack.crazymeatball.RunningUpdate.prepare_game();


        //Background music
        background_music = Gdx.audio.newMusic(Gdx.files.internal("background_music.mp3"));
        background_music.setLooping(true);


        if(prefs.getInteger("sound",1)==1)
            background_music.play();

        tomato_effect = Gdx.audio.newSound(Gdx.files.internal("tomato_effect.mp3"));


        //PAUSE BUTTON
        pause_sprite = new Sprite(new Texture("pause.png"));
        pause_sprite.setSize((float) (h * 0.06), (float) (h * 0.06));
        pause_sprite.setPosition((float) (w * 0.04f), (float) (h * 0.915));

    }


}
