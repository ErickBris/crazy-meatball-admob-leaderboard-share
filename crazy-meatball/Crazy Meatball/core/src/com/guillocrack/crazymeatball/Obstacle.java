package com.guillocrack.crazymeatball;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

/**
 * Created by Guille on 20/8/15.
 */
public class Obstacle {

    public ArrayList<com.guillocrack.crazymeatball.Rectangle> rectangles;
    public boolean moving = false;

    public Obstacle(){

        initilize_rectangles();

    }


    public void initilize_rectangles(){

        rectangles = new ArrayList<com.guillocrack.crazymeatball.Rectangle>();
        moving = false;

        switch(MathUtils.random(1,7)){


            case 1:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.2f, 0.6f));

                break;

            case 2:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.1f, 0.3f));
                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.6f, 0.3f));

                break;

            case 3:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.0f, 0.35f));
                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.65f, 0.35f));

                break;

            case 4:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.3f, 0.4f));

                break;

            case 5:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0, 0.4f));

                break;

            case 6:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.6f, 0.4f));

                break;

            case 7:

                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0, 0.1f));
                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.35f, 0.3f));
                rectangles.add(new com.guillocrack.crazymeatball.Rectangle(0.9f, 0.1f));

                break;



        }



    }

    public void move(){

        if(moving) {
            for (com.guillocrack.crazymeatball.Rectangle rectangle : rectangles)
                rectangle.move();
          // Gdx.app.log("muevo", "muevo");
        }

        if(rectangles.get(0).sp.getY() <= - rectangles.get(0).sp.getHeight()){
            moving = false;
            initilize_rectangles();
        }

    }

    public void change_possible(){

        if(rectangles.get(0).sp.getY() + rectangles.get(0).sp.getHeight() < GeneralStorage.meatball.big_ball.sp.getY()){

            if(com.guillocrack.crazymeatball.RunningUpdate.possible_crash == GeneralStorage.obstacles.size() - 1)
                com.guillocrack.crazymeatball.RunningUpdate.possible_crash = 0;
            else com.guillocrack.crazymeatball.RunningUpdate.possible_crash++;

            com.guillocrack.crazymeatball.RunningUpdate.score++;
            com.guillocrack.crazymeatball.RunningUpdate.increase_difficulty();
        }

    }


    public void draw(){

        if(moving)
        for(com.guillocrack.crazymeatball.Rectangle rectangle: rectangles)
            rectangle.draw();

    }

}
