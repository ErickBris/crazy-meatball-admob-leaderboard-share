package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;

/**
 * Created by Guille on 29/8/15.
 */
public class PauseUpdate {

    public static boolean pressed, first=true;

    public static void update(){




        //Storing if the screen is touched
        pressed = Gdx.input.isTouched();

        if (pressed && first == true) {

            first = false;

        }

        if (!pressed) {

            if (first == false) {


                //play_button onClick
                if (com.guillocrack.crazymeatball.MenuStorage.play_pause_button.isPressed()) {
                    GameScreen.state = GameScreen.GameState.RUNNING;


                } else if (com.guillocrack.crazymeatball.MenuStorage.home_button.isPressed()) {

                    GameScreen.state = GameScreen.GameState.MENU;

                }

            }

            com.guillocrack.crazymeatball.MenuStorage.play_pause_button.restore_texture();
            com.guillocrack.crazymeatball.MenuStorage.home_button.restore_texture();

            first = true;

        }

        //Screen pressed
        else{

            com.guillocrack.crazymeatball.MenuStorage.play_pause_button.update_texture();
            com.guillocrack.crazymeatball.MenuStorage.home_button.update_texture();

        }

    }


}
