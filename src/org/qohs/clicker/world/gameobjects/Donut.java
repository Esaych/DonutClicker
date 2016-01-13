package org.qohs.clicker.world.gameobjects;

import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.GameWorld;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutType;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Donut implements UpdateRenderObj {

/*	public enum DonutType {
		PLAIN,
		DEEP_FRIED,
		BLUEBERRY,
		JELLY,
		CREAM,
		CRULLER,
		BOSTON_CREME,
		SOUR_CREAM
	}
	
	public enum DonutTopping {
		NONE,
		RED_SPRINKLES,
		BLUE_SPRINKLES,
		YELLOW_SPRINKLES,
		WHITE_SPRINKLES,
		BLACK_SPRINKLES,
		GLAZED,
		
		//frostings
		CHOCOLATE,
		VANILLA,
		STRAWBERRY,
		
		POWDER,
		SUGAR_COATED,
		CINNAMON
	}
	*/
	private DonutType type;
	private DonutTopping topping;
	private boolean animateClick;
	private double size; //WHAT'S THIS FOR?
	
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
	}
	
	public DonutTopping getTopping() {
		return topping;
	}
	
	public void setTopping(DonutTopping newTopping) {
		topping = newTopping;
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
//		renderer.begin(ShapeType.Filled);
//		renderer.circle(240, 400, 200);
//		renderer.setColor(Color.CYAN);
//		renderer.circle(240, 400, 50);
//		renderer.end();
		
		batcher.begin();
		if (animateClick) {
			
			//System.out.println("ANIMATING");
			batcher.draw(typeTexture, 40, 140, 400, 400);
			if (toppingTexture != null) {
				batcher.draw(toppingTexture, 40, 140, 400, 400);
			}
		}
		else {
			
			batcher.draw(typeTexture, 30, 130, 420, 420);
			if (toppingTexture != null) {
				batcher.draw(toppingTexture, 30, 130, 420, 420);
			}
		}
		
		batcher.end();
	}

	public void update(float delta) { //calling of this method disabled as per constructor
		// TODO Auto-generated method stub
		
	}
}
