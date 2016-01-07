package org.qohs.clicker.world;

import java.util.ArrayList;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.util.UpdateRenderObj;
import org.qohs.clicker.world.gameobjects.AutoClicker;
import org.qohs.clicker.world.gameobjects.Donut;
import org.qohs.clicker.world.gameobjects.buttons.SettingsButton;
import org.qohs.clicker.world.gameobjects.buttons.ShopButton;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutTopping;
import org.qohs.clicker.world.gameobjects.donutaspects.DonutType;

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
	public static int GAMEWIDTH = 480;
	public static int GAMEHEIGHT = 800;
	//public Score score
	
	public GameWorld() {
        donut = new Donut(DonutType.STUFFED_WHIPPED_CREAM, DonutTopping.BLUE_SPRINKLES);
        score = new Score(donut);
        autoClicker = new AutoClicker(donut);
		shopButton = new ShopButton();
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
		
		for (UpdateRenderObj objClass : renderObjs) {
			objClass.render(batcher, renderer);
		}
		batcher.begin();
		batcher.draw(AssetLoader.icon_settings, GAMEWIDTH-80,0,80,80);
		batcher.end();
    }
    
    public static void registerUpdates(UpdateRenderObj objClass, boolean update, boolean render) {
    	if (update)
    		updateObjs.add(objClass);
    	if (render)
    		renderObjs.add(objClass);
    }
}