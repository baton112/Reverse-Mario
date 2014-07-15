package com.mygdx.game.mario.revrse.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Assets {

	public static Texture playerTexture;
	public static SpriteBatch batch; // to jest to do rysowania 
	
	public static void load(){
		batch = new SpriteBatch();
		
		//playerTexture = new Texture(Gdx.files.internal("data/player.png"));
		Gdx.app.log("ASSETS LOAD", "zaladowano obrazki");
	} 
}
