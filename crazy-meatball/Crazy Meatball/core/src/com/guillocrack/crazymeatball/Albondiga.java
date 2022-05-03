package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;

/**
 * Created by Guille on 20/8/15.
 */
public class Albondiga {

    public float size, time_side, pixels_second, size_small, pixels_move, pixels_fall, margin_down, delta;
    public Ball big_ball, left_ball, right_ball;
    public boolean big_shown, big_move, left_move, right_move, aux;

    public Albondiga(){

        size = GeneralStorage.h*0.06f;
        size_small = size*0.6f;
        time_side = 0.45f;
        pixels_second = GeneralStorage.w/2/time_side;
        margin_down = GeneralStorage.h*0.4f;

        big_ball = new Ball(true);
        big_ball.sp.setSize(size, size);
        big_ball.sp.setPosition((GeneralStorage.w - big_ball.sp.getWidth()) / 2, margin_down);

        left_ball = new Ball(false);
        left_ball.sp.setSize(size_small, size_small);
        left_ball.sp.setPosition((GeneralStorage.w - left_ball.sp.getWidth()) / 2, margin_down + size + (size - size_small) / 2);

        right_ball = new Ball(false);
        right_ball.sp.setSize(size_small, size_small);
        right_ball.sp.setPosition((GeneralStorage.w - right_ball.sp.getWidth()) / 2, margin_down + (size - size_small) / 2);

        big_shown = true;

    }

    public void initialize(){


        big_move = true;
        left_move = true;
        right_move = true;
        big_shown = true;

        left_ball.shown = true;
        right_ball.shown = true;

        big_ball.sp.setPosition((GeneralStorage.w - big_ball.sp.getWidth()) / 2, margin_down);



    }

    public void move(){

        pixels_move = Gdx.graphics.getDeltaTime() * pixels_second;
        pixels_fall = GeneralStorage.pixels_second_fall * Gdx.graphics.getDeltaTime();

        if(Gdx.input.isTouched()){

            if(big_shown) {

                if(big_move) {
                    GeneralStorage.boom1.reset();
                    GeneralStorage.boom1.setPosition(big_ball.sp.getX() + big_ball.sp.getWidth()/2,
                            big_ball.sp.getY() + big_ball.sp.getHeight()/2);
                    big_shown = false;
                    left_ball.sp.setPosition((GeneralStorage.w - left_ball.sp.getWidth()) / 2, margin_down + size / 4);
                    right_ball.sp.setPosition((GeneralStorage.w - right_ball.sp.getWidth()) / 2, margin_down + size / 4);
                    GeneralStorage.smoke1.reset();
                    GeneralStorage.smoke2.reset();
                }
                else big_ball.sp.setPosition(big_ball.sp.getX(), big_ball.sp.getY() - pixels_fall);

            }

            else {

                aux = left_ball.move(pixels_move, true, left_move);

                if(!right_ball.move(pixels_move, false, right_move) && !aux)
                    RunningUpdate.finish_game();

            }


        }

        //Screen not touched
        else{

            if(!big_shown){


                aux = left_ball.move(pixels_move, false, left_move);

                if(!right_ball.move(pixels_move, true, right_move) && !aux)
                    RunningUpdate.finish_game();

                if(left_move && right_move &&
                        left_ball.sp.getX() + left_ball.sp.getWidth() - right_ball.sp.getX() > size*0.5f)
                    big_shown = true;
                GeneralStorage.smoke1.reset();


            }

            else{

                if(!big_move) {
                    if(big_ball.sp.getY() - pixels_fall < GeneralStorage.h * 0.15f){

                        big_ball.sp.setPosition(big_ball.sp.getX(), GeneralStorage.h * 0.15f);
                        RunningUpdate.finish_game();
                        GeneralStorage.boom2.start();
                        GeneralStorage.boom2.reset();
                        GeneralStorage.boom2.setPosition(big_ball.sp.getX() + big_ball.sp.getWidth() / 2,
                                big_ball.sp.getY() + big_ball.sp.getHeight() / 2);

                        if(GeneralStorage.prefs.getInteger("sound",1)==1)
                            GeneralStorage.tomato_effect.play();
                        big_shown = false;
                        left_ball.shown = false;
                        right_ball.shown = false;


                    }
                   else {
                        big_ball.sp.setPosition(big_ball.sp.getX(),
                                big_ball.sp.getY() - pixels_fall);
                    }



                }

            }

        }


    }

    public void check_colision(){



        if(big_shown){


                    if(big_ball.check_collision(GeneralStorage.obstacles.get(RunningUpdate.possible_crash).rectangles))
                        big_move = false;

        }

        else{

            if(left_ball.check_collision(GeneralStorage.obstacles.get(RunningUpdate.possible_crash).rectangles))
                left_move = false;
            if(right_ball.check_collision(GeneralStorage.obstacles.get(RunningUpdate.possible_crash).rectangles))
                right_move = false;

        }



    }

    public void position_particles(){





    }


    public void draw(){




        if(big_shown) {
            big_ball.sp.draw(GeneralStorage.batch);

            if(com.guillocrack.crazymeatball.GameScreen.state == com.guillocrack.crazymeatball.GameScreen.GameState.RUNNING) {
                GeneralStorage.smoke1.setPosition(big_ball.sp.getX() + big_ball.sp.getWidth() / 2, big_ball.sp.getY());
                GeneralStorage.smoke1.draw(GeneralStorage.batch, Gdx.graphics.getDeltaTime());
            }

        }
        else{

            right_ball.draw();
            left_ball.draw();

            if(com.guillocrack.crazymeatball.GameScreen.state == com.guillocrack.crazymeatball.GameScreen.GameState.RUNNING) {

                if(left_ball.shown) {
                    GeneralStorage.smoke1.setPosition(left_ball.sp.getX() + left_ball.sp.getWidth() / 2, left_ball.sp.getY());
                    GeneralStorage.smoke1.draw(GeneralStorage.batch, Gdx.graphics.getDeltaTime());
                }

                if(right_ball.shown) {
                    GeneralStorage.smoke2.setPosition(right_ball.sp.getX() + right_ball.sp.getWidth() / 2, right_ball.sp.getY());
                    GeneralStorage.smoke2.draw(GeneralStorage.batch, Gdx.graphics.getDeltaTime());
                }
            }

        }

    }



}
