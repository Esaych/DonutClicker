package org.qohs.clicker.screens.game.gameobjects;

import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutType;
import org.qohs.clicker.screens.util.UpdateRenderObj;

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
		Score.addScore(actualClicks);
		//for demos it's too fast
		//Score.addScore(actualClicks, DonutTopping.getMultiplier(donut.getTopping())-1); //multiplier for none = 1, so autoclicker should be 1 less (0 cps)
	}
	
	public void render(SpriteBatch batcher, ShapeRenderer renderer) { //method disabled as per constructor
		
	}

}
