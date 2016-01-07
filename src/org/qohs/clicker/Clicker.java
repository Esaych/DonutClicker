package org.qohs.clicker;

import org.qohs.clicker.io.AssetLoader;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

/**
 * Do not touch this code - it's copy pasted from somewhere... it creates a game
 * @author Sam Holmberg
 *
 */

public class Clicker extends Game implements ApplicationListener {
	
	private GameScreen gameScreen;
	
    public void create() {
    	AssetLoader.load();
        setScreen(gameScreen = new GameScreen());
    }
    
    public GameScreen getGameScreen() {
    	
    	return gameScreen;
    }
}
