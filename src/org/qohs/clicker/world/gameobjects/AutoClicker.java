package org.qohs.clicker.world.gameobjects;

import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.GameWorld;
import org.qohs.clicker.world.Score;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutType;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class AutoClicker implements UpdateRenderObj {
	
	private float clickRemainder = 0;
	private Donut donut;
	
	public AutoClicker(Donut donut) {
		this.donut = donut;
		GameWorld.registerUpdates(this, true, false);
	}
	
	public double getCPS() {
		return DonutType.getClicksPerSec(donut.getType());
	}
	
	public void update(float delta){
		double clicks = delta * getCPS() + clickRemainder;
		int actualClicks = (int) clicks;
		clickRemainder = (float) clicks - actualClicks;
		Score.addScore(actualClicks, DonutTopping.getMultiplier(donut.getTopping())-1); //multiplier for none = 1, so autoclicker should be 1 less (0 cps)
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) { //method disabled as per constructor
		
	}

}
