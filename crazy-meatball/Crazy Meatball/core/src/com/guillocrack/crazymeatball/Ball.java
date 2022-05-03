package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

/**
 * Created by Guille on 20/8/15.
 */
public class Ball {

    public Sprite sp;
    public boolean big, shown;
    public float pixels_fall;

    public Ball(boolean big){

        this.big = big;

        sp = new Sprite(GeneralStorage.meatball_texture);

    }

    public boolean check_collision(ArrayList<Rectangle> rectangles){


        for(Rectangle rectangle: rectangles) {

            if ((sp.getY() <= rectangle.sp.getY() && rectangle.sp.getY() <= sp.getY() + sp.getHeight()) &&

                    //  Gdx.app.log("colision", "colision");
                    ((sp.getX() <= rectangle.sp.getX() + rectangle.sp.getWidth()
                            && rectangle.sp.getX() + rectangle.sp.getWidth() <= sp.getX() + sp.getWidth())

                            || (sp.getX() <= rectangle.sp.getX() && rectangle.sp.getX() <= sp.getX() + sp.getWidth())

                            || (sp.getX() >= rectangle.sp.getX() && sp.getX() + sp.getWidth() <=
                            rectangle.sp.getX() + rectangle.sp.getWidth())))
                return true;



        }

        return false;

    }


    public boolean move(float pixels, boolean moving_left, boolean alive){

        if(alive) {

            //Moving left
            if(moving_left) {
                if (sp.getX() - pixels <= 0) {
                    sp.setPosition(0, sp.getY());
                } else {
                    sp.setPosition(sp.getX() - pixels, sp.getY());
                }

            }

            //Moving right
            else{

                if (sp.getX() + sp.getWidth() + pixels >= GeneralStorage.w) {
                    sp.setPosition(GeneralStorage.w - sp.getWidth(), sp.getY());
                } else {
                    sp.setPosition(sp.getX() + pixels, sp.getY());
                }



            }
        }

        else{

            pixels_fall = GeneralStorage.pixels_second_fall * Gdx.graphics.getDeltaTime();

            if(shown) {
                if (sp.getY() - pixels_fall < GeneralStorage.h * 0.15f) {
                    sp.setPosition(sp.getX(), GeneralStorage.h * 0.15f);
                    shown = false;
                    if (sp.getX() < GeneralStorage.w * 0.5f) {
                        GeneralStorage.boom2.start();
                        GeneralStorage.boom2.reset();
                        GeneralStorage.boom2.setPosition(sp.getX() + sp.getWidth() / 2, sp.getY() + sp.getHeight() / 2);
                        if(GeneralStorage.prefs.getInteger("sound",1)==1)
                            GeneralStorage.tomato_effect.play();

                        Gdx.app.log("particulas", "particulas");
                    } else {
                        GeneralStorage.boom3.start();
                        GeneralStorage.boom3.reset();
                        GeneralStorage.boom3.setPosition(sp.getX() + sp.getWidth() / 2, sp.getY() + sp.getHeight() / 2);

                        if(GeneralStorage.prefs.getInteger("sound",1)==1)
                            GeneralStorage.tomato_effect.play();
                    }

                }
                else sp.setPosition(sp.getX(), sp.getY() - pixels_fall);
            }




        }


        return shown;

    }

    public void draw(){


        if(shown)
            sp.draw(GeneralStorage.batch);

    }

}
