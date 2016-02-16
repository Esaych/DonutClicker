package org.qohs.clicker.screens.game;

import java.util.ArrayList;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.gameobjects.AutoClicker;
import org.qohs.clicker.screens.game.gameobjects.Donut;
import org.qohs.clicker.screens.game.gameobjects.Score;
import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.screens.game.gameobjects.donutaspects.DonutType;
import org.qohs.clicker.screens.menu.buttons.SettingsButton;
import org.qohs.clicker.screens.menu.buttons.ShopButton;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/**
 * ALL game objects and and render() at the bottom to show them to the screen
 * @author QO Game Development Club
 *
 */
public class GameWorld {
	
	//VARS
	private OrthographicCamera cam;
	private ShapeRenderer renderer;
	private SpriteBatch batcher;
	public float fps;
	public Donut donut;
	public Score score;
	public ShopButton shopButton;
	public SettingsButton settingsButton;
	public AutoClicker autoClicker;
	public static ArrayList<UpdateRenderObj> updateObjs = new ArrayList<UpdateRenderObj>();
	public static ArrayList<UpdateRenderObj> renderObjs = new ArrayList<UpdateRenderObj>();
	//Sam, it might be a good idea to set the widths perhaps in the desktop launcher
	//and have it as a static there???
	//btw if you write in DesktopLauncher.java "config.resizable = false" then you know
	//DO NOT INSTANTIATE THIS CLASS WHEN YOU ARE NOT IN RENDER THREAD (MOST LIKE NOT A PROBLEM)
	public static int GAMEWIDTH = Gdx.graphics.getWidth();
	public static int GAMEHEIGHT = Gdx.graphics.getHeight();
	//public Score score
	
	public GameWorld() {
        donut = new Donut(DonutType.GLAZED, DonutTopping.RAINBOW_SPRINKLES);
        score = new Score(donut);
        autoClicker = new AutoClicker(donut);
		shopButton = new ShopButton(false);
		settingsButton = new SettingsButton();
        
		cam = new OrthographicCamera();
		cam.setToOrtho(true, GAMEWIDTH, GAMEHEIGHT);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		renderer = new ShapeRenderer();
		renderer.setProjectionMatrix(cam.combined);
	}
	
    public void update(float delta) {
    	fps = (1/delta);
		for (UpdateRenderObj objClass : updateObjs) {
			objClass.update(delta);
		}
    }
    
    public void render(float delta) {
		// Sets a Color to Fill the Screen with (RGB = 112, 253, 230), Opacity of 1 (100%)
		Gdx.gl.glClearColor(112/255.0f, 253/255.0f, 255/255.0f, 1f);
		// Fills the screen with the selected color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batcher.begin();
		batcher.draw(AssetLoader.awning, 0, GAMEWIDTH*-1/4, GAMEWIDTH, GAMEWIDTH);
		batcher.end();
		
		for (UpdateRenderObj objClass : renderObjs) {
			objClass.render(batcher, renderer);
		}
    }
    
    public static void registerUpdates(UpdateRenderObj objClass, boolean update, boolean render) {
    	if (update)
    		updateObjs.add(objClass);
    	if (render)
    		renderObjs.add(objClass);
    }
}