package com.mygdx.game.mario.revrse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.mario.revrse.assets.Assets;
import com.mygdx.game.mario.revrse.screens.GameScreen;
import com.mygdx.game.mario.revrse.screens.MainMenuScreen;
import com.mygdx.game.mario.revrse.sounds.Sounds;

public class MyGdxGame extends Game {
	
	private static float screenHeight;
	private static float screenWidth;
	public static float resolutionScaleX;
	public static float resolutionScaleY;
	
	@Override
	public void create() {
		Assets.load();
		Sounds.load();
		
		setScreenWidth(Gdx.graphics.getWidth());
		setScreenHeight(Gdx.graphics.getHeight());
		
		resolutionScaleX = getScreenWidth() / 1280;
		resolutionScaleY = getScreenHeight() / 720;
		//setScreen(new MainMenuScreen(this));
		setScreen(new GameScreen(this));
	}
	
	public void startGame() {

		this.getScreen().dispose();
		setScreen(new GameScreen(this));
		
	}

	public static float getScreenHeight() {
		return screenHeight;
	}
	

	public static void setScreenHeight(float screenHeight) {
		MyGdxGame.screenHeight = screenHeight;
	}

	public float getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(float screenWidth) {
		MyGdxGame.screenWidth = screenWidth;
	}
	
	
	
}
