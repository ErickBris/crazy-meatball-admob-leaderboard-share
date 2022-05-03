package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;

/**
 * Created by Guille on 22/8/15.
 */
public class MenuUpdate {

    public static boolean pressed, first=true;

    public static void update() {


        //Storing if the screen is touched
        pressed = Gdx.input.isTouched();

        if (pressed && first == true) {

            first = false;

        }


        if (!pressed) {

            if (first == false) {


                //play_button onClick
                if (MenuStorage.play_button.isPressed()) {
                    GameScreen.state = GameScreen.GameState.RUNNING;
                    RunningUpdate.prepare_game();

                } else if (MenuStorage.ranking_button.isPressed()) {

                    GameScreen.actionResolver.showScores();


                } else if (MenuStorage.rate_button.isPressed()) {

                    GameScreen.actionResolver.rate();


                } else if (MenuStorage.sound_button.isPressed()) {

                    if(GeneralStorage.prefs.getInteger("sound",1)==1){

                        MenuStorage.sound_button.change_textures(MenuStorage.sound_off_texture, MenuStorage.sound_off_pressed_texture);

                        GeneralStorage.prefs.putInteger("sound", 0);
                        GeneralStorage.prefs.flush();

                        GeneralStorage.background_music.pause();

                    }

                    else{


                        MenuStorage.sound_button.change_textures(MenuStorage.sound_texture, MenuStorage.sound_pressed_texture);

                        GeneralStorage.prefs.putInteger("sound", 1);
                        GeneralStorage.prefs.flush();

                        GeneralStorage.background_music.play();
                    }
                } else if (MenuStorage.share_button.isPressed()) {

                    GameScreen.actionResolver.share(GeneralStorage.prefs.getInteger("best",0));

                }

            }


            MenuStorage.play_button.restore_texture();
            MenuStorage.ranking_button.restore_texture();
            MenuStorage.rate_button.restore_texture();
            MenuStorage.sound_button.restore_texture();
            MenuStorage.share_button.restore_texture();

            first = true;

        }

        //Screen pressed
        else{

            MenuStorage.play_button.update_texture();
            MenuStorage.ranking_button.update_texture();
            MenuStorage.rate_button.update_texture();
            MenuStorage.sound_button.update_texture();
            MenuStorage.share_button.update_texture();

        }

    }

}
