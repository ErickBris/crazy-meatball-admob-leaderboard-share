package com.guillocrack.crazymeatball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

//This is my personal button class. If you don't like it, you can look for other classes already creates by other people.
public class But {
	
	public float x_from, y_from, width, height, x_to_click, y_to_click, y_from_click, width_change, height_change, seconds, width_second, height_second, width_original, height_original;

	
	//Button background
	public Sprite sp;
	//Texture for the button background
	Texture texture, texture_2;
	
	public But(float x, float y, float width, float height, Texture texture, Texture texture_2, float w, float h){


		//x from for the button in px
		x_from = x;
		//y from for the button in px
		y_from = y;
		//y from the button that is compared with the screen pressed point
		y_from_click = h - y_from - height;
		//x to for the button (are the same that the click x)
		x_to_click =  x + width;
		//x to for the button (are the same that the click y)
		y_to_click = h - y_from;
		
		
		//Button width
		this.width=width;
		//Button height
		this.height = height;
		this.texture = texture;
		this.texture_2 = texture_2;
		//Time that passes between the click and when the button gets its maximum sizes
		seconds= (float) 0.1;
		//Original width
		width_original = width;
		//Original height
		height_original = height;
		//Width changed in px when the button is clicked
		width_change = (float) (width*0.1);
		//Height changed in px when the button is clicked
		height_change = (float) (height*0.1);
		//Width changed per second
		width_second = width_change / seconds;
		//Height changed per second
		height_second = height_change / seconds;
		
		sp = new Sprite(texture);
		 sp.setPosition(x_from,y_from);
		 sp.setSize(width,height);
	}


	
	//This method return true if the button have to increase its size or false if decrease
	public boolean update_texture(){

		if(Gdx.input.getX()>=x_from && Gdx.input.getX()<=x_to_click && Gdx.input.getY()>=y_from_click && Gdx.input.getY()<=y_to_click){
			sp.setTexture(texture_2);
			return true;
		}
		else restore_texture();
		
		return false;
		
	}

	public void restore_texture(){

		sp.setTexture(texture);

	}

	public void change_textures(Texture t1, Texture t2){

		texture = t1;
		texture_2 = t2;

		restore_texture();

	}

	//Return true is the button has been pressed
	public boolean isPressed(){

		if(Gdx.input.getX()>=sp.getX() && Gdx.input.getX()<=sp.getX() + sp.getWidth()
				&& Gdx.input.getY() >= GeneralStorage.h - sp.getY() - sp.getHeight()
				&& Gdx.input.getY()<= GeneralStorage.h - sp.getY())
			return true;
		else return false;

	}



	public void draw(){


		sp.draw(GeneralStorage.batch);

	}


}
