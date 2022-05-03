package com.guillocrack.crazymeatball;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Guille on 20/8/15.
 */
public class Rectangle {

    public Sprite sp;

    public Rectangle(float x, float width){

        sp = new Sprite(GeneralStorage.pixel);
        sp.setSize(GeneralStorage.w * width, GeneralStorage.height_obstacles);
        sp.setPosition(GeneralStorage.w * x, GeneralStorage.h);
        sp.setColor(GeneralStorage.color_bars);

    }



    public void move(){

        sp.setPosition(sp.getX(), sp.getY() - RunningUpdate.pixels_fall);


    }

    public void draw(){


        sp.draw(GeneralStorage.batch);

    }


}
