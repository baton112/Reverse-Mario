package com.mygdx.game.mario.revrse.assets;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Assets {
	
	public static SpriteBatch batch; // to jest to do rysowania 
	
	public static Texture playerTexture;
	public static Texture arrows;
	
	public static void load(){
		batch = new SpriteBatch();
		
		playerTexture = new Texture("data/mario2.png");
		arrows = new Texture("data/arrows.png");
		Gdx.app.log("ASSETS LOAD", "zaladowano obrazki");
	} 
}
