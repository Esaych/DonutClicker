package org.qohs.clicker.screens.menu;

import java.util.ArrayList;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.menu.buttons.*;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Menu {

	private OrthographicCamera cam;
	private ShapeRenderer renderer;
	private SpriteBatch batcher;
	
	public ShopButton shopButton;
	public TrophyButton trophyButton;
	public RibbonButton ribbonButton;
	public Dropdown dropdown;
	public MultiplierShopButton multiShopButton;
	
	public static ArrayList<UpdateRenderObj> updateObjs = new ArrayList<UpdateRenderObj>();
	public static ArrayList<UpdateRenderObj> renderObjs = new ArrayList<UpdateRenderObj>();
	public static int GAMEWIDTH = Gdx.graphics.getWidth();
	public static int GAMEHEIGHT = Gdx.graphics.getHeight();
	
	public Menu() {
		cam = new OrthographicCamera();
		cam.setToOrtho(true, GAMEWIDTH, GAMEHEIGHT);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		renderer = new ShapeRenderer();
		renderer.setProjectionMatrix(cam.combined);
		
		shopButton = new ShopButton(true);
		trophyButton = new TrophyButton();
		ribbonButton = new RibbonButton();
		dropdown = new Dropdown(GAMEWIDTH/3, "HELLO");
		multiShopButton = new MultiplierShopButton(0, GAMEHEIGHT / 5, GAMEWIDTH, GAMEHEIGHT / 10, 9001);
	}
	
    public void update(float delta) {
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
		batcher.draw(AssetLoader.shopbackground, 0, 0, GAMEWIDTH, GAMEWIDTH*2); //sprite is 2000x4000 1x2 ratio
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
