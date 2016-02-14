package org.qohs.clicker.screens.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ColorRetainingBitmapFont extends BitmapFont {

	/**
	 * 
	 * @author Derek Zhang
	 */
	
	private final Color color;
	
	public ColorRetainingBitmapFont() {
		this(Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"),
			false, true);
	}

	public ColorRetainingBitmapFont(boolean flip) {
		this(Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"),
			flip, true);
	}

	public ColorRetainingBitmapFont(FileHandle fontFile, TextureRegion region) {
		this(fontFile, region, false);
	}

	public ColorRetainingBitmapFont(FileHandle fontFile, TextureRegion region, boolean flip) {
		this(new BitmapFontData(fontFile, flip), region, true);
	}

	public ColorRetainingBitmapFont(FileHandle fontFile) {
		this(fontFile, false);
	}

	public ColorRetainingBitmapFont(FileHandle fontFile, boolean flip) {
		this(new BitmapFontData(fontFile, flip), (TextureRegion)null, true);
	}

	public ColorRetainingBitmapFont(FileHandle fontFile, FileHandle imageFile, boolean flip) {
		this(fontFile, imageFile, flip, true);
	}

	public ColorRetainingBitmapFont(FileHandle fontFile, FileHandle imageFile, boolean flip, boolean integer) {
		this(new BitmapFontData(fontFile, flip), new TextureRegion(new Texture(imageFile, false)), integer);
		super.setOwnsTexture(true);;
	}

	public ColorRetainingBitmapFont(BitmapFontData data, TextureRegion region, boolean integer) {
		this(data, region != null ? Array.with(region) : null, integer);
	}

	public ColorRetainingBitmapFont(BitmapFontData data, Array<TextureRegion> pageRegions, boolean integer) {

		super(data, pageRegions, integer);
		color = new Color();
		color.set(super.getColor());
	}
	
	@Override
	public Color getColor() {
		
		return color;
	}
}
