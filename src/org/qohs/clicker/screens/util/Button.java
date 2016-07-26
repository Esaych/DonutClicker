package org.qohs.clicker.screens.util;

import org.qohs.clicker.Clicker;
import org.qohs.clicker.Clicker.ScreenType;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.menu.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public abstract class Button implements UpdateRenderObj, InputObj {
	
	protected boolean animateClick = false;
	protected int x, y, width, height;
	protected Drawable drawable;
	protected Drawable clickDrawable;
	
	public Button(int x, int y, int width, int height, Drawable drawable, Drawable clickDrawable) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.drawable = drawable;
		this.clickDrawable = clickDrawable;
		if (Clicker.getClickerScreenType().equals(ScreenType.GAME))
			GameWorld.registerUpdates(this, false, true);
		else if (Clicker.getClickerScreenType().equals(ScreenType.MENU))
			Menu.registerUpdates(this, false, true);
//		InputHandler.registerInputObject(this);
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setX(int myX){
		x = myX;
	}
	public void setY(int myY){
		y = myY;
	}
	public void setHeight(int myHeight){
		height = myHeight;
	}
	public void setWidth(int myWidth){
		width = myWidth;
	}
	
	public void animateClickDown() {
		animateClick = true;
		System.out.println("BUTTON DOWN");
	}
	
	public void animateClickUp() { 
		animateClick = false;
		System.out.println("BUTTON UP");
	}
	
	public boolean collision(int x2, int y2){
		return (x2>x) && (x2<x+width) 
			&& (y2>y) && (y2<y+height);
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
		if (drawable != null && clickDrawable != null) {
			batcher.begin();
			if (animateClick)
				clickDrawable.draw(batcher, x, y, width, height);
			else
				drawable.draw(batcher, x, y, width, height);
			batcher.end();
			
		}
		else {

			if (animateClick) {
				System.out.println("ANIMATING");
				renderer.begin(ShapeType.Filled);
				renderer.setColor(Color.BLUE);
				renderer.rect(x+5, y+5, width-10, height-10);
				renderer.end();
			}
			else {
				renderer.begin(ShapeType.Filled);
				renderer.setColor(Color.BLUE);
				renderer.rect(x, y, width, height);
				renderer.end();
			}
		}
		
	}

	public void update(float delta) { //calling of this method disabled as per constructor
	}
	
	public abstract void onClick();
	
	public boolean isVisible(){return false;}
}
