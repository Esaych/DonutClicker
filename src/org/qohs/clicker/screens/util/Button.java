package org.qohs.clicker.screens.util;

import org.qohs.clicker.screens.game.GameWorld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class Button implements UpdateRenderObj {
	
	protected boolean animateClick = false;
	protected int x, y, width, height;
	protected TextureRegion texture;
	protected TextureRegion clickTexture;
	
	public Button(int x, int y, int width, int height, TextureRegion texture, TextureRegion clickTexture) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.clickTexture = clickTexture;
		GameWorld.registerUpdates(this, false, true);
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
		onClick();
	}
	
	public boolean collision(int x2, int y2){
		System.out.println("RESULT: " + x2 + ", " + y2);
		System.out.println("ACTUAL: " + x + ", " + y);
		return (x2>x) && (x2<x+width) 
			&& (y2>y) && (y2<y+height);
//		if ((x2>x) && (x2<x+width) && (y2>y) && (y2<y+height)) {
//			
//			System.out.println((x2>x) && (x2<x+width) && (y2>y)  (y2<y+height));
//			return true;
//		}
//		return false;
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
		if (texture != null && clickTexture != null) {
			batcher.begin();
			if (animateClick)
				batcher.draw(clickTexture, x, y, width, height);
			else
				batcher.draw(texture, x, y, width, height);
			batcher.end();
			
		} else {

			//TODO check why animation isn't working, button is being clicked
			if (animateClick) {
				System.out.println("ANIMATING");
				renderer.begin(ShapeType.Filled);
				renderer.setColor(Color.BLUE);
				renderer.rect(x+5, y+5, width-10, height-10);
				renderer.end();
			} else {
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
}
