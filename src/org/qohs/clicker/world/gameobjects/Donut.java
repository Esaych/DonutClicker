package org.qohs.clicker.world.gameobjects;

import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.GameWorld;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutType;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Donut implements UpdateRenderObj {

	private DonutType type;
	private DonutTopping topping;
	private boolean animateClick;
	
	private TextureRegion typeTexture;
	private TextureRegion toppingTexture;
	
	public Donut(DonutType type, DonutTopping topping) {
//		System.out.println("DONUT CREATED");
		this.type = type;
		this.topping = topping;
		this.typeTexture = DonutType.getTexture(type);
		this.toppingTexture = DonutTopping.getTexture(topping);
		GameWorld.registerUpdates(this, false, true);
	}
	
	public void animateClickDown() {
		animateClick = true;
		//System.out.println("DOWN");
	}
	
	public void animateClickUp() { 
		animateClick = false;
		//System.out.println("UP");
	}
	
	public DonutType getType() {
		return type;
	}
	
	public void setType(DonutType newType) {
		type = newType;
		typeTexture = DonutType.getTexture(type);
	}
	
	public DonutTopping getTopping() {
		return topping;
	}
	
	public void setTopping(DonutTopping newTopping) {
		topping = newTopping;
		toppingTexture = DonutTopping.getTexture(topping);
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
		
		batcher.begin();
		if (animateClick) {
			
			//System.out.println("ANIMATING");
			
			batcher.draw(typeTexture, 
					GameWorld.GAMEWIDTH/2-clickproportx(typeTexture)/2, 
					340-clickproporty(typeTexture)/2, 
					clickproportx(typeTexture), 
					clickproporty(typeTexture));
			if (toppingTexture != null) {
				batcher.draw(toppingTexture, 
						GameWorld.GAMEWIDTH/2-clickproportx(toppingTexture)/2, 
						340-clickproporty(toppingTexture)/2, 
						clickproportx(toppingTexture), 
						clickproporty(toppingTexture));
			}
		}
		else {
			
			batcher.draw(typeTexture, 
					GameWorld.GAMEWIDTH/2-proportx(typeTexture)/2, //ensures a centered image
					340-proporty(typeTexture)/2, 
					proportx(typeTexture), 
					proporty(typeTexture));
			if (toppingTexture != null) {
				batcher.draw(toppingTexture, 
						GameWorld.GAMEWIDTH/2-proportx(toppingTexture)/2, //ensures a centered image
						340-proporty(toppingTexture)/2, 
						proportx(toppingTexture), 
						proporty(toppingTexture));
			}
		}
		
		batcher.end();
	}
	
	public int proportx(TextureRegion texture) { //since not all textures are the same size, we have to bring proportions by a scale factor.
		return (int) (texture.getRegionWidth()*.18f);
	}

	public int proporty(TextureRegion texture) { //since not all textures are the same size, we have to bring proportions by a scale factor.
		return (int) (texture.getRegionHeight()*.18f);
	}
	
	public int clickproportx(TextureRegion texture) {
		return (int) (texture.getRegionWidth()*.17f);
	}
	
	public int clickproporty(TextureRegion texture) {
		return (int) (texture.getRegionHeight()*.17f);
	}

	public void update(float delta) { //calling of this method disabled as per constructor
		// TODO Auto-generated method stub
		
	}
}
