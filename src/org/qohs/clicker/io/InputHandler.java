package org.qohs.clicker.io;

import java.util.ArrayList;

import org.qohs.clicker.Clicker;
import org.qohs.clicker.Clicker.ScreenType;
import org.qohs.clicker.screens.GameScreen;
import org.qohs.clicker.screens.MenuScreen;
import org.qohs.clicker.screens.util.InputObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * "Generic"(really NOT generic... teehee) code to process inputs on the screen
 * @author QO Game Development Club
 *
 */

public class InputHandler implements InputProcessor {

	private static ArrayList<InputObj> inputobjs = new ArrayList<InputObj>();
	public static void registerInputObject(InputObj input) {
		inputobjs.add(input);
	}
	
	public boolean keyDown(int keycode) {
		if (keycode == Keys.BACK || keycode == Keys.MENU || keycode == Keys.ESCAPE) {
			Gdx.app.exit();
		} else if (keycode == Keys.UP) {
			
		} else if (keycode == Keys.DOWN) {
			
		} else if (keycode == Keys.LEFT) {
			
		} else if (keycode == Keys.RIGHT) {
			
		}
		return true;
	}

	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP) {

		} else if (keycode == Keys.DOWN) {
			
		} else if (keycode == Keys.LEFT) {
			
		} else if (keycode == Keys.RIGHT) {
			
		}
		return false;
	}

	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO Make these dependent on which screen InputHandler is latched on to
	/*
	 * Called when click/tap screen
	 * @see com.badlogic.gdx.InputProcessor#touchDown(int, int, int, int)
	 */
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (Clicker.getClickerScreenType().equals(ScreenType.GAME)) {
			GameScreen gameScreen = (GameScreen) Clicker.getClickerScreen();
			if (gameScreen.getWorld().shopButton.collision(x, y))
				gameScreen.getWorld().shopButton.animateClickDown();
			else if (gameScreen.getWorld().settingsButton.collision(x, y))
				gameScreen.getWorld().settingsButton.animateClickDown();
			else //not a button click - must be donut click
				gameScreen.getWorld().donut.animateClickDown();
		}
		else {
			MenuScreen menuScreen = (MenuScreen) Clicker.getClickerScreen();
			if (menuScreen.getMenu().shopButton.collision(x, y))
				menuScreen.getMenu().shopButton.animateClickDown();
		}
		return true;
	}

	public boolean touchUp(int x, int y, int pointer, int button) {
		
		if (Clicker.getClickerScreenType().equals(ScreenType.GAME)) {
			GameScreen gameScreen = (GameScreen) Clicker.getClickerScreen();
			if (gameScreen.getWorld().shopButton.collision(x, y)) {
				gameScreen.getWorld().shopButton.animateClickUp();
				gameScreen.getWorld().shopButton.onClick();
			}
			else if (gameScreen.getWorld().settingsButton.collision(x, y)) {
				gameScreen.getWorld().settingsButton.animateClickUp();
				gameScreen.getWorld().settingsButton.onClick();
			}
			else //not a button click - must be donut click
			{
				gameScreen.getWorld().donut.animateClickUp();
				gameScreen.getWorld().donut.onClick();
			}
		}
		else {
			MenuScreen menuScreen = (MenuScreen) Clicker.getClickerScreen();
			if (menuScreen.getMenu().shopButton.collision(x, y)) {
				menuScreen.getMenu().shopButton.animateClickUp();
				menuScreen.getMenu().shopButton.onClick();
			}
		}
		
		/*
		for (InputObj b : inputobjs) {
			if (b.isVisible() && b.collision(x, y)) {
				b.animateClickUp();
				b.onClick();
			}
		}
		*/
//		if (Clicker.getClickerScreenType().equals(ScreenType.GAME)) {
//			GameScreen gameScreen = (GameScreen) Clicker.getClickerScreen();
//			if (gameScreen.getWorld().shopButton.collision(x, y))
//				gameScreen.getWorld().shopButton.animateClickUp();
//			else if (gameScreen.getWorld().settingsButton.collision(x, y))
//				gameScreen.getWorld().settingsButton.animateClickUp();
//			else {
//				
//				double multiplier = DonutTopping.getMultiplier(gameScreen.getWorld().donut.getTopping());
//				Score.addScore(1, multiplier);
//				//casts the multiplier to an int for plus number
//				int addition = (int) multiplier;
//				if (addition != 0) {
//					
//					new PlusNumber(x, y, addition);
//				}
//			}
//			gameScreen.getWorld().donut.animateClickUp();
//		}
//		else {
//			MenuScreen menuScreen = (MenuScreen) Clicker.getClickerScreen();
//			if (menuScreen.getMenu().shopButton.collision(x, y))
//				menuScreen.getMenu().shopButton.animateClickUp();
//		}
		return true;
	}

	public boolean touchDragged(int x, int y, int pointer) {
		return false;
	}

	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
