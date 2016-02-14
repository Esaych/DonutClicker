package org.qohs.clicker.screens.game.gameobjects;

import org.qohs.clicker.io.AssetLoader;
import org.qohs.clicker.screens.game.GameWorld;
import org.qohs.clicker.screens.util.UpdateRenderObj;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;

/**
 * a class that does "plus number"
 * @author Derek Zhang
 *
 */

public class PlusNumber implements UpdateRenderObj {

	private final String plusString;
	private float timePassed;
	private int y;
//	private float alphaWhite;
//	private float alphaBlack;
	private GlyphLayout glyphLayout;
	/*
    _______      ,-----.      .---.       ,-----.    .-------.     
   /   __  \   .'  .-,  '.    | ,_|     .'  .-,  '.  |  _ _   \    
  | ,_/  \__) / ,-.|  \ _ \ ,-./  )    / ,-.|  \ _ \ | ( ' )  |    
,-./  )      ;  \  '_ /  | :\  '_ '`) ;  \  '_ /  | :|(_ o _) /    
\  '_ '`)    |  _`,/ \ _/  | > (_)  ) |  _`,/ \ _/  || (_,_).' __  
 > (_)  )  __: (  '\_/ \   ;(  .  .-' : (  '\_/ \   ;|  |\ \  |  | 
(  .  .-'_/  )\ `"/  \  ) /  `-'`-'|___\ `"/  \  ) / |  | \ `'   / 
 `-'`-'     /  '. \_/``".'    |        \'. \_/``".'  |  |  \    /  
   `._____.'     '-----'      `--------`  '-----'    ''-'   `'-'   
 ______         ,-----.        .-''-.     .-'''-.  
|    _ `''.   .'  .-,  '.    .'_ _   \   / _     \ 
| _ | ) _  \ / ,-.|  \ _ \  / ( ` )   ' (`' )/`--' 
|( ''_'  ) |;  \  '_ /  | :. (_ o _)  |(_ o _).    
| . (_) `. ||  _`,/ \ _/  ||  (_,_)___| (_,_). '.  
|(_    ._) ': (  '\_/ \   ;'  \   .---..---.  \  : 
|  (_.\.' /  \ `"/  \  ) /  \  `-'    /\    `-'  | 
|       .'    '. \_/``".'    \       /  \       /  
'-----'`        '-----'       `'-..-'    `-...-'   
,---.   .--.    ,-----.  ,---------. .---.  .---..-./`) ,---.   .--.  .-_'''-.    
|    \  |  |  .'  .-,  '.\          \|   |  |_ _|\ .-.')|    \  |  | '_( )_   \   
|  ,  \ |  | / ,-.|  \ _ \`--.  ,---'|   |  ( ' )/ `-' \|  ,  \ |  ||(_ o _)|  '  
|  |\_ \|  |;  \  '_ /  | :  |   \   |   '-(_{;}_)`-'`"`|  |\_ \|  |. (_,_)/___|  
|  _( )_\  ||  _`,/ \ _/  |  :_ _:   |      (_,_) .---. |  _( )_\  ||  |  .-----. 
| (_ o _)  |: (  '\_/ \   ;  (_I_)   | _ _--.   | |   | | (_ o _)  |'  \  '-   .' 
|  (_,_)\  | \ `"/  \  ) /  (_(=)_)  |( ' ) |   | |   | |  (_,_)\  | \  `-'`   |  
|  |    |  |  '. \_/``".'    (_I_)   (_{;}_)|   | |   | |  |    |  |  \        /  
'--'    '--'    '-----'      '---'   '(_,_) '---' '---' '--'    '--'   `'-...-'   

	 */
	private Color white;
	private Color black;
	private Color whiteEnd;
	private Color blackEnd;
	private Actor fader;
	
	public PlusNumber(int addition) {
		
		plusString = "+" + addition;
		timePassed = 0;
		y = GameWorld.GAMEHEIGHT/2;
//		alphaWhite = 1;
//		alphaBlack = 1;
		glyphLayout = new GlyphLayout();
		glyphLayout.setText(AssetLoader.score_font, plusString);
		white = new Color(AssetLoader.score_font.getColor());
		black = new Color(AssetLoader.score_shadow_font.getColor());
		whiteEnd = new Color(255, 0, 0, 0);
		blackEnd = new Color(black.r, black.g, black.b, 0);
		fader = new Actor();
		AlphaAction fadeAction = Actions.fadeOut(2);
		fadeAction.setColor(white);
		fader.addAction(fadeAction);
		fadeAction = Actions.fadeOut(1);
		fadeAction.setColor(black);
		fader.addAction(fadeAction);
		GameWorld.registerUpdates(this, true, true);
	}

	public void update(float delta) {

//		timePassed += delta;
//		
//		if (timePassed >= .01) {
//			
//			white.lerp(whiteEnd, .9f);
//			black.lerp(blackEnd, .9f);
//			
//			timePassed = 0;
//		}
		
		fader.act(delta);
			
//			alphaWhite = Math.max(alphaWhite - .01f, 0);
//			alphaBlack = Math.max(alphaBlack - .02f, 0);
		
		y -= 3;
		if (y <= 0 || black.a <= 0) {
			
			GameWorld.removeUpdates(this);
		}
	}

	public void render(SpriteBatch batcher, ShapeRenderer renderer) {
			
		batcher.begin();
		float w = glyphLayout.width;
//		Color color;
//		color = AssetLoader.score_shadow_font.getColor();
		AssetLoader.score_shadow_font.setColor(black);
		//batcher.setColor(black);
		AssetLoader.score_shadow_font.draw(batcher, glyphLayout, (GameWorld.GAMEWIDTH - w)/2+2, y+2);
//		color = AssetLoader.score_font.getColor();
		AssetLoader.score_font.setColor(white);
		//batcher.setColor(white);
		AssetLoader.score_font.draw(batcher, glyphLayout, (GameWorld.GAMEWIDTH - w)/2, y);
		batcher.end();
		AssetLoader.score_shadow_font.setColor(AssetLoader.score_shadow_font.getColor());
		AssetLoader.score_font.setColor(AssetLoader.score_font.getColor());
	}
}
