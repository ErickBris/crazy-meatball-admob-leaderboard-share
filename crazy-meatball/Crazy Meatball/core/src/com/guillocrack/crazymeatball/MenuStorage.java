package com.guillocrack.crazymeatball;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Guille on 22/8/15.
 */
public class MenuStorage {

    public static Texture home_texture, home_pressed_texture, ranking_texture, ranking_pressed_texture,
            play_texture, play_pressed_texture, share_texture, share_pressed_texture, sound_texture, sound_pressed_texture,
            sound_off_texture, sound_off_pressed_texture, rate_texture, rate_pressed_texture;

    public static But play_button, ranking_button, rate_button, sound_button, share_button, home_button, play_pause_button;

    public static float size_buttons, separation_buttons, margin_down_buttons, margin_left, size_play;

    public static Sprite title;

    public static void load(){

        size_buttons = GeneralStorage.h * 0.085f;
        size_play = GeneralStorage.h * 0.12f;
        separation_buttons = GeneralStorage.w * 0.035f;
        margin_down_buttons = GeneralStorage.h * 0.15f;
        margin_left = (GeneralStorage.w - size_buttons*4 - separation_buttons*3)/2;

        ranking_texture = new Texture("ranking.png");
        ranking_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        ranking_pressed_texture = new Texture("ranking_pressed.png");
        ranking_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        ranking_button = new But(margin_left, margin_down_buttons,
                size_buttons, size_buttons, ranking_texture, ranking_pressed_texture, GeneralStorage.w, GeneralStorage.h);

        play_texture = new Texture("play.png");
        play_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        play_pressed_texture = new Texture("play_pressed.png");
        play_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        play_button = new But((GeneralStorage.w - size_play)/2, margin_down_buttons + size_buttons + GeneralStorage.h*0.065f,
                size_play, size_play, play_texture, play_pressed_texture, GeneralStorage.w, GeneralStorage.h);

        share_texture = new Texture("share.png");
        share_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        share_pressed_texture = new Texture("share_pressed.png");
        share_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        share_button = new But(margin_left + size_buttons*3 + separation_buttons*3, margin_down_buttons,
                size_buttons, size_buttons, share_texture, share_pressed_texture, GeneralStorage.w, GeneralStorage.h);

        sound_texture = new Texture("sound.png");
        sound_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sound_pressed_texture = new Texture("sound_pressed.png");
        sound_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sound_off_texture = new Texture("sound_off.png");
        sound_off_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sound_off_pressed_texture = new Texture("sound_off_pressed.png");
        sound_off_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        if(GeneralStorage.prefs.getInteger("sound",1)==1)
        sound_button = new But(margin_left + size_buttons*2 + separation_buttons*2, margin_down_buttons,
                size_buttons, size_buttons, sound_texture, sound_pressed_texture, GeneralStorage.w, GeneralStorage.h);
        else sound_button = new But(margin_left + size_buttons*2 + separation_buttons*2, margin_down_buttons,
                size_buttons, size_buttons, sound_off_texture, sound_off_pressed_texture, GeneralStorage.w, GeneralStorage.h);

        rate_texture = new Texture("rate.png");
        rate_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rate_pressed_texture = new Texture("rate_pressed.png");
        rate_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        rate_button = new But(margin_left + size_buttons*1 + separation_buttons*1, margin_down_buttons,
                size_buttons, size_buttons, rate_texture, rate_pressed_texture, GeneralStorage.w, GeneralStorage.h);


        Texture title_texture = new Texture("logo.png");
        title_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        //Title
        title = new Sprite(title_texture);
        title.setSize(GeneralStorage.h * 0.2f * 2.4137f, GeneralStorage.h * 0.2f);
        title.setPosition((GeneralStorage.w - title.getWidth())/2, GeneralStorage.h*0.72f);



        float size_buttons_pause = GeneralStorage.h*0.14f;
        float separation_buttons_pause = GeneralStorage.w * 0.15f;
        float margin_buttons_pause = (GeneralStorage.w - size_buttons_pause*2)/3;

        home_texture = new Texture("home.png");
        home_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        home_pressed_texture = new Texture("home_pressed.png");
        home_pressed_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        home_button = new But(margin_buttons_pause, (GeneralStorage.h - size_buttons_pause)/2,
                size_buttons_pause, size_buttons_pause, home_texture, home_pressed_texture, GeneralStorage.w, GeneralStorage.h);

        play_pause_button = new But(margin_buttons_pause*2 + size_buttons_pause,
                (GeneralStorage.h - size_buttons_pause)/2,
                size_buttons_pause, size_buttons_pause, play_texture, play_pressed_texture, GeneralStorage.w, GeneralStorage.h);


    }


}
